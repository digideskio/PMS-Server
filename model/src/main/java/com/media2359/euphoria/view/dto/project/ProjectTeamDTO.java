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
	
	Set<ProjectTeamEmployeeXrefDTO> projectManagers;
	Set<ProjectTeamEmployeeXrefDTO> teamMembers;
	
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

	

	public Set<ProjectTeamEmployeeXrefDTO> getProjectManagers() {
		return projectManagers;
	}

	public void setProjectManagers(Set<ProjectTeamEmployeeXrefDTO> projectManagers) {
		this.projectManagers = projectManagers;
	}

	public Set<ProjectTeamEmployeeXrefDTO> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<ProjectTeamEmployeeXrefDTO> teamMembers) {
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

	@Override
	public String toString() {
		return "ProjectTeamDTO [projectTeamKey=" + projectTeamKey
				+ ", projectTeamName=" + projectTeamName + ", projectDto="
				+ projectDto + ", projectManagers=" + projectManagers
				+ ", teamMembers=" + teamMembers + ", createdBy=" + createdBy
				+ ", createdTstmp=" + createdTstmp + "]";
	}
}
