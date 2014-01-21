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
 * Holiday
 *
 * TODO Write something about this class
 * 
 * @author TY
 * @version 1.0 2013
 **/

public class HolidayDTO implements Serializable {
    
	private Integer holidayKey;
	private Date holidayDate;
	private String holidayDesc;
	private String createdById;
	private Date createTstamp;
	private String lastUpdById;
	private Date lastUpdTstamp;
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
	@Override
	public String toString() {
		return "HolidayDTO [holidayKey=" + holidayKey + ", holidayDate="
				+ holidayDate + ", holidayDesc=" + holidayDesc
				+ ", createdById=" + createdById + ", createTstamp="
				+ createTstamp + ", lastUpdById=" + lastUpdById
				+ ", lastUpdTstamp=" + lastUpdTstamp + "]";
	}
	
}
