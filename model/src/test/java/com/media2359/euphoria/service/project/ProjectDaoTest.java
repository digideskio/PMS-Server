package com.media2359.euphoria.service.project;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.project.ProjectDao;
import com.media2359.euphoria.model.project.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
public class ProjectDaoTest {
	@Autowired
	private ProjectDao projectDao;
	private Logger log = Logger.getLogger(ProjectDaoTest.class);
	
	@Test
	public void testGetAllProjects() {
		List<Project> projects = projectDao.getAllProjects();
		Assert.assertNotNull(projects);
		log.info("Number of projects returned:"+projects.size());
		
	}
}
