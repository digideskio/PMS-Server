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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.WhereJoinTable;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamEmployeeXrefDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamEmployeeXrefIdDTO;

/**
 * ProjectTeam
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.1 2013
 **/
@Embeddable
public class ProjectTeamEmployeeXrefId implements java.io.Serializable {
	
	@ManyToOne
	private ProjectTeam projectTeam;
	
	@ManyToOne
	private Employee employee;

	public ProjectTeamEmployeeXrefId() {
		// TODO Auto-generated constructor stub
	}
	
	public ProjectTeamEmployeeXrefId(ProjectTeamEmployeeXrefIdDTO projectTeamEmployeeXrefIdDto) {
		this.setEmployee(new Employee(projectTeamEmployeeXrefIdDto.getEmployeeDto()));
		//this.setProjectTeam(new ProjectTeam(projectTeamEmployeeXrefIdDto.getProjectTeamDto()));
	}

	public ProjectTeam getProjectTeam() {
		return projectTeam;
	}

	public void setProjectTeam(ProjectTeam projectTeam) {
		this.projectTeam = projectTeam;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public ProjectTeamEmployeeXrefIdDTO prepareProjectTeamEmployeeXrefIdDTO(){
		ProjectTeamEmployeeXrefIdDTO projectTeamEmployeeXrefIdDto = new ProjectTeamEmployeeXrefIdDTO();
		projectTeamEmployeeXrefIdDto.setEmployeeDto(this.getEmployee().createEmployeeDTO());
		projectTeamEmployeeXrefIdDto.setProjectTeamDto(this.getProjectTeam().prepareProjectTeamDTO());

		return projectTeamEmployeeXrefIdDto;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        ProjectTeamEmployeeXrefId that = (ProjectTeamEmployeeXrefId) o;
 
        if (projectTeam != null ? !projectTeam.equals(that.projectTeam) : that.projectTeam != null) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
 
        return true;
    }
 
    public int hashCode() {
        int result;
        result = (projectTeam != null ? projectTeam.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }

	

}
