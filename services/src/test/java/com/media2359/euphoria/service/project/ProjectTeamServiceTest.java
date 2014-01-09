package com.media2359.euphoria.service.project;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectTeamService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectTeamServiceTest {
	@Autowired
	ProjectTeamService projectTeamService;
	
	@Autowired 
	ProjectService projectService;
	

	
	private ProjectTeamDTO projectTeamDto;
	Integer projectKey;
	
	@Before
	public void setUp(){
		projectTeamDto = new ProjectTeamDTO();
		Set<Employee> projectManagers = new HashSet<Employee>();
		Employee emp1 = new Employee();
		emp1.setEmployeeKey(1);
		emp1.setName("May The");
		projectManagers.add(emp1);
		
		Set<Employee> teamMembers = new HashSet<Employee>();
		Employee emp2 = new Employee();
		emp2.setEmployeeKey(2);
		emp2.setName("Praveen Jose");
		teamMembers.add(emp2);
		
		Employee emp3 = new Employee();
		emp3.setEmployeeKey(3);
		emp3.setName("Tianyang Hu");
		teamMembers.add(emp3);
		
		projectTeamDto.setProjectTeamName("Team Experts");
		projectTeamDto.setCreatedBy("shiv.kole@gmail.com");
	    
		Project project = new Project();
		projectKey = projectService.getMaxKey();
		project.setId(projectKey);
		
		projectTeamDto.setProjectDto(project.createProjectDTO());
		
		
	}
	
	
	@Test
	public void test1SubmitProjectTeam(){
		
		String result = projectTeamService.submitProjectTeam(projectTeamDto);
		Assert.assertEquals("SUCCESS", result);
	}
	

	
	@Test
	public void test2GetAllTeamMembers(){
		System.out.println("++++++MAX PROJECT KEY IS ++++"+projectKey);
		ProjectDTO projectDto = new ProjectDTO();
		projectDto.setId(projectKey);
		ProjectTeamDTO getProjectTeamDTO = projectTeamService.getProjectTeam(projectDto);
		Assert.assertNotNull(getProjectTeamDTO);
		Assert.assertEquals(projectTeamDto.getProjectTeamName(),
				getProjectTeamDTO.getProjectTeamName());
		Assert.assertEquals(projectTeamDto.getTeamMembers().size(), 
				getProjectTeamDTO.getTeamMembers().size());
	}
	
	
}
