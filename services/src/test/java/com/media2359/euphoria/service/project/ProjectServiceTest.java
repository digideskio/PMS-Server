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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
public class ProjectServiceTest {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private Project project;
	
	@Before
	public void setUp(){
		project.setName("SGMalls");
		project.setDescription("PM System for SG Malls");
		project.setProjectManager("May Thei");
		project.setManDaysLeft(20);
		
	}
	
	@Test
	public void testGetAllProjects() {
		ProjectListResponse response = projectService.getAllProjects(new ProjectListRequest());
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getProjects());
	}
	
	@Test
	public void testAddProject(){
		String result = projectService.addProject(project);
		Assert.assertEquals("SUCCESS", result);
	}
	
	@Test
	public void testProjectDetails(){
		Project proj = projectService.getProjectDetails(projectService.getMaxKey());
		Assert.assertNotNull(proj);
		
	}
	
	@Test
	public void testModifyProject(){
		String result = projectService.modifyProject(project);
		Assert.assertEquals("SUCCESS", result);
	}
	
	@Test
	public void testDeleteProject(){
		Project proj = new Project();
		proj.setId(projectService.getMaxKey());
		String result = projectService.deleteProject(proj);
		Assert.assertEquals("SUCCESS", result);
	}
}
