package com.media2359.euphoria.service.allocation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.employee.EmployeeDAO;
import com.media2359.euphoria.dao.employee.EmployeeLeaveDAO;
import com.media2359.euphoria.dao.employee.HolidayDAO;
import com.media2359.euphoria.dao.manpower.PlatformRequestDAO;
import com.media2359.euphoria.dao.manpower.WeeklyManpowerRequestDAO;
import com.media2359.euphoria.dao.user.Role;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.employee.EmployeeLeave;
import com.media2359.euphoria.model.employee.Holiday;
import com.media2359.euphoria.model.manpower.PlatformRequest;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.service.email.EmailService;
import com.media2359.euphoria.view.dto.manpower.DailyResourcePlanDTO;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.util.AllocationStatus;
import com.media2359.euphoria.view.server.allocation.RequestManpowerService;

@Service("RequestManpowerService")
public class RequestManpowerServiceImpl implements RequestManpowerService {

	@Autowired
	WeeklyManpowerRequestDAO weeklyManpowerRequestDao;

	@Autowired
	PlatformRequestDAO platformRequestDao;

	@Autowired
	EmployeeLeaveDAO employeeLeaveDao;

	@Autowired
	EmployeeDAO employeeDao;

	@Autowired
	HolidayDAO holidayDao;

	@Autowired
	EmailService emailService;
	
	private final Logger log = Logger.getLogger(RequestManpowerServiceImpl.class);

	@Override
	public ProjectAllocationDTO requestManpower(ProjectDTO projectDto,
			Date startDate) {
		ProjectAllocationDTO projectAllocationDTO = null;

		try {
			projectAllocationDTO = new ProjectAllocationDTO();
			Project project = new Project();
			project.setId(projectDto.getId());

			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(startDate);
			gregorianCalendar.add(Calendar.DATE, 6);

			Date endDate = new Date();
			endDate.setTime(gregorianCalendar.getTime().getTime());

			System.out.println("THE END DATE CALCULATED IS " + endDate);

			List<WeeklyManpowerRequest> weeklyManpowerReqList = weeklyManpowerRequestDao
					.findAllWklyMpowerRqstByProjectWeek(startDate, endDate,
							project);
			if (weeklyManpowerReqList != null
					&& weeklyManpowerReqList.size() > 0) {
				System.out.println("Size of WeeklyManpower Request is "
						+ weeklyManpowerReqList.size());

				List<WeeklyResourcePlan> weeklyResourcePlanList = new ArrayList<WeeklyResourcePlan>();
				List<PlatformRequest> platformReqList = platformRequestDao
						.findAllPlatformRequest(weeklyManpowerReqList.get(0));

				projectAllocationDTO.setProjectDTO(project.createProjectDTO());
				projectAllocationDTO.setStartOfWeek(startDate);

				// Get all the distinct platoform-developer combinatiion

				List<String> platformDeveloperList = getDistinctDevelopers(platformReqList);

				// For Each platform developer combination , find the list of
				// the platformRequest
				for (String platformDeveloper : platformDeveloperList) {
					List<PlatformRequest> developerPlatformReqList = getPlatformRequestList(
							platformDeveloper, platformReqList);
					// Form a object of weeklyresource plan

					WeeklyResourcePlan weeklyResourcePlan = new WeeklyResourcePlan();

					weeklyResourcePlan.setPlatform(developerPlatformReqList
							.get(0).getPlatform().createPlatformDTO());
					// Set the developer
					weeklyResourcePlan.setDeveloper(developerPlatformReqList
							.get(0).getEmployee().createEmployeeDTO());

					for (PlatformRequest platformReq : developerPlatformReqList) {

						// Set the resource plan
						Integer startDayOfTheWeek;
						Integer endDayOfTheWeek;

						System.out.println("Platform Request Start Date is ["+platformReq.getStartDate()+"]"
								+ ": End Date is ["+platformReq.getEndDate()+"] ");
						
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(platformReq.getStartDate());
						startDayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);

						calendar.setTime(platformReq.getEndDate());
						endDayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);

						System.out.println("THE START DAY OF THE WEEK IS "
								+ startDayOfTheWeek + " : END DAY "
								+ "OF THE WEEK IS " + endDayOfTheWeek);

						for (int i = startDayOfTheWeek; i <= endDayOfTheWeek; i++) {

							Method method;
							Object returnObj;
							String getMethodName = "getDay" + String.valueOf(i);
							String setMethodName = "setDay" + String.valueOf(i);
							String methodName;

							methodName = getMethodName + "Am";
							method = weeklyResourcePlan.getClass().getMethod(
									methodName, new Class<?>[0]);
							returnObj = method.invoke(weeklyResourcePlan, null);

							// Enter if false
							if (!(Boolean) returnObj) {
								methodName = setMethodName + "Am";

								Class[] paramBoolean = new Class[1];
								paramBoolean[0] = Boolean.class;
								method = weeklyResourcePlan.getClass()
										.getMethod(methodName, paramBoolean);
								method.invoke(weeklyResourcePlan, new Boolean(
										true));
								setValue(weeklyResourcePlan,
										methodName + "Enm", platformReq, i);
							}

							methodName = getMethodName + "Pm";
							method = weeklyResourcePlan.getClass().getMethod(
									methodName, new Class<?>[0]);
							returnObj = method.invoke(weeklyResourcePlan, null);

							// Enter if false
							if (!(Boolean) returnObj) {
								methodName = setMethodName + "Pm";

								Class[] paramBoolean = new Class[1];
								paramBoolean[0] = Boolean.class;
								method = weeklyResourcePlan.getClass()
										.getMethod(methodName, paramBoolean);
								method.invoke(weeklyResourcePlan, new Boolean(
										true));
								setValue(weeklyResourcePlan,
										methodName + "Enm", platformReq, i);
							}

						}

					}
					weeklyResourcePlanList.add(weeklyResourcePlan);

				}

				projectAllocationDTO
						.setWeeklyResourcePlanList(weeklyResourcePlanList);

			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}

		return projectAllocationDTO;

	}

	private void setValue(WeeklyResourcePlan weeklyResourcePlan,
			String methodName, PlatformRequest platformReq, Integer day)
			throws Exception {

		System.out.println("Inside setValue : day is " + day
				+ " : Method Name is " + methodName);
		Method method;
		// Remember while storing we store only the Non Free Days
		if (isLeave(platformReq, day)) {
			Class[] allocationStatusClass = new Class[1];
			allocationStatusClass[0] = AllocationStatus.class;
			method = weeklyResourcePlan.getClass().getMethod(methodName,
					allocationStatusClass);
			method.invoke(weeklyResourcePlan, AllocationStatus.LEAVE);
		}

		// CHeck if Holiday
		else if (isHoliday(platformReq, day)) {
			Class[] allocationStatusClass = new Class[1];
			allocationStatusClass[0] = AllocationStatus.class;

			method = weeklyResourcePlan.getClass().getMethod(methodName,
					allocationStatusClass);
			method.invoke(weeklyResourcePlan, AllocationStatus.HOLIDAY);
		}

		// Check if Selected
		else if ("A".equals(platformReq.getWeeklyManpowerRequest()
				.getApprovalStatus())) {
			Class[] allocationStatusClass = new Class[1];
			allocationStatusClass[0] = AllocationStatus.class;
			method = weeklyResourcePlan.getClass().getMethod(methodName,
					allocationStatusClass);
			method.invoke(weeklyResourcePlan, AllocationStatus.ALLOCATED);
		}

		// Check if Selected
		else if ("U".equals(platformReq.getWeeklyManpowerRequest()
				.getApprovalStatus())) {
			Class[] allocationStatusClass = new Class[1];
			allocationStatusClass[0] = AllocationStatus.class;
			method = weeklyResourcePlan.getClass().getMethod(methodName,
					allocationStatusClass);
			method.invoke(weeklyResourcePlan, AllocationStatus.SELECTED);
		}

	}

	@Override
	public String submitManpowerRequest(
			ProjectAllocationDTO projectAllocationDto) {

		String result = "SUCCESS";
		WeeklyManpowerRequest weeklyManpowerRequest = null;

		try {
			weeklyManpowerRequest = new WeeklyManpowerRequest();

			Project project = new Project(projectAllocationDto.getProjectDTO());
			weeklyManpowerRequest.setProject(project);
			weeklyManpowerRequest.setStartDate(projectAllocationDto
					.getStartOfWeek());

			// Adding 7 days to the start date to form the end date
			Date startofWeek = projectAllocationDto.getStartOfWeek();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(startofWeek);
			calendar.add(Calendar.DATE, 6);

			Date endOfWeek = new Date();
			endOfWeek.setTime(calendar.getTime().getTime());
			weeklyManpowerRequest.setEndDate(endOfWeek);
			weeklyManpowerRequest.setCreatedBy("SYSTEM");

			System.out.println("THE END DATE CALCULATED IS " + endOfWeek);

			weeklyManpowerRequest.setCreatedTstmp(new Date());

			weeklyManpowerRequest.setApprovalStatus("U");

			// Delete the weekly manpower request
			weeklyManpowerRequestDao.deleteWeeklyManpowerRequest(project, startofWeek, endOfWeek);
			// Persists Weekly manpower request
			weeklyManpowerRequestDao
					.addWeeklyManpowerRequest(weeklyManpowerRequest);

			List<WeeklyResourcePlan> weeklyResourcePlans = projectAllocationDto
					.getWeeklyResourcePlanList();
			// platformRequestList = new ArrayList<PlatformRequest>();

			for (WeeklyResourcePlan weeklyResourcePlan : weeklyResourcePlans) {

				List<DailyResourcePlanDTO> startDaysList = findStartDays(weeklyResourcePlan);

				System.out.println("Start Day List is "+startDaysList);

				for (DailyResourcePlanDTO dailyResourcePlanDTO : startDaysList) {

					System.out.println("Daily Plan Day "
							+ dailyResourcePlanDTO.getDay() + ""
							+ " Daily Resource Play Half "
							+ dailyResourcePlanDTO.getHalf());

					PlatformRequest platformRequest = new PlatformRequest();
					platformRequest
							.setWeeklyManpowerRequest(weeklyManpowerRequest);
					platformRequest.setEmployee(new Employee(
							(weeklyResourcePlan.getDeveloper())));
					platformRequest.setPlatform(new Platform(weeklyResourcePlan
							.getPlatform()));

					// Set the start date of the platform request
					platformRequest.setStartDate(getStartDate(startofWeek,
							dailyResourcePlanDTO));

					// Set the end date of the platform request
					Date endDate = getEndDate(weeklyResourcePlan,
							dailyResourcePlanDTO,
							projectAllocationDto.getStartOfWeek());

					System.out.println("End  Date is " + endDate);
					platformRequest.setEndDate(endDate);

					platformRequest.setCreateById("SYSTEM");
					platformRequest.setCreateTstamp(new Date());
					// platformRequestList.add(platformRequest);
					platformRequestDao.addPlatformRequest(platformRequest);

				}

			}
			try {
				sendAllocationNotification(project);
			} catch(Throwable t) {
				log.warn("Failed to send email. Skipping email notification", t);
			}

		} catch (Exception exp) {
			exp.printStackTrace();
			result = "FAILED";
		}

		return result;
	}

	private List<DailyResourcePlanDTO> findStartDays(
			WeeklyResourcePlan weeklyResourcePlan) {
		List<DailyResourcePlanDTO> startDaysList = new ArrayList<DailyResourcePlanDTO>();

		boolean continuation = false;

		if (weeklyResourcePlan.getDay1AmEnm() != AllocationStatus.FREE) {
			DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
			dailyResourcePlanDTO.setDay(1);
			dailyResourcePlanDTO.setHalf("AM");
			startDaysList.add(dailyResourcePlanDTO);
			continuation = true;
		}

		if (weeklyResourcePlan.getDay1PmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(1);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}
		} else {
			continuation = false;
		}

		// Read Day 2

		if (weeklyResourcePlan.getDay2AmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(2);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}
		} else {
			continuation = false;
		}

		if (weeklyResourcePlan.getDay2PmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(2);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}

		} else {
			continuation = false;
		}

		// Read Day 3

		if (weeklyResourcePlan.getDay3AmEnm() != AllocationStatus.FREE) {

			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(3);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}
		} else {
			continuation = false;
		}

		if (weeklyResourcePlan.getDay3PmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(3);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}
		} else {
			continuation = false;
		}

		// Read Day 4

		if (weeklyResourcePlan.getDay4AmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(4);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}
		} else {
			continuation = false;
		}

		if (weeklyResourcePlan.getDay4PmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(4);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}

		} else {
			continuation = false;
		}

		// Read Day 5

		if (weeklyResourcePlan.getDay5AmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(5);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}

		} else {
			continuation = false;
		}

		if (weeklyResourcePlan.getDay5PmEnm() != AllocationStatus.FREE) {

			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(5);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}

		} else {
			continuation = false;
		}

		// Read Day 6
		if (weeklyResourcePlan.getDay6AmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(6);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}

		} else {
			continuation = false;
		}

		if (weeklyResourcePlan.getDay6PmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(6);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}
		} else {
			continuation = false;
		}

		// Read Day 7

		if (weeklyResourcePlan.getDay7AmEnm() != AllocationStatus.FREE) {

			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(7);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}

		} else {
			continuation = false;
		}

		if (weeklyResourcePlan.getDay7PmEnm() != AllocationStatus.FREE) {
			if (!continuation) {
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(7);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation = true;
			}
		} else {
			continuation = false;
		}

		return startDaysList;

	}

	private Date getStartDate(Date startofWeek,
			DailyResourcePlanDTO dailyResourcePlanDTO) throws Exception {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startofWeek);
		calendar.add(Calendar.DATE, dailyResourcePlanDTO.getDay() - 2);

		Date platformStartDate = new Date();
		platformStartDate.setTime(calendar.getTime().getTime());

		System.out.println("Platform Start Date is " + platformStartDate);

		return platformStartDate;
	}

	private Date getEndDate(WeeklyResourcePlan weeklyResourcePlan,
			DailyResourcePlanDTO startDatePlanDTO, Date startofWeek)
			throws Exception {

		Integer day = 0;
		String half = "";

		/*
		 * int nextStartDay =1; if(startDatePlanDTO.getHalf().equals("AM") &&
		 * startDatePlanDTO.getDay()!=1) nextStartDay=
		 * startDatePlanDTO.getDay()-1; else
		 * if(startDatePlanDTO.getHalf().equals("PM")) nextStartDay =
		 * startDatePlanDTO.getDay();
		 */
		int nextStartDay = startDatePlanDTO.getDay();

		for (int i = nextStartDay; i <= 7; i++) {
			String methodName = "getDay" + String.valueOf(i);
			String amMethodName = methodName + "AmEnm";
			String pmMethodName = methodName + "PmEnm";
			Method method = weeklyResourcePlan.getClass().getMethod(
					amMethodName, new Class<?>[0]);
			Object obj = method.invoke(weeklyResourcePlan, null);
			AllocationStatus allocationStatus = (AllocationStatus) obj;
			System.out.println("I IS " + i + " : Allocation Status is "
					+ allocationStatus);
			if (allocationStatus == AllocationStatus.FREE) {
				day = i - 1;
				half = "PM";
				break;

			} else {
				method = weeklyResourcePlan.getClass().getMethod(pmMethodName,
						new Class<?>[0]);
				obj = method.invoke(weeklyResourcePlan, null);
				allocationStatus = (AllocationStatus) obj;
				System.out.println("I IS " + i + " : Allocation Status is "
						+ allocationStatus);
				if (allocationStatus == AllocationStatus.FREE) {
					day = i;
					half = "AM";
					break;
				}
			}
		}

		// TODO Set proper date and time in the database
		System.out.println("CALCULATE END OF MANPOWER DATE , Day is " + day
				+ " : Half is " + half);

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startofWeek);
		calendar.add(Calendar.DATE, day - 2);
		Date endOfWeek = new Date();
		endOfWeek.setTime(calendar.getTime().getTime());

		return endOfWeek;
	}

	/*
	 * This function is to get the List of distinct combination of developers
	 * and platforms
	 */
	private List<String> getDistinctDevelopers(
			List<PlatformRequest> platformRequestList) {

		List<String> developerPlatformList = new ArrayList<String>();
		for (PlatformRequest platformRequest : platformRequestList) {
			String developerPlatform = String.valueOf(platformRequest
					.getPlatform().getPlatformKey())
					+ "-"
					+ String.valueOf(platformRequest.getEmployee()
							.getEmployeeKey());
			System.out.println("Developer Name is " + developerPlatform);
			if (!developerPlatformList.contains(developerPlatform)) {
				developerPlatformList.add(developerPlatform);
			}
		}
		return developerPlatformList;
	}

	/*
	 * Gets the list of a platform request for a developer
	 */

	private List<PlatformRequest> getPlatformRequestList(
			String toBeSearchedDeveloperPlatform,
			List<PlatformRequest> platformReqList) {
		List<PlatformRequest> platformReqs = new ArrayList<PlatformRequest>();

		for (PlatformRequest platformRequest : platformReqList) {
			String developerPlatform = String.valueOf(platformRequest
					.getPlatform().getPlatformKey())
					+ "-"
					+ String.valueOf(platformRequest.getEmployee()
							.getEmployeeKey());
			if (developerPlatform.equals(toBeSearchedDeveloperPlatform))
				platformReqs.add(platformRequest);
		}

		System.out.println("Platform Request length is " + platformReqs.size());
		return platformReqs;
	}

	/*
	 * Find out if it is a holiday or not
	 */
	private Boolean isHoliday(PlatformRequest platformRequest, int day) {

		List<Holiday> holidayList = holidayDao.getAllHolidaysByRange(
				platformRequest.getStartDate(), platformRequest.getEndDate());
		for (Holiday holiday : holidayList) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(holiday.getHolidayDate());
			int holidayDay = cal.get(Calendar.DAY_OF_WEEK);
			if (day == holidayDay)
				return true;
		}

		return false;
	}

	/*
	 * Find out if it is a Leave Day or not
	 */

	private Boolean isLeave(PlatformRequest platformRequest, int day) {
		List<EmployeeLeave> empLeaveList = employeeLeaveDao
				.getAllLeavesByEmployee(platformRequest.getEmployee(),
						platformRequest.getStartDate(),
						platformRequest.getEndDate());

		for (EmployeeLeave employeeLeave : empLeaveList) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(employeeLeave.getLeaveDate());
			int leaveDay = cal.get(Calendar.DAY_OF_WEEK);
			if (day == leaveDay)
				return true;
		}

		return false;
	}

	/*
	 * Returns if the project has exceeded the mandays
	 */
	private Boolean isExceeded(ProjectDTO project) {
		return false;
	}

	/**
	 * Method to support email notification
	 *
	 * @returns void
	 */
	private void sendAllocationNotification(Project project) {
		List<Employee> employees = employeeDao.getEmployeesByRole(Role.VP
				.getCode());

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String email = auth.getName(); // get email of logged in user

		if ((employees != null) && (!employees.isEmpty())) {
			//List<String> emailList = new ArrayList<String>();
			String[] emailArray = new String[employees.size()+1];
			int i =0;
			for (Employee employee : employees) {
				//emailList.add(employee.getCompanyEmail());
				emailArray[i++]=employee.getCompanyEmail();
			}
			if(email != null) { //Add email of originator also
				//emailList.add(email);
				emailArray[i]=email;
			}
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append("A new project allocation " + project.getName()
					+ " was created by "+email+" on "+(new Date()));
			bodyBuffer
					.append("Please login to http://euphoria.herokuapp.com to review the allocation.\r\n");
			bodyBuffer.append("\r\n\r\nRegards,");
			bodyBuffer.append("Euphoria Project Administrator");
			
			
			/*
			emailService.sendEmail((String [])emailList.toArray(), "New allocation request for "
					+ project.getName(), bodyBuffer.toString());*/
			emailService.sendEmail(emailArray, "New allocation request for "
					+ project.getName(), bodyBuffer.toString());
		} else {
			log.info("There were no recipients to send email to ");
		}
	}

}
