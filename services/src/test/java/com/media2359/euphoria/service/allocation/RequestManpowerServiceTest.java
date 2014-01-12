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
		Integer projectId = projectService.getMaxKey();
		projectDTO = projectService.getProjectDetails(projectId);
		
		projectAllocationDTO.setProjectId(projectId);
		
		
		
		try{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
			startOfWeek = simpleDateFormat.parse("12-01-2014");
			
			System.out.println("+++START DATE++++ "+startOfWeek);
			projectAllocationDTO.setStartOfWeek(startOfWeek);
			
		}catch(Exception exp){
			
		}
		
		List<WeeklyResourcePlan> weeklyResourcePlanList = new ArrayList<WeeklyResourcePlan>();
		
		WeeklyResourcePlan weeklyResourcePlan = new WeeklyResourcePlan();
		weeklyResourcePlan.setDay1Am(true);
		weeklyResourcePlan.setDay1Pm(true);
		
		weeklyResourcePlan.setDay2Am(true);
		weeklyResourcePlan.setDay2Pm(true);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Set<PlatformDTO> platformDtoSet = new HashSet<PlatformDTO>();
		employeeDTO.setPlatFormDtos(platformDtoSet);
		weeklyResourcePlan.setDeveloper(employeeDTO);
		
		weeklyResourcePlanList.add(weeklyResourcePlan);
		
		projectAllocationDTO.setWeeklyResourcePlan(weeklyResourcePlanList);
	
		
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
	
	/*
	@Test
	public void test2RequestManpower(){
		ProjectAllocationDTO projectAllDto =requestManpowerService.
				requestManpower(projectDTO,startOfWeek);
		Assert.notNull(projectAllDto);
		
	}
	
	*/
	

}
