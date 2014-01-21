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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.project.ProjectDAO;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO projectDao;
	private final Logger log = Logger.getLogger(ProjectServiceImpl.class);
	
	/**
	 * 
	 */
	public ProjectListResponse getAllProjects(ProjectListRequest request) {
		log.info("Received request :"+request);
		List<Project> projects = projectDao.getAllProjects();
		
		ProjectListResponse response = new ProjectListResponse();
		Random random = new Random();									//Temporary, change later-Praveen
		if(projects != null) {
			log.info("Received number of projects:"+projects.size());
			List<ProjectDTO> respProjects
				= new ArrayList<ProjectDTO> ();
			for(Project project:projects) {
				ProjectDTO respProject = project.createProjectDTO();
				respProjects.add(respProject);
				
			}
			response.setProjects(respProjects);
		}
		return response;
	}

	@Override
	public ProjectDTO getProjectDetails(Integer projectId) {
		return projectDao.getProject(projectId).createProjectDTO();
	}

	


	@Override
	public Integer getMaxKey() {
		return projectDao.getMaxKey();
	}

	@Override
	public String addProject(ProjectDTO projectDto) {
		try{
			
			Project project = new Project(projectDto);
			projectDao.addProject(project);
		}catch(Exception exp){
			exp.printStackTrace();
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public String modifyProject(ProjectDTO projectDto) {
		try{
			
			projectDao.updateProject(new Project(projectDto));
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";

	}

	@Override
	public String deleteProject(ProjectDTO projectDto) {
		try{
			projectDao.deleteProject(projectDto.getId());
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public Integer calculateProjectCost(ProjectDTO project) {
		// TODO Auto-generated method stub
		return null;
	}
}
