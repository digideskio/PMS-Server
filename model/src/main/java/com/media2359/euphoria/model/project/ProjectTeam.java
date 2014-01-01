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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.WhereJoinTable;

import com.media2359.euphoria.model.employee.Employee;

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
	
	Set<Employee> projectManagers;
	Set<Employee> teamMembers;

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

	@Override
	public String toString() {
		return "ProjectTeam [projectTeamKey=" + projectTeamKey
				+ ", projectTeamName=" + projectTeamName + ", project="
				+ project + "]";
	}

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
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
	}
	
	

}
