package com.media2359.euphoria.view.dto.manpower;

import java.io.Serializable;
import java.util.Date;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Platform;

public class PlatformRequestDTO implements Serializable {
	
	private Integer platformRequestKey;
	private Platform platform;
	private Employee employee;
	private Date startDate;
	private Date endDate;
	private WeeklyManpowerRequest weeklyManpowerRequest;
	private Float duration;
	private String comments;
	private String createById;
	private Date createTstamp;
	
	public Integer getPlatformRequestKey() {
		return platformRequestKey;
	}
	public void setPlatformRequestKey(Integer platformRequestKey) {
		this.platformRequestKey = platformRequestKey;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	public WeeklyManpowerRequest getWeeklyManpowerRequest() {
		return weeklyManpowerRequest;
	}
	public void setWeeklyManpowerRequest(WeeklyManpowerRequest weeklyManpowerRequest) {
		this.weeklyManpowerRequest = weeklyManpowerRequest;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
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


}
