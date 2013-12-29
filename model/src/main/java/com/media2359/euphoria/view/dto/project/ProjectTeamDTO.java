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
import java.math.BigDecimal;
import java.util.Set;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;

public class ProjectTeamDTO implements Serializable {
	private Integer projectTeamKey;
	private String projectTeamName;
	private Project project;
	
	Set<Employee> projectManagers;
	Set<Employee> teamMembers;

	public ProjectTeamDTO() {

	}

	public Integer getProjectTeamKey() {
		return projectTeamKey;
	}

	public void setProjectTeamKey(Integer projectTeamKey) {
		this.projectTeamKey = projectTeamKey;
	}

	public String getProjectTeamName() {
		return projectTeamName;
	}

	public void setProjectTeamName(String projectTeamName) {
		this.projectTeamName = projectTeamName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<Employee> getProjectManagers() {
		return projectManagers;
	}

	public void setProjectManagers(Set<Employee> projectManagers) {
		this.projectManagers = projectManagers;
	}

	public Set<Employee> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<Employee> teamMembers) {
		this.teamMembers = teamMembers;
	}

	
	
}
