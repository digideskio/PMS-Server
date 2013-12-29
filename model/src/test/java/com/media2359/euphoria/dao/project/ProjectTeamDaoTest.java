/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.project;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.project.ProjectDAO;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
public class ProjectTeamDaoTest {
	@Autowired
	private ProjectTeamDAO projectTeamDao;
	private Logger log = Logger.getLogger(ProjectTeamDaoTest.class);
	
	@Test
	public void testGetAllProjectTeams() {
		List<ProjectTeam> projectTeams = projectTeamDao.getAllProjectTeams();
		Assert.assertNotNull(projectTeams);
		log.info("Number of Project Teams returned:"+projectTeams.size());
		
	}
	
	/*@Test
	public void testGetProject() {
		Project project = projectDao.getProject(Integer.valueOf(1));
		Assert.assertNotNull(project);
		log.info("Project Name:" + project.getName());
	}
	
	@Test
	public void testAddProject() {
		Project project1 = new Project();
		Project project2;
		project1.setId(Integer.valueOf(0));
		project1.setName("TEST123");
		project1.setDescription("Project Unit Test for save a project");
		project1.setManDaysLeft(100);
		project1.setProjectManager("Mgr123");
		
		projectDao.addProject(project1);
		
		Integer maxKey = projectDao.getMaxKey();
		log.info("MaxKey::" + maxKey.toString());
		project2 = projectDao.getProject(maxKey);
		
		Assert.assertNotNull(project2);
		log.info("Project Name:" + project2.getName());
	}
	
	@Test
	public void testDeleteProject() {
		Project project1;
		Project project2;
		
		Integer maxKey = projectDao.getMaxKey();
		log.info("TestDeleteProject->MaxKey::" + maxKey.toString());
		//project1 = projectDao.getProject(maxKey);
		
		projectDao.deleteProject(maxKey);
		project2 = projectDao.getProject(maxKey);
		Assert.assertNull(project2);
		
	}
	
	@Test
	public void testUpdateProject() {
		Project project1;
		Project project2;
		
		Integer maxKey = projectDao.getMaxKey();
		log.info("TestUpdateProject->MaxKey::" + maxKey.toString());
		
		project1 = projectDao.getProject(maxKey);
		project1.setName("TEST_UPD" + maxKey.toString());
		projectDao.updateProject(project1);
		
		project2 = projectDao.getProject(maxKey);
		
		String s1 = "TEST_UPD" + maxKey.toString();
		
		Assert.assertTrue(s1.equalsIgnoreCase(project2.getName()));
		
	}*/
		
}

