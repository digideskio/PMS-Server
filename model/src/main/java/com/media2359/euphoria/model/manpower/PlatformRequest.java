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

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.dto.manpower.*;

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
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.WhereJoinTable;
/**
 * PlatformRequest
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "platform_request")  
public class PlatformRequest {
	
	@Id
	@GeneratedValue(generator = "PlatformRqstGenerator")     
	@GenericGenerator(name = "PlatformRqstGenerator", strategy = "increment") 
	@Column(name = "platform_request_key")
	private Integer platformRequestKey;
	
	@ManyToOne
	@JoinColumn(name = "weekly_manpower_request_key")
	private WeeklyManpowerRequest weeklyManpowerRequest;
	
	@OneToOne
	@JoinColumn(name="platform_key", updatable=false)
	private Platform platform;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "duration")
	private Float duration;
	
	@OneToOne
	@JoinColumn(name="employee_key", updatable=false)
	private Employee employee;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "create_by_id")
	private String createById;
	
	@Column(name = "create_tstamp")
	private Date createTstamp;
	
	
	
	public Integer getPlatformRequestKey() {
		return platformRequestKey;
	}



	public void setPlatformRequestKey(Integer platformRequestKey) {
		this.platformRequestKey = platformRequestKey;
	}



	public WeeklyManpowerRequest getWeeklyManpowerRequest() {
		return weeklyManpowerRequest;
	}



	public void setWeeklyManpowerRequest(WeeklyManpowerRequest weeklyManpowerRequest) {
		this.weeklyManpowerRequest = weeklyManpowerRequest;
	}



	public Platform getPlatform() {
		return platform;
	}



	public void setPlatform(Platform platform) {
		this.platform = platform;
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



	public Float getDuration() {
		return duration;
	}



	public void setDuration(Float duration) {
		this.duration = duration;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public String getCreateById() {
		return createById;
	}



	public void setCreateById(String createById) {
		this.createById = createById;
	}



	public Date getCreateTstamp() {
		return createTstamp;
	}



	public void setCreateTstamp(Date createTstamp) {
		this.createTstamp = createTstamp;
	}



	public PlatformRequestDTO createPlatformRequestDTO() {
		PlatformRequestDTO platformRequestDTO = new PlatformRequestDTO();
		
		platformRequestDTO.setPlatformRequestKey(platformRequestKey);
		platformRequestDTO.setPlatform(platform);
		platformRequestDTO.setEmployee(employee);
		platformRequestDTO.setStartDate(startDate);
		platformRequestDTO.setEndDate(endDate);
		platformRequestDTO.setWeeklyManpowerRequest(weeklyManpowerRequest);
		platformRequestDTO.setDuration(duration);
		platformRequestDTO.setComments(comments);
		platformRequestDTO.setCreateById(createById);
		platformRequestDTO.setCreateTstamp(createTstamp);
		
		return platformRequestDTO;
	}



	@Override
	public String toString() {
		return "PlatformRequest [platformRequestKey=" + platformRequestKey
				+ ", weeklyManpowerRequest=" + weeklyManpowerRequest
				+ ", platform=" + platform + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", duration=" + duration
				+ ", employee=" + employee + ", comments=" + comments
				+ ", createById=" + createById + ", createTstamp="
				+ createTstamp + "]";
	}



}
