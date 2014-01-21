/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.employee;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.employee.EmployeeLeaveDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
/**
 * EmployeeLeave
 * 
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "employee_leave")  
public class EmployeeLeave implements java.io.Serializable{
	
	@Id
	@GeneratedValue(generator = "EmployeeLeaveGenerator")     
	@GenericGenerator(name = "EmployeeLeaveGenerator", strategy = "increment") 
	@Column(name = "leave_key")
	private Integer employeeLeaveKey;
	
	@ManyToOne
	@JoinColumn(name = "employee_key")
	private Employee employee;
	
	@Column(name = "leave_date")
	private Date leaveDate;
	
	@Column(name = "half_day_flg") 
	private String halfdayFlg;
	
	@Column(name = "create_by_id")
	private String createdById;
	
	@Column(name = "create_tstamp")
	private Date createTstamp;
	
	@Column(name = "last_upd_by_id")
	private String lastUpdById;
	
	@Column(name = "last_upd_tstamp")
	private Date lastUpdTstamp;

	public EmployeeLeave() {

	}

	public EmployeeLeave(EmployeeLeaveDTO employeeLeaveDTO) {
		
		this.setEmployeeLeaveKey(employeeLeaveDTO.getEmployeeLeaveKey());
		this.setEmployee(employeeLeaveDTO.getEmployee());
		this.setLeaveDate(employeeLeaveDTO.getLeaveDate());
		this.setHalfdayFlg(employeeLeaveDTO.getHalfdayFlg());
		this.setCreatedById(employeeLeaveDTO.getCreatedById());
		this.setCreateTstamp(employeeLeaveDTO.getCreateTstamp());
		this.setLastUpdById(employeeLeaveDTO.getLastUpdById());
		this.setLastUpdTstamp(employeeLeaveDTO.getLastUpdTstamp());
	}

	
	
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

	public EmployeeLeaveDTO createEmployeeLeaveDTO() {
		EmployeeLeaveDTO employeeLeaveDTO = new EmployeeLeaveDTO();
		
		employeeLeaveDTO.setEmployeeLeaveKey(this.getEmployeeLeaveKey());
		employeeLeaveDTO.setEmployee(this.getEmployee());
		employeeLeaveDTO.setLeaveDate(this.getLeaveDate());
		employeeLeaveDTO.setHalfdayFlg(this.getHalfdayFlg());
		employeeLeaveDTO.setCreatedById(this.getCreatedById());
		employeeLeaveDTO.setCreateTstamp(this.getCreateTstamp());
		employeeLeaveDTO.setLastUpdById(this.getLastUpdById());
		employeeLeaveDTO.setLastUpdTstamp(employeeLeaveDTO.getLastUpdTstamp());
		return employeeLeaveDTO;
	}

	@Override
	public String toString() {
		return "EmployeeLeave [employeeLeaveKey=" + employeeLeaveKey
				+ ", employee=" + employee + ", leaveDate=" + leaveDate
				+ ", halfdayFlg=" + halfdayFlg + ", createdById=" + createdById
				+ ", createTstamp=" + createTstamp + ", lastUpdById="
				+ lastUpdById + ", lastUpdTstamp=" + lastUpdTstamp + "]";
	}
}
