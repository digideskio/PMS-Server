package com.media2359.euphoria.service.allocation;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ibm.icu.text.SimpleDateFormat;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.server.allocation.ApproveManpowerService;
import com.media2359.euphoria.view.server.project.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApproveManpowerServiceTest {
	
	@Autowired
	ApproveManpowerService approveManpowerService;
	
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
	}
	
	@Test
	public void test2ApproveWeeklyRequest(){
		
		String result = approveManpowerService.approveWeeklyRequest(projectAllocationDTO); 
				
		//Assert.assertEquals("SUCCESS", result);
	}
	
	@Test
	
	public void test1GetWeeklyManpowerRequest(){
		
	}
	

}
