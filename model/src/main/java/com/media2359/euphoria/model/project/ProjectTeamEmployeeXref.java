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
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.WhereJoinTable;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;

/**
 * ProjectTeam
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.1 2013
 **/

@Entity 
@Table(name = "project_team_employee_xref")
@AssociationOverrides({@AssociationOverride(name = "pk.projectTeam", joinColumns = @JoinColumn(name = "project_team_key")),
					   @AssociationOverride(name = "pk.employee", joinColumns = @JoinColumn(name = "employee_key"))})
public class ProjectTeamEmployeeXref implements java.io.Serializable {
	
	@EmbeddedId
	private ProjectTeamEmployeeXrefId pk = new ProjectTeamEmployeeXrefId();
	
	@Column(name = "project_mgr_flg")
	private String projectMgrFlg;
	
	public ProjectTeamEmployeeXref() {
		// TODO Auto-generated constructor stub
	}

	
	
	public ProjectTeamEmployeeXrefId getPk() {
		return pk;
	}

	public void setPk(ProjectTeamEmployeeXrefId pk) {
		this.pk = pk;
	}

	public String getProjectMgrFlg() {
		return projectMgrFlg;
	}

	public void setProjectMgrFlg(String projectMgrFlg) {
		this.projectMgrFlg = projectMgrFlg;
	}
	
	@Transient
	public ProjectTeam getProjectTeam(){
		return getPk().getProjectTeam();
	}
	
	public void setProjectTeam(ProjectTeam projectTeam) {
		getPk().setProjectTeam(projectTeam);
	}

	@Transient
	public Employee getEmployee(){
		return getPk().getEmployee();
	}
	
	public void setEmployee(Employee employee) {
		getPk().setEmployee(employee);
	}


	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
 
		ProjectTeamEmployeeXref that = (ProjectTeamEmployeeXref) o;
 
		if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;
 
		return true;
	}
 
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	
}
