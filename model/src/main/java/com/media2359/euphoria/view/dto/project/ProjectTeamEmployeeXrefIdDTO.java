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

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.model.project.ProjectTeamEmployeeXrefId;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;

public class ProjectTeamEmployeeXrefIdDTO implements Serializable {
	private ProjectTeamDTO projectTeamDto;
	private EmployeeDTO employeeDto;
	public ProjectTeamDTO getProjectTeamDto() {
		return projectTeamDto;
	}
	public void setProjectTeamDto(ProjectTeamDTO projectTeamDto) {
		this.projectTeamDto = projectTeamDto;
	}
	public EmployeeDTO getEmployeeDto() {
		return employeeDto;
	}
	public void setEmployeeDto(EmployeeDTO employeeDto) {
		this.employeeDto = employeeDto;
	}
	@Override
	public String toString() {
		return "ProjectTeamEmployeeXrefIdDTO [projectTeamDto=" + projectTeamDto
				+ ", employeeDto=" + employeeDto + "]";
	}
	
	
	
}
