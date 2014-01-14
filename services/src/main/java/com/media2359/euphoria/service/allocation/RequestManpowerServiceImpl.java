package com.media2359.euphoria.service.allocation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.manpower.PlatformRequestDAO;
import com.media2359.euphoria.dao.manpower.WeeklyManpowerRequestDAO;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.manpower.PlatformRequest;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.manpower.DailyResourcePlanDTO;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.server.allocation.RequestManpowerService;



@Service("RequestManpowerService")
public class RequestManpowerServiceImpl implements RequestManpowerService {

	@Autowired
	WeeklyManpowerRequestDAO weeklyManpowerRequestDao ;
	
	@Autowired
	PlatformRequestDAO platformRequestDao;            
	
	@Override
	public ProjectAllocationDTO requestManpower(ProjectDTO projectDto,
			Date startDate) {
		ProjectAllocationDTO projectAllocationDTO = null;
		
		try{
			projectAllocationDTO = new ProjectAllocationDTO();
			Project project = new Project();
			project.setId(projectDto.getId());
			
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(startDate);
			gregorianCalendar.add(Calendar.DATE, 7);
			
			Date endDate = new Date();
			endDate.setTime(gregorianCalendar.getTime().getTime());
			
			System.out.println("THE END DATE CALCULATED IS "+endDate);
			
			
			List<WeeklyManpowerRequest> weeklyManpowerReqList = 
					weeklyManpowerRequestDao.findAllWklyMpowerRqstByProjectWeek(startDate, endDate, 
							project);
			if(weeklyManpowerReqList!=null && weeklyManpowerReqList.size()>0){
				System.out.println("Size of WeeklyManpower Request is "+weeklyManpowerReqList.size());
				
				List<WeeklyResourcePlan> weeklyResourcePlanList = new ArrayList<WeeklyResourcePlan>();
				List<PlatformRequest> platformReqList = platformRequestDao.findAllPlatformRequest(weeklyManpowerReqList.get(0));
				
				projectAllocationDTO.setProjectId(project.getId());
				projectAllocationDTO.setStartOfWeek(startDate);
				
				for(PlatformRequest platformreq : platformReqList){
					WeeklyResourcePlan weeklyResourcePlan = new WeeklyResourcePlan();
					
					// Set the platform 
					weeklyResourcePlan.setPlatform(platformreq.getPlatform().createPlatformDTO());
					// Set the developer
					weeklyResourcePlan.setDeveloper(platformreq.getEmployee().createEmployeeDTO());
					
					// Set the resource plan
					Integer startDayOfTheWeek ;
					Integer endDayOfTheWeek;
					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(platformreq.getStartDate());
					startDayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
					
					calendar.setTime(platformreq.getEndDate());
					endDayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
					
					System.out.println("THE START DAY OF THE WEEK IS "+startDayOfTheWeek+" : END DAY "
							+ "OF THE WEEK IS "+endDayOfTheWeek);
					
					for(int i=startDayOfTheWeek ;i<=endDayOfTheWeek;i++){
						String methodName = "setDay"+String.valueOf(i);
						String amMethodName = methodName+"Am";
						String pmMethodName = methodName+"Pm";
						
						Method method =weeklyResourcePlan.getClass().getMethod(amMethodName, 
								new Class<?>[0]);
						method.invoke(weeklyResourcePlan, new Boolean(true));
						
						method =weeklyResourcePlan.getClass().getMethod(pmMethodName, 
								new Class<?>[0]);
						method.invoke(weeklyResourcePlan, new Boolean(true));
						
					}
					
					weeklyResourcePlanList.add(weeklyResourcePlan);
				}
				
				projectAllocationDTO.setWeeklyResourcePlan(weeklyResourcePlanList);
				
			}
			
			
			
		}catch(Exception exp){
			exp.printStackTrace();
		}
		
		return projectAllocationDTO;
		
	}

	@Override
	public String submitManpowerRequest(
			ProjectAllocationDTO projectAllocationDto) {
		
		String result = "SUCCESS";
		WeeklyManpowerRequest weeklyManpowerRequest = null;
		List<PlatformRequest> platformRequestList = null;
		try{
			weeklyManpowerRequest = new WeeklyManpowerRequest();
			platformRequestList = new ArrayList<PlatformRequest>();
			
			Project project = new Project();
			project.setId(projectAllocationDto.getProjectId());
			weeklyManpowerRequest.setProject(project);
			weeklyManpowerRequest.setStartDate(projectAllocationDto.getStartOfWeek());
			
			// Adding 7 days to the start date to form the end date 
			Date startofWeek = projectAllocationDto.getStartOfWeek();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(startofWeek);
			calendar.add(Calendar.DATE, 6);
			
			Date endOfWeek = new Date();
			endOfWeek.setTime(calendar.getTime().getTime());
			weeklyManpowerRequest.setEndDate(endOfWeek);
			weeklyManpowerRequest.setCreatedBy("SYSTEM");
			
			System.out.println("THE END DATE CALCULATED IS "+endOfWeek);
			
			weeklyManpowerRequest.setCreatedTstmp(new Date());
			
			List<WeeklyResourcePlan> weeklyResourcePlans = projectAllocationDto.getWeeklyResourcePlan();
			platformRequestList = new ArrayList<PlatformRequest>();
			
			for(WeeklyResourcePlan weeklyResourcePlan : weeklyResourcePlans){
				
				List<DailyResourcePlanDTO> startDaysList = findStartDays(weeklyResourcePlan);
				
				if(startDaysList!=null)
					System.out.println("SIZE OF THE STARTLIST "+startDaysList.size());
				
				for(DailyResourcePlanDTO dailyResourcePlanDTO: startDaysList){
					
					System.out.println("Daily Plan Day "+dailyResourcePlanDTO.getDay()+""
							+ " Daily Resource Play Half "+dailyResourcePlanDTO.getHalf());
					
					PlatformRequest platformRequest = new PlatformRequest();
					platformRequest.setWeeklyManpowerRequest(weeklyManpowerRequest);
					platformRequest.setEmployee(prepareEmployee
							(weeklyResourcePlan.getDeveloper()));
					Date endDate =getEndDate(weeklyResourcePlan, dailyResourcePlanDTO,
							projectAllocationDto.getStartOfWeek());
					
					System.out.println("End  Date is "+endDate);
					platformRequest.setEndDate(endDate);
					//platformRequestList.add(platformRequest);
					platformRequestDao.addPlatformRequest(platformRequest);
					
				}
			
			}
			
		}catch(Exception exp){
			exp.printStackTrace();
			result="FAILED";
		}
		
		return result;
	}
	
	
	private Employee prepareEmployee(EmployeeDTO employeeDto){
		
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setMobile(employeeDto.getMobile());
		employee.setPersonalEmail(employeeDto.getPersonalEmail());
		employee.setCompanyEmail(employeeDto.getCompanyEmail());
		employee.setDesignation(employeeDto.getDesignation());
		
		Set<Platform> platformSet = new HashSet<Platform>();
		Set<PlatformDTO> platformDtos = employeeDto.getPlatFormDtos();
		for(PlatformDTO platformDTO : platformDtos){
			Platform platform = new Platform();
			platform.setPlatformId(platformDTO.getPlatformId());
			platform.setPlatformKey(platformDTO.getPlatformKey());
			platformSet.add(platform);
		}
		
		employee.setPlatForms(platformSet);
		employee.setAssignedOffice(employeeDto.getAssignedOffice());
		employee.setEmploymentType(employeeDto.getEmploymentType());
		employee.setStartDate(employeeDto.getStartDate());
		employee.setEndDate(employeeDto.getEndDate());
		employee.setMandayRate(employeeDto.getMandayRate());
		return employee;
		
	}
	
	
	private List<DailyResourcePlanDTO> findStartDays(WeeklyResourcePlan weeklyResourcePlan){
		List<DailyResourcePlanDTO> startDaysList = new  ArrayList<DailyResourcePlanDTO>();
		
		boolean continuation = false;
		
		if(weeklyResourcePlan.getDay1Am()){
			DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
			dailyResourcePlanDTO.setDay(1);
			dailyResourcePlanDTO.setHalf("AM");
			startDaysList.add(dailyResourcePlanDTO);
			continuation =true;
		}
			
		if(weeklyResourcePlan.getDay1Pm()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(1);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
		}else{
			continuation = false;
		}
		
		// Read Day 2 
		
		if(weeklyResourcePlan.getDay2Am()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(2);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
		}else{
			continuation = false;
		}
		
		if(weeklyResourcePlan.getDay2Pm()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(2);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
			
		}else{
			continuation = false;
		}
			
		
		
		// Read Day 3
		
		if(weeklyResourcePlan.getDay3Am()){
			
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(3);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
		}else{
			continuation = false;
		}
		
		if(weeklyResourcePlan.getDay3Pm()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(3);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
		}else{
			continuation = false;
		}
		
		// Read Day 4
		
		
		if(weeklyResourcePlan.getDay4Am()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(4);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
		}else{
			continuation = false;
		}
		
		if(weeklyResourcePlan.getDay4Pm()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(4);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
			
		}else{
			continuation = false;
		}
		
		// Read Day 5
		
		if(weeklyResourcePlan.getDay5Am()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(5);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
			
		}else{
			continuation = false;
		}
		
		if(weeklyResourcePlan.getDay5Pm()){
			
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(5);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
			
		}else{
			continuation = false;
		}
		
		// Read Day 6
		if(weeklyResourcePlan.getDay6Am()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(6);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
			
		}else{
			continuation = false;
		}
		
		if(weeklyResourcePlan.getDay6Pm()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(6);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
		}else{
			continuation = false;
		}
		
		// Read Day 7
		
		if(weeklyResourcePlan.getDay7Am()){
			
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(7);
				dailyResourcePlanDTO.setHalf("AM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
			
		}else{
			continuation = false;
		}
		
		if(weeklyResourcePlan.getDay7Pm()){
			if(!continuation){
				DailyResourcePlanDTO dailyResourcePlanDTO = new DailyResourcePlanDTO();
				dailyResourcePlanDTO.setDay(7);
				dailyResourcePlanDTO.setHalf("PM");
				startDaysList.add(dailyResourcePlanDTO);
				continuation =true;
			}
		}else{
			continuation = false;
		}
		
		return startDaysList;
		
		
	}
	
	
	private Date getEndDate(WeeklyResourcePlan weeklyResourcePlan, 
			DailyResourcePlanDTO startDatePlanDTO,Date startofWeek) throws Exception{
		
		Integer day=0;
		String half ="";
		
		/*
		int nextStartDay =1;
		if(startDatePlanDTO.getHalf().equals("AM") && startDatePlanDTO.getDay()!=1)
			nextStartDay= startDatePlanDTO.getDay()-1;
		else if(startDatePlanDTO.getHalf().equals("PM"))
			nextStartDay = startDatePlanDTO.getDay();
		*/
		int nextStartDay= startDatePlanDTO.getDay();
		
		for(int i=nextStartDay ;i<=7;i++){
			String methodName = "getDay"+String.valueOf(i);
			String amMethodName = methodName+"Am";
			String pmMethodName = methodName+"Pm";
			Method method =weeklyResourcePlan.getClass().getMethod(amMethodName, 
					new Class<?>[0]);
			Object obj= method.invoke(weeklyResourcePlan, null);
			Boolean flag = (Boolean) obj;
			System.out.println("I IS "+i+" : Flag is "+flag);
			if(!flag){
				day=i-1;
				half="PM";
				break;
				
			}else{
				method = weeklyResourcePlan.getClass().getMethod(pmMethodName, 
						new Class<?>[0]);
				obj= method.invoke(weeklyResourcePlan, null);
				flag = (Boolean) obj;
				if(!flag){
					day=i;
					half="AM";
					break;
				}
			}
		}
		
		
		System.out.println("CALCULATE END OF MANPOWER DATE , Day is "+day+" : Half is "+half);
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startofWeek);
		calendar.add(Calendar.DATE, day-1);
		Date endOfWeek = new Date();
		endOfWeek.setTime(calendar.getTime().getTime());
		
		
		return endOfWeek;
	}
	
	

}
