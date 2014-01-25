/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.milestone;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
/**
 * ProjectMilestone
 * 
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "project_milestone")  
public class ProjectMilestone implements java.io.Serializable{
	
	@Id
	@GeneratedValue(generator = "ProjectMilestoneGenerator")     
	@GenericGenerator(name = "ProjectMilestoneGenerator", strategy = "increment") 
	@Column(name = "milestone_key")
	private Integer milestoneKey;
	
	@ManyToOne
	@JoinColumn(name = "project_key")
	private Project project;
	
	@Column(name = "milestone_date")
	private Date milestoneDate;
	
	@Column(name = "milestone_desc") 
	private String milestoneDesc;
	
	@Column(name = "create_by_id")
	private String createdById;
	
	@Column(name = "create_tstamp")
	private Date createTstamp;
	
	@Column(name = "last_upd_by_id")
	private String lastUpdById;
	
	@Column(name = "last_upd_tstamp")
	private Date lastUpdTstamp;

	public ProjectMilestone() {

	}

	public ProjectMilestone(ProjectMilestoneDTO projectMilestoneDTO) {
		
		this.setMilestoneKey(projectMilestoneDTO.getMilestoneKey());
		//this.setProject(new Project(projectMilestoneDTO.getProject()));
		this.setMilestoneDate(projectMilestoneDTO.getMilestoneDate());
		this.setMilestoneDesc(projectMilestoneDTO.getMilestoneDesc());
		this.setCreatedById(projectMilestoneDTO.getCreatedById());
		this.setCreateTstamp(projectMilestoneDTO.getCreateTstamp());
		this.setLastUpdById(projectMilestoneDTO.getLastUpdById());
		this.setLastUpdTstamp(projectMilestoneDTO.getLastUpdTstamp());
	}

	public Integer getMilestoneKey() {
		return milestoneKey;
	}

	public void setMilestoneKey(Integer milestoneKey) {
		this.milestoneKey = milestoneKey;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getMilestoneDate() {
		return milestoneDate;
	}

	public void setMilestoneDate(Date milestoneDate) {
		this.milestoneDate = milestoneDate;
	}

	public String getMilestoneDesc() {
		return milestoneDesc;
	}

	public void setMilestoneDesc(String milestoneDesc) {
		this.milestoneDesc = milestoneDesc;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public Date getCreateTstamp() {
		return createTstamp;
	}

	public void setCreateTstamp(Date createTstamp) {
		this.createTstamp = createTstamp;
	}

	public String getLastUpdById() {
		return lastUpdById;
	}

	public void setLastUpdById(String lastUpdById) {
		this.lastUpdById = lastUpdById;
	}

	public Date getLastUpdTstamp() {
		return lastUpdTstamp;
	}

	public void setLastUpdTstamp(Date lastUpdTstamp) {
		this.lastUpdTstamp = lastUpdTstamp;
	}

	public ProjectMilestoneDTO createProjectMilestoneDTO() {
		ProjectMilestoneDTO projectMilestoneDTO = new ProjectMilestoneDTO();
		
		projectMilestoneDTO.setMilestoneKey(this.getMilestoneKey());
		ProjectDTO newProjectDTO = new ProjectDTO();
		newProjectDTO.setId(this.getProject().getId());
		projectMilestoneDTO.setProject(newProjectDTO);
		
		projectMilestoneDTO.setMilestoneDate(this.getMilestoneDate());
		projectMilestoneDTO.setMilestoneDesc(this.getMilestoneDesc());
		projectMilestoneDTO.setCreatedById(this.getCreatedById());
		projectMilestoneDTO.setCreateTstamp(this.getCreateTstamp());
		projectMilestoneDTO.setLastUpdById(this.getLastUpdById());
		projectMilestoneDTO.setLastUpdTstamp(this.getLastUpdTstamp());
		return projectMilestoneDTO;
	}

	@Override
	public String toString() {
		return "ProjectMilestone [milestoneKey=" + milestoneKey + ", project="
				+ project.getName() + ", milestoneDate=" + milestoneDate
				+ ", milestoneDesc=" + milestoneDesc + ", createdById="
				+ createdById + ", createTstamp=" + createTstamp
				+ ", lastUpdById=" + lastUpdById + ", lastUpdTstamp="
				+ lastUpdTstamp + "]";
	}
}
