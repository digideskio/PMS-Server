package com.media2359.euphoria.service.project;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.project.ProjectDao;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	private final Logger log = Logger.getLogger(ProjectServiceImpl.class);
	
	public ProjectListResponse getAllProjects(ProjectListRequest request) {
		log.info("Received request :"+request);
		List<Project> projects = projectDao.getAllProjects();
		
		ProjectListResponse response = new ProjectListResponse();
		if(projects != null) {
			log.info("Received number of projects:"+projects.size());
			List<com.media2359.euphoria.view.message.project.Project> respProjects
				= new ArrayList<com.media2359.euphoria.view.message.project.Project> ();
			for(Project project:projects) {
				com.media2359.euphoria.view.message.project.Project respProject =
						new com.media2359.euphoria.view.message.project.Project();
				respProject.setId(project.getId());
				respProject.setName(project.getName());
				respProject.setDescription(project.getDescription());
				respProjects.add(respProject);
			}
			response.setProjects(respProjects);
		}
		return response;
	}
}
