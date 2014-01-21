/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.milestone;

import java.io.Serializable;
import java.util.Date;

import com.media2359.euphoria.view.dto.project.ProjectDTO;
/**
 * ProjectMilestoneDTO
 *
 * TODO Write something about this class
 * 
 * @author TY
 * @version 1.0 2013
 **/

public class ProjectMilestoneDTO implements Serializable {
    
	private Integer milestoneKey;
	private ProjectDTO project;
	private Date milestoneDate;
	private String milestoneDesc;
	private String createdById;
	private Date createTstamp;
	private String lastUpdById;
	private Date lastUpdTstamp;
	
	public Integer getMilestoneKey() {
		return milestoneKey;
	}
	public void setMilestoneKey(Integer milestoneKey) {
		this.milestoneKey = milestoneKey;
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
	
	
	
	public ProjectDTO getProject() {
		return project;
	}
	public void setProject(ProjectDTO project) {
		this.project = project;
	}
	
	
	
	@Override
	public String toString() {
		return "ProjectMilestoneDTO [milestoneKey=" + milestoneKey
				+ ", project=" + project + ", milestoneDate=" + milestoneDate
				+ ", milestoneDesc=" + milestoneDesc + ", createdById="
				+ createdById + ", createTstamp=" + createTstamp
				+ ", lastUpdById=" + lastUpdById + ", lastUpdTstamp="
				+ lastUpdTstamp + "]";
	}
}
