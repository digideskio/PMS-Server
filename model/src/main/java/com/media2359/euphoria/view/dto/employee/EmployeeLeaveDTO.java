/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.employee;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
/**
 * Employee
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class EmployeeLeaveDTO implements Serializable {
    
	private Integer employeeLeaveKey;
	
	private Employee employee;
	private Date leaveDate;
	private String halfdayFlg;
	private String createdById;
	private Date createTstamp;
	private String lastUpdById;
	private Date lastUpdTstamp;
	
	

	public Integer getEmployeeLeaveKey() {
		return employeeLeaveKey;
	}



	public void setEmployeeLeaveKey(Integer employeeLeaveKey) {
		this.employeeLeaveKey = employeeLeaveKey;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Date getLeaveDate() {
		return leaveDate;
	}



	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}



	public String getHalfdayFlg() {
		return halfdayFlg;
	}



	public void setHalfdayFlg(String halfdayFlg) {
		this.halfdayFlg = halfdayFlg;
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



	@Override
	public String toString() {
		return "EmployeeLeaveDTO [employeeLeaveKey=" + employeeLeaveKey
				+ ", employee=" + employee + ", leaveDate=" + leaveDate
				+ ", halfdayFlg=" + halfdayFlg + ", createdById=" + createdById
				+ ", createTstamp=" + createTstamp + ", lastUpdById="
				+ lastUpdById + ", lastUpdTstamp=" + lastUpdTstamp + "]";
	}
}
