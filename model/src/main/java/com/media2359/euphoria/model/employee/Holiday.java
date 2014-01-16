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
import com.media2359.euphoria.view.dto.employee.HolidayDTO;
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
 * Holiday
 * 
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "holiday")  
public class Holiday implements java.io.Serializable{
	
	@Id
	@GeneratedValue(generator = "HolidayGenerator")     
	@GenericGenerator(name = "HolidayGenerator", strategy = "increment") 
	@Column(name = "holiday_key")
	private Integer holidayKey;
	
	@Column(name = "holiday_date")
	private Date holidayDate;
	
	@Column(name = "holiday_desc") 
	private String holidayDesc;
	
	@Column(name = "create_by_id")
	private String createdById;
	
	@Column(name = "create_tstamp")
	private Date createTstamp;
	
	@Column(name = "last_upd_by_id")
	private String lastUpdById;
	
	@Column(name = "last_upd_tstamp")
	private Date lastUpdTstamp;

	public Holiday() {

	}

	public Holiday(HolidayDTO holidayDto) {
		
		this.setHolidayKey(holidayDto.getHolidayKey());
		this.setHolidayDate(holidayDto.getHolidayDate());
		this.setHolidayDesc(holidayDto.getHolidayDesc());
		this.setCreatedById(holidayDto.getCreatedById());
		this.setCreateTstamp(holidayDto.getCreateTstamp());
		this.setLastUpdById(holidayDto.getLastUpdById());
		this.setLastUpdTstamp(holidayDto.getLastUpdTstamp());
	}


	public Integer getHolidayKey() {
		return holidayKey;
	}

	public void setHolidayKey(Integer holidayKey) {
		this.holidayKey = holidayKey;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getHolidayDesc() {
		return holidayDesc;
	}

	public void setHolidayDesc(String holidayDesc) {
		this.holidayDesc = holidayDesc;
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

	public HolidayDTO createHolidayDTO() {
		HolidayDTO holidayDto = new HolidayDTO();
		
		holidayDto.setHolidayKey(this.getHolidayKey());
		holidayDto.setHolidayDate(this.getHolidayDate());
		holidayDto.setHolidayDesc(this.getHolidayDesc());
		holidayDto.setCreatedById(this.getCreatedById());
		holidayDto.setCreateTstamp(this.getCreateTstamp());
		holidayDto.setLastUpdById(this.getLastUpdById());
		holidayDto.setLastUpdTstamp(this.getLastUpdTstamp());
		return holidayDto;
	}

	@Override
	public String toString() {
		return "Holiday [holidayKey=" + holidayKey + ", holidayDate="
				+ holidayDate + ", holidayDesc=" + holidayDesc
				+ ", createdById=" + createdById + ", createTstamp="
				+ createTstamp + ", lastUpdById=" + lastUpdById
				+ ", lastUpdTstamp=" + lastUpdTstamp + "]";
	}
}
