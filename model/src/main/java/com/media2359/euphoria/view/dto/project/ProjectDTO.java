/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.project;

import java.io.Serializable;

public class ProjectDTO implements Serializable {
	private Integer id;
	private String name;
	private String description;
	private String projectManager;
	private Integer manDaysLeft;
	private Integer milestoneCount;
	private Integer completedMilestoneCount;

	public ProjectDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	/*
	 * Prepares the Project froom the projectDTO
	 */
	
//	public Project prepareProject(){
//		Project project = new Project();
//		project.setId(id);
//		project.setManDaysLeft(manDaysLeft);
//		project.setMilestoneCount(completedMilestoneCount);
//		project.setName(name);
//		project.setProjectManager(projectManager);
//		project.setDescription(description);
//		project.setCompletedMilestoneCount(completedMilestoneCount);
//		return project;
//	}
	
}
