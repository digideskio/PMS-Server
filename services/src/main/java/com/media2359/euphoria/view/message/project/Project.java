package com.media2359.euphoria.view.message.project;

import java.io.Serializable;

public class Project implements Serializable {
	private String id;
	private String name;
	private String description;
	private String projectManager;
	private Integer manDaysLeft;
	private Integer milestoneCount;
	private Integer completedMilestoneCount;

	public Project() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
}
