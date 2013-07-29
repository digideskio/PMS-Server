package com.media2359.euphoria.service.project;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
public class ProjectServiceTest {
	@Autowired
	private ProjectService projectService;
	
	@Test
	public void testGetAllProjects() {
		ProjectListResponse response = projectService.getAllProjects(new ProjectListRequest());
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getProjects());
	}
}
