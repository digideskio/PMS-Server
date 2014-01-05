package com.media2359.euphoria.view.dto.manpower;

import java.util.Date;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;

public class PlatformRequestDTO {
	
	private Integer platformRequestKey;
	private Platform platform;
	private Employee employee;
	private Date startDate;
	private Date endDate;
	
	
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
	
	
	

}
