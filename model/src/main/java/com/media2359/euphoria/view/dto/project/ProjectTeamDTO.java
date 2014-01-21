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
import java.util.Date;
import java.util.Set;

import com.media2359.euphoria.view.dto.employee.EmployeeDTO;

public class ProjectTeamDTO implements Serializable {
	private Integer projectTeamKey;
	private String projectTeamName;
	private ProjectDTO projectDto;
	
	Set<EmployeeDTO> projectManagers;
	Set<EmployeeDTO> teamMembers;
	
	private String createdBy;
	private Date createdTstmp;

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

	
	
	

	public ProjectDTO getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectDTO projectDto) {
		this.projectDto = projectDto;
	}

	public Set<EmployeeDTO> getProjectManagers() {
		return projectManagers;
	}

	public void setProjectManagers(Set<EmployeeDTO> projectManagers) {
		this.projectManagers = projectManagers;
	}

	public Set<EmployeeDTO> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<EmployeeDTO> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTstmp() {
		return createdTstmp;
	}

	public void setCreatedTstmp(Date createdTstmp) {
		this.createdTstmp = createdTstmp;
	}
/*
	public ProjectTeam prepareProjectTeam(){
		ProjectTeam projectTeam = new ProjectTeam();
		projectTeam.setProject(getProject());
		projectTeam.setProjectManagers(getProjectManagers());
		projectTeam.setProjectTeamKey(getProjectTeamKey());
		projectTeam.setProjectTeamName(getProjectTeamName());
		projectTeam.setTeamMembers(getTeamMembers());
		projectTeam.setCreatedBy(getCreatedBy());
		return projectTeam;
	}
*/
	
	
}
