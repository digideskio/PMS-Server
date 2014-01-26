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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import com.media2359.euphoria.model.employee.Employee;
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
@Table(name = "project_team")  
public class ProjectTeam implements java.io.Serializable {
	
	private Integer projectTeamKey;
	private String projectTeamName;
	private Project project;
	
	/*Set<Employee> projectManagers;
	Set<Employee> teamMembers;*/
	
	Set<ProjectTeamEmployeeXref> projectManagers;
	Set<ProjectTeamEmployeeXref> teamMembers;
	
	private String createdBy;
	private Date createdTstmp;

	/**
	 * 
	 */
	public ProjectTeam() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator = "ProjectTeamGenerator")     
	@GenericGenerator(name = "ProjectTeamGenerator", strategy = "increment") 
	@Column(name = "project_team_key")
	public Integer getProjectTeamKey() {
		return projectTeamKey;
	}

	public void setProjectTeamKey(Integer projectTeamKey) {
		this.projectTeamKey = projectTeamKey;
	}
	
	@Column(name = "project_team_name") 
	public String getProjectTeamName() {
		return projectTeamName;
	}

	public void setProjectTeamName(String projectTeamName) {
		this.projectTeamName = projectTeamName;
	}
	
	@OneToOne
	@JoinColumn(name="project_key")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	/*@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="project_team_employee_xref", 
	joinColumns = {@JoinColumn(name="project_team_key", referencedColumnName="project_team_key")},
	inverseJoinColumns = {@JoinColumn(name="employee_key", referencedColumnName="employee_key")})
	@WhereJoinTable (clause="project_mgr_flg = 'Y'")
	public Set<Employee> getProjectManagers() {
		return projectManagers;
	}

	public void setProjectManagers(Set<Employee> projectManagers) {
		this.projectManagers = projectManagers;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="project_team_employee_xref", 
	joinColumns = {@JoinColumn(name="project_team_key", referencedColumnName="project_team_key")},
	inverseJoinColumns = {@JoinColumn(name="employee_key", referencedColumnName="employee_key")})
	@WhereJoinTable (clause="project_mgr_flg = 'N'")
	public Set<Employee> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<Employee> teamMembers) {
		this.teamMembers = teamMembers;
	}*/
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.projectTeam", cascade=CascadeType.ALL)
	@Where (clause="project_mgr_flg = 'Y'")
	public Set<ProjectTeamEmployeeXref> getProjectManagers() {
		return projectManagers;
	}
	
	public void setProjectManagers(Set<ProjectTeamEmployeeXref> projectManagers) {
		this.projectManagers = projectManagers;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.projectTeam", cascade=CascadeType.ALL)
	@Where (clause="project_mgr_flg = 'N'")
	public Set<ProjectTeamEmployeeXref> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<ProjectTeamEmployeeXref> teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Column(name = "create_by_id")
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "create_tstamp")
	public Date getCreatedTstmp() {
		return createdTstmp;
	}

	public void setCreatedTstmp(Date createdTstmp) {
		this.createdTstmp = createdTstmp;
	}

	@Override
	public String toString() {
		return "ProjectTeam [projectTeamKey=" + projectTeamKey
				+ ", projectTeamName=" + projectTeamName + ", project="
				+ project + ", projectManagers=" + projectManagers
				+ ", teamMembers=" + teamMembers + ", createdBy=" + createdBy
				+ ", createdTstmp=" + createdTstmp + "]";
	}

	public ProjectTeamDTO prepareProjectTeamDTO(){
		ProjectTeamDTO projectTeamDto = new ProjectTeamDTO();
		projectTeamDto.setProjectDto(getProject().createProjectDTO());
		projectTeamDto.setProjectTeamName(getProjectTeamName());
		projectTeamDto.setProjectTeamKey(getProjectTeamKey());
		
		
		Set<ProjectTeamEmployeeXrefDTO> teamMemberSet = new HashSet<ProjectTeamEmployeeXrefDTO>();
		if(getTeamMembers()!=null){
			for(ProjectTeamEmployeeXref projectTeamEmployeeXref: getTeamMembers()){
				teamMemberSet.add(projectTeamEmployeeXref.prepareProjectTeamEmployeeXrefDTO());
			}
		}
		
		projectTeamDto.setTeamMembers(teamMemberSet);
		
		Set<ProjectTeamEmployeeXrefDTO> projectManagerSet = new HashSet<ProjectTeamEmployeeXrefDTO>();
		
		if(getProjectManagers()!=null){
			for(ProjectTeamEmployeeXref projectTeamEmployeeXref: getProjectManagers()){
				projectManagerSet.add(projectTeamEmployeeXref.prepareProjectTeamEmployeeXrefDTO());
			}
		}
		
		projectTeamDto.setProjectManagers(projectManagerSet);
		
		
		projectTeamDto.setCreatedBy(getCreatedBy());
		projectTeamDto.setCreatedTstmp(getCreatedTstmp());
		return projectTeamDto;
	}
}
