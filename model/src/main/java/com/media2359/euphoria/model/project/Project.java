/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.project;

import java.util.Set;

import com.media2359.euphoria.model.manpower.WeeklyManpowerAllocation;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.view.dto.project.ProjectDTO;

public class Project {
	private String id;
	private String name;
	private String description;
	private String projectManager;
	private Integer manDaysLeft;
	private Integer milestoneCount;
	private Integer completedMilestoneCount;
	private ProjectPlan projectPlan;
	private Set<WeeklyManpowerRequest> weeklyManpowerRequests;
	private Set<WeeklyManpowerAllocation> weeklyManpowerAllocations;
	private Set<ProjectTask> projectTasks;
	private ProjectTeam projectTeam;
	private Set<PlatformProjection> platformProjections;
	private Set<ProjectDocument> projectDocuments;

	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Project(ProjectDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.projectManager = dto.getProjectManager();
		this.manDaysLeft=dto.getManDaysLeft();
		this.milestoneCount=dto.getMilestoneCount();
		this.completedMilestoneCount=dto.getMilestoneCount();
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	
	public Integer getManDaysLeft() {
		return manDaysLeft;
	}

	public void setManDaysLeft(Integer manDaysLeft) {
		this.manDaysLeft = manDaysLeft;
	}
	
	public Integer getMilestoneCount() {
		return milestoneCount;
	}

	public void setMilestoneCount(Integer milestoneCount) {
		this.milestoneCount = milestoneCount;
	}
	
	public Integer getCompletedMilestoneCount() {
		return completedMilestoneCount;
	}

	public void setCompletedMilestoneCount(Integer completedMilestoneCount) {
		this.completedMilestoneCount = completedMilestoneCount;
	}
	
	
	public ProjectDTO createProjectDTO() {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(getId());
		projectDTO.setName(getName());
		projectDTO.setDescription(getDescription());
		projectDTO.setProjectManager(getProjectManager());
		projectDTO.setManDaysLeft(getManDaysLeft());
		projectDTO.setMilestoneCount(getMilestoneCount());
		projectDTO.setCompletedMilestoneCount(getCompletedMilestoneCount());
		return projectDTO;
	}
}
