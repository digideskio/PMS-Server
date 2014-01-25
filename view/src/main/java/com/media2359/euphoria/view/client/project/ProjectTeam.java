package com.media2359.euphoria.view.client.project;

import com.media2359.euphoria.view.client.core.ProjectTeamRoles;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;

public class ProjectTeam {

	private Integer projectTeamKey;
	private ProjectTeamRoles role; 
	private EmployeeDTO projectTeamMemeber;
	
	public Integer getProjectTeamKey() {
		return projectTeamKey;
	}
	public void setProjectTeamKey(Integer projectTeamKey) {
		this.projectTeamKey = projectTeamKey;
	}
	public ProjectTeamRoles getRole() {
		return role;
	}
	public void setRole(ProjectTeamRoles role) {
		this.role = role;
	}
	public EmployeeDTO getProjectTeamMemeber() {
		return projectTeamMemeber;
	}
	public void setProjectTeamMemeber(EmployeeDTO projectTeamMemeber) {
		this.projectTeamMemeber = projectTeamMemeber;
	}
}
