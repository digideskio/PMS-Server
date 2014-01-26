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
import com.media2359.euphoria.model.user.Role;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamEmployeeXrefDTO;

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
	
	@OneToOne
	@JoinColumn (name="platform_key", updatable = false)
	private Platform platform;
	
	@Column(name = "project_role", updatable = false)
	private String projectRole;
	
	@Column(name = "status")
	private String status;
	
	@Column(name= "manday_rate")
	private String mandayRate;
	
	public ProjectTeamEmployeeXref() {
		// TODO Auto-generated constructor stub
	}
	
	public ProjectTeamEmployeeXref(ProjectTeamEmployeeXrefDTO projectTeamEmpXrefDTO){
		this.pk=new ProjectTeamEmployeeXrefId(projectTeamEmpXrefDTO.getPk());
		this.mandayRate=projectTeamEmpXrefDTO.getMandayRate();
		this.projectMgrFlg=projectTeamEmpXrefDTO.getProjectMgrFlg();
		this.projectRole=projectTeamEmpXrefDTO.getProjectRole();
		this.status=projectTeamEmpXrefDTO.getStatus();
		
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
	
	
	
	public Platform getPlatform() {
		return platform;
	}



	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	

	public String getProjectRole() {
		return projectRole;
	}



	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getMandayRate() {
		return mandayRate;
	}



	public void setMandayRate(String mandayRate) {
		this.mandayRate = mandayRate;
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

	
	public ProjectTeamEmployeeXrefDTO prepareProjectTeamEmployeeXrefDTO(){
		ProjectTeamEmployeeXrefDTO projectTeamEmployeeXrefDto = new ProjectTeamEmployeeXrefDTO();
		
		projectTeamEmployeeXrefDto.setPk(this.getPk().prepareProjectTeamEmployeeXrefIdDTO());
		projectTeamEmployeeXrefDto.setMandayRate(this.getMandayRate());
		projectTeamEmployeeXrefDto.setPlatformDto(this.getPlatform().createPlatformDTO());
		projectTeamEmployeeXrefDto.setProjectMgrFlg(this.getProjectMgrFlg());
		projectTeamEmployeeXrefDto.setProjectRole(this.getProjectRole());
		projectTeamEmployeeXrefDto.setStatus(this.getStatus());
		
		return projectTeamEmployeeXrefDto;
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



	@Override
	public String toString() {
		return "ProjectTeamEmployeeXref [pk=" + pk + ", projectMgrFlg="
				+ projectMgrFlg + ", platform=" + platform + ", projectRole="
				+ projectRole + ", status=" + status + ", mandayRate="
				+ mandayRate + "]";
	}


}
