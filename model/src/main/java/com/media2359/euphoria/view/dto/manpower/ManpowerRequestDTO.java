/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.manpower;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.manpower.PlatformRequest;
import com.media2359.euphoria.model.project.Project;

import java.io.Serializable;

/**
 * ManpowerRequestDTO
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/

public class ManpowerRequestDTO {
	
	/**
	 * 
	 */
	public ManpowerRequestDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer weeklyManpowerRequestKey;
	private Integer projectKey;
	private Date startDate;
	private Date endDate;
	private String approvalStatus;
	private String approvedId;
	private String comments;
	private Set<PlatformRequestDTO> platformRequestDtos = new HashSet<PlatformRequestDTO>(0);;
	private String createdBy;
	private Date createdTstmp;
	private Project project;
	
	
	public Integer getWeeklyManpowerRequestKey() {
		return weeklyManpowerRequestKey;
	}
	public void setWeeklyManpowerRequestKey(Integer weeklyManpowerRequestKey) {
		this.weeklyManpowerRequestKey = weeklyManpowerRequestKey;
	}
	public Integer getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(Integer projectKey) {
		this.projectKey = projectKey;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getApprovedId() {
		return approvedId;
	}
	public void setApprovedId(String approvedId) {
		this.approvedId = approvedId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set<PlatformRequestDTO> getPlatformRequestDtos() {
		return platformRequestDtos;
	}
	public void setPlatformRequestDtos(Set<PlatformRequestDTO> platformRequestDtos) {
		this.platformRequestDtos = platformRequestDtos;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTstmp() {
		return createdTstmp;
	}
	public void setCreatedTstmp(Date createdTstmp) {
		this.createdTstmp = createdTstmp;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "ManpowerRequestDTO [weeklyManpowerRequestKey="
				+ weeklyManpowerRequestKey + ", projectKey=" + projectKey
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", approvalStatus=" + approvalStatus + ", approvedId="
				+ approvedId + ", comments=" + comments
				+ ", platformRequestDtos=" + platformRequestDtos
				+ ", createdBy=" + createdBy + ", createdTstmp=" + createdTstmp
				+ ", project=" + project + "]";
	}
}
