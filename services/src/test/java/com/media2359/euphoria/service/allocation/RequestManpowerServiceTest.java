package com.media2359.euphoria.service.allocation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.google.gwt.dev.jjs.impl.AssertionNormalizer;
import com.ibm.icu.text.SimpleDateFormat;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.util.AllocationStatus;
import com.media2359.euphoria.view.server.allocation.RequestManpowerService;
import com.media2359.euphoria.view.server.project.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RequestManpowerServiceTest {
	
	@Autowired
	RequestManpowerService requestManpowerService;
	
	@Autowired
	ProjectService projectService;
	
	ProjectDTO projectDTO;
	Date startOfWeek ;
	
	ProjectAllocationDTO projectAllocationDTO;
	
	
	@Before
	public void setUp(){
		
		projectAllocationDTO = new ProjectAllocationDTO();
		//Integer projectId = projectService.getMaxKey();
		Integer projectId =2;
		projectDTO = projectService.getProjectDetails(projectId);
		
		projectAllocationDTO.setProjectDTO(projectDTO);
		
		
		
		try{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
			startOfWeek = simpleDateFormat.parse("03-02-2014");
			
			System.out.println("+++START DATE++++ "+startOfWeek);
			projectAllocationDTO.setStartOfWeek(startOfWeek);
			
		}catch(Exception exp){
			
		}
		
		List<WeeklyResourcePlan> weeklyResourcePlanList = new ArrayList<WeeklyResourcePlan>();
		
		WeeklyResourcePlan weeklyResourcePlan = new WeeklyResourcePlan();
		
		weeklyResourcePlan.setDay2AmEnm(AllocationStatus.SELECTED);
		weeklyResourcePlan.setDay2PmEnm(AllocationStatus.SELECTED);

		weeklyResourcePlan.setDay3AmEnm(AllocationStatus.SELECTED);
		weeklyResourcePlan.setDay3PmEnm(AllocationStatus.SELECTED);
	
		
		weeklyResourcePlan.setDay5AmEnm(AllocationStatus.SELECTED);
		weeklyResourcePlan.setDay5PmEnm(AllocationStatus.SELECTED);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeKey(1);
		Set<PlatformDTO> platformDtoSet = new HashSet<PlatformDTO>();
		PlatformDTO platformDTO = new PlatformDTO();
		platformDTO.setPlatformKey(1);
		employeeDTO.setPlatFormDtos(platformDtoSet);
		weeklyResourcePlan.setDeveloper(employeeDTO);
		weeklyResourcePlan.setPlatform(platformDTO);
		
		weeklyResourcePlanList.add(weeklyResourcePlan);
		// Adding the 2nd weeklyplan
		
		WeeklyResourcePlan weeklyPlan1 = new WeeklyResourcePlan();
		
		
		weeklyPlan1.setDay2AmEnm(AllocationStatus.SELECTED);
		weeklyPlan1.setDay2PmEnm(AllocationStatus.SELECTED);

		weeklyPlan1.setDay3AmEnm(AllocationStatus.SELECTED);
		weeklyPlan1.setDay3PmEnm(AllocationStatus.SELECTED);
	
		
		weeklyPlan1.setDay5AmEnm(AllocationStatus.SELECTED);
		weeklyPlan1.setDay5PmEnm(AllocationStatus.SELECTED);
		
		EmployeeDTO employeeDto1 = new EmployeeDTO();
		employeeDto1.setEmployeeKey(2);
		Set<PlatformDTO> platformDtoSet1 = new HashSet<PlatformDTO>();
		PlatformDTO platformDTO1 = new PlatformDTO();
		platformDTO1.setPlatformKey(1);
		employeeDto1.setPlatFormDtos(platformDtoSet1);
		weeklyPlan1.setDeveloper(employeeDto1);
		weeklyPlan1.setPlatform(platformDTO1);
		weeklyResourcePlanList.add(weeklyPlan1);
		
		
		projectAllocationDTO.setWeeklyResourcePlanList(weeklyResourcePlanList);
	
		
	}
	

	
	@Test
	public void test1SubmitManpowerRequest(){
		
		requestManpowerService.submitManpowerRequest(projectAllocationDTO);
		
		
		/*
		ProjectDTO projDto = projectService.getProjectDetails
				(projectAllocationDTO.getProjectId());
		Assert.notNull(projDto);
		*/
	}
	
	
	@Test
	public void test2RequestManpower(){
		
		ProjectAllocationDTO projectAllDto =requestManpowerService.
				requestManpower(projectDTO,startOfWeek);
		System.out.println("Project Allocation DTO Printing "+projectAllDto);
		Assert.notNull(projectAllDto);
		
	
	}
	
	@Test
	public void test3TestDate(){
		
		Date startDate = new Date();
		System.out.println("Date is "+startDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strStartDate = simpleDateFormat.format(startDate);
		System.out.println("Date is "+strStartDate);
		try{
			Date newDate = simpleDateFormat.parse(strStartDate);
			System.out.println("New date is "+newDate);
		}catch(Exception exp){
			
		}
		
	
		
	}

}
