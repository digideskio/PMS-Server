/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.dashboard;

public class ProjectDTO {
	String name;
	Integer manDaysLeft;
	Integer milestoneCount;
	Integer completedMilestoneCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(ProjectDTO b) {
		return ((b != null) && (name.equals(b.getName())));
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
