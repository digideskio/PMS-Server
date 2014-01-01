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

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.project.ProjectDAO;
import com.media2359.euphoria.model.employee.Employee;
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
		log.info("####Number of Project Teams returned:"+projectTeams.size());
		
		ListIterator iterator = projectTeams.listIterator();
		
		ProjectTeam projectTeam = iterator.hasNext()?(ProjectTeam) iterator.next():null;
		
		
		log.info("####Project returned in Project Team:"+ projectTeam.getProject().toString());
		
	}
	
	@Test
	public void testGetAllProjectTeamMembers() {
		
		
		Integer maxKey = projectTeamDao.getMaxKey();
		log.info("####testGetAllProjectTeamMembers->MaxKey(ProjectTeam)::" + maxKey.toString());
		
		ProjectTeam projectTeam1 = projectTeamDao.getProjectTeam(maxKey);
		
		Set<Employee> employees = projectTeam1.getTeamMembers();
		Assert.assertNotNull(employees);
		
		log.info("####Number of Team Members:"+employees.size());
		
		Employee employee;
		
		for (Iterator<Employee> it = employees.iterator(); it.hasNext(); )
		{
			employee = it.next();

			log.info("####Team Member Details:"+ employee.toString());
		}
		
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
	public void testUpdateProjectTeam() {
		ProjectTeam projectTeam1;
		ProjectTeam projectTeam2;
		log.info("####TestUpdateProjectTeam Starts...");
		Integer maxKey = projectTeamDao.getMaxKey();
		log.info("####TestUpdateProjectTeam->MaxKey::" + maxKey.toString());
		
		projectTeam1 = projectTeamDao.getProjectTeam(maxKey);
		
		Assert.assertNotNull(projectTeam1);
		
		log.info("####ProjectTeam->toString()::" + projectTeam1.toString());
		
		projectTeam1.setProjectTeamName("TEST_UPD"+ maxKey.toString());
		
		projectTeamDao.updateProjectTeam(projectTeam1);
		
		projectTeam2 = projectTeamDao.getProjectTeam(maxKey);
		
		String s1 = "TEST_UPD" + maxKey.toString();
		
		
		Assert.assertTrue(s1.equalsIgnoreCase(projectTeam2.getProjectTeamName()));
		
	}*/
		
}

