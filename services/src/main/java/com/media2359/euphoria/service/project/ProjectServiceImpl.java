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
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.project.ProjectDAO;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;
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
				if(respProject != null){
					// Calculate the number of mandays left for selection
					Double totalApprovedMandays = projectDao.getTotalApprovedMandays(project);
					if(totalApprovedMandays!=null && respProject.getManDaysLeft()!=null){
						System.out.println("Projected Mandays "+respProject.getManDaysLeft()+""
								+ " : Total Approved Mandays "+totalApprovedMandays);
						respProject.setNoOfMandaysLeftForSelection(totalApprovedMandays-
								respProject.getManDaysLeft());
					}
					
					// Calculate the number of completed milestones for the project
					// Calculation is based on the date completed for the milestones 
					
					Integer noOfCompletedMilestones = 0;
					if(respProject.getProjectMilestone() !=null){
						Date todayDate = new Date();
						for(ProjectMilestoneDTO projectMilestoneDto: respProject.getProjectMilestone()){
							if(projectMilestoneDto.getMilestoneDate().compareTo(todayDate)<=0)
								noOfCompletedMilestones++;
						}
						
					}
					
					respProject.setCompletedMilestoneCount(noOfCompletedMilestones);
				}
				respProjects.add(respProject);
				
			}
			response.setProjects(respProjects);
		}
		return response;
	}

	@Override
	public ProjectDTO getProjectDetails(Integer projectId) {
		ProjectDTO projectDTO= projectDao.getProject(projectId).createProjectDTO();
		if(projectDTO!=null){
			
			// Calculate the number of mandays left for selection
			Project project = new Project(projectDTO);
			Double totalApprovedMandays = projectDao.getTotalApprovedMandays(project);
			if(totalApprovedMandays!=null && projectDTO.getManDaysLeft()!=null){
				System.out.println("Projected Mandays "+projectDTO.getManDaysLeft()+""
						+ " : Total Approved Mandays "+totalApprovedMandays);
				projectDTO.setNoOfMandaysLeftForSelection(totalApprovedMandays-
						projectDTO.getManDaysLeft());
			}
			
			// Calculate the number of completed milestones for the project
			// Calculation is based on the date completed for the milestones 
			
			Integer noOfCompletedMilestones = 0;
			if(projectDTO.getProjectMilestone() !=null){
				Date todayDate = new Date();
				for(ProjectMilestoneDTO projectMilestoneDto: projectDTO.getProjectMilestone()){
					if(projectMilestoneDto.getMilestoneDate().compareTo(todayDate)<=0)
						noOfCompletedMilestones++;
				}
				
			}
			
			projectDTO.setCompletedMilestoneCount(noOfCompletedMilestones);
			
			
		
		}
		return projectDTO;
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
