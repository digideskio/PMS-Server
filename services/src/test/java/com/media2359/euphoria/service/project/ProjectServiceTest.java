/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.service.project;

/**
 * ProjectServiceTest
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectServiceTest {
	@Autowired
	private ProjectService projectService;
	
	private Logger log = Logger.getLogger(ProjectServiceTest.class);
	private ProjectDTO project=null;
	
	@Before
	public void setUp(){
		project = new ProjectDTO();
		project.setName("SGMalls");
		project.setDescription("PM System for SG Malls");
		project.setProjectManager("May Thei");
		project.setManDaysLeft(Double.valueOf(20.01));
		
	}
	
	@Test
	public void test1AddProject(){
		String result = projectService.addProject(project);
		Assert.assertEquals("SUCCESS", result);
	}
	
	@Test
	public void test2GetAllProjects() {
		ProjectListResponse response = projectService.getAllProjects(new ProjectListRequest());
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getProjects());
	}
	
	
	
	@Test
	public void test3ProjectDetails(){
		ProjectDTO projDto = projectService.getProjectDetails(projectService.getMaxKey());
		Assert.assertNotNull(projDto);
		Assert.assertEquals(project.getName(), projDto.getName());
		
	}
	
	@Test
	public void test4ModifyProject(){
		
		ProjectDTO projDto = projectService.getProjectDetails(projectService.getMaxKey());
		
		projDto.setProjectManager("SHIV");
		String result = projectService.modifyProject(projDto);
		Assert.assertEquals("SUCCESS", result);
		//ProjectDTO projectDto2 = projectService.getProjectDetails(projectService.getMaxKey());
		//Assert.assertEquals("SHIV",projectDto2.getProjectManager() );
	}
	
	public void test5DeleteProject(){
		ProjectDTO proj = new ProjectDTO();
		log.info("####hty1####");
		proj.setId(projectService.getMaxKey());
		log.info("####hty2####");
		String result = projectService.deleteProject(proj);
		log.info("####HTY3####");
		Assert.assertEquals("SUCCESS", result);
		ProjectDTO projDto = projectService.getProjectDetails(projectService.getMaxKey());
		Assert.assertNull(projDto);
	}
}
