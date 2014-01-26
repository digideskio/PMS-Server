/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.manpower;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.manpower.ManpowerRequestDTO;
import com.media2359.euphoria.view.dto.manpower.PlatformRequestDTO;



//import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.WhereJoinTable;

/**
 * WeeklyManpowerRequest
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "weekly_manpower_request")  
public class WeeklyManpowerRequest {
	@Id
	@GeneratedValue(generator = "WklyMpowerRqstGenerator")     
	@GenericGenerator(name = "WklyMpowerRqstGenerator", strategy = "increment") 
	@Column(name = "wkly_mpower_rqst_key")
	Integer weeklyManpowerRequestKey;
	
	@OneToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="project_key", updatable=false)
	Project project;
	
	@Column(name = "start_date")
	Date startDate;
	@Column(name = "end_date")
	Date endDate;
	@Column(name = "approval_status")
	String approvalStatus;
	@Column(name="approved_by_id")
	String approvedId;
	@Column(name = "comments")
	String comments;
	@Column(name = "create_by_id")
	String createdBy;
	@Column(name = "create_tstamp")
	Date createdTstmp;	
	
	@OneToMany (mappedBy = "weeklyManpowerRequest")
	@Cascade (value = {CascadeType.SAVE_UPDATE, CascadeType.DELETE_ORPHAN, CascadeType.ALL})  
	Set<PlatformRequest> platformRequests = new HashSet<PlatformRequest>(0);
	
	public WeeklyManpowerRequest() {
		// TODO Auto-generated constructor stub
	}


	public Integer getWeeklyManpowerRequestKey() {
		return weeklyManpowerRequestKey;
	}



	public void setWeeklyManpowerRequestKey(Integer weeklyManpowerRequestKey) {
		this.weeklyManpowerRequestKey = weeklyManpowerRequestKey;
	}



	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	
	public Set<PlatformRequest> getPlatformRequests() {
		return platformRequests;
	}


	public void setPlatformRequests(Set<PlatformRequest> platformRequests) {
		this.platformRequests = platformRequests;
	}


	public ManpowerRequestDTO createManpowerRequestDTO() {
		ManpowerRequestDTO manpowerRequestDTO = new ManpowerRequestDTO();
		manpowerRequestDTO.setWeeklyManpowerRequestKey(weeklyManpowerRequestKey);
		manpowerRequestDTO.setProjectKey(project.getId());
		manpowerRequestDTO.setProject(project);
		manpowerRequestDTO.setStartDate(startDate);
		manpowerRequestDTO.setEndDate(endDate);
		manpowerRequestDTO.setApprovalStatus(approvalStatus);
		manpowerRequestDTO.setApprovedId(approvedId);
		manpowerRequestDTO.setComments(comments);
		manpowerRequestDTO.setCreatedBy(createdBy);
		manpowerRequestDTO.setCreatedTstmp(createdTstmp);	
		
		manpowerRequestDTO.setPlatformRequestDtos(new HashSet<PlatformRequestDTO>(0));
		for (PlatformRequest platformRequest: this.getPlatformRequests()){
			manpowerRequestDTO.getPlatformRequestDtos().add(platformRequest.createPlatformRequestDTO());
		}
		
		return manpowerRequestDTO;
	}


	@Override
	public String toString() {
		return "WeeklyManpowerRequest [weeklyManpowerRequestKey="
				+ weeklyManpowerRequestKey + ", project=" + project
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", approvalStatus=" + approvalStatus + ", approvedId="
				+ approvedId + ", comments=" + comments + ", createdBy="
				+ createdBy + ", createdTstmp=" + createdTstmp + "]";
	}
	

	
	

}
