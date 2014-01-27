package com.media2359.euphoria.view.client.project;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.client.core.ProjectStatus;
import com.media2359.euphoria.view.client.core.ProjectTeamRole;
import com.media2359.euphoria.view.client.core.ProjectTeamRoles;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.event.CellSelectionEvent;

public class ProjectTeamItem {

	private Integer projectTeamKey;
	 
	private PlatformDTO platformDto;
	private EmployeeDTO projectTeamMember;
	private ProjectTeamRole role;
	public void setRole(ProjectTeamRole role) {
		this.role = role;
	}
	private Integer manDayRate;
	private ProjectStatus status;
	
	public Integer getProjectTeamKey() {
		return projectTeamKey;
	}
	public void setProjectTeamKey(Integer projectTeamKey) {
		this.projectTeamKey = projectTeamKey;
	}
	public PlatformDTO getPlatformDto() {
		return platformDto;
	}
	public void setPlatformDto(PlatformDTO platformDto) {
		this.platformDto = platformDto;
	}
	public EmployeeDTO getProjectTeamMember() {
		return projectTeamMember;
	}
	public void setProjectTeamMember(EmployeeDTO projectTeamMember) {
		this.projectTeamMember = projectTeamMember;
	}
	public ProjectTeamRole getRole() {
		return role;
	}
	public void setStringRole(String role) {
		ProjectTeamRole projectRole = new ProjectTeamRole();
		projectRole.setId(1);
		projectRole.setProjectTeamRoles(ProjectTeamRoles.parseString(role));
		this.role = projectRole;
	}
	public Integer getManDayRate() {
		return manDayRate;
	}
	public void setManDayRate(Integer manDayRate) {
		this.manDayRate = manDayRate;
	}
	public ProjectStatus getStatus() {
		return status;
	}
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	

	
}
