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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
public class ProjectDaoTest {
	@Autowired
	private ProjectDAO projectDao;
	private Logger log = Logger.getLogger(ProjectDaoTest.class);
	
	@Test
	public void testGetAllProjects() {
		List<Project> projects = projectDao.getAllProjects();
		Assert.assertNotNull(projects);
		log.info("Number of projects returned:"+projects.size());
		
	}
	
	@Test
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
		
}

