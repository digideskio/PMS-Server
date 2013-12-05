/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.request;

import java.util.Date;


public class WeeklyResourceLeaveRequest {
	String id;
	Date weekStartDate;
	Integer[] dayType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getWeekStartDate() {
		return weekStartDate;
	}
	public void setWeekStartDate(Date weekStartDate) {
		this.weekStartDate = weekStartDate;
	}
	public Integer[] getDayType() {
		return dayType;
	}
	public void setDayType(Integer[] dayType) {
		this.dayType = dayType;
	}
	
	public Boolean getMondayMorning() {
		return true;
	}
	
	public Boolean getTuesdayMorning() {
		return true;
	}
	
	public Boolean getWednesdayMorning() {
		return true;
	}
	
	public Boolean getThursdayMorning() {
		return true;
	}
	
	public Boolean getFridayMorning() {
		return true;
	}
	
	public Boolean getMondayAfternoon() {
		return true;
	}
	
	public Boolean getTuesdayAfternoon() {
		return true;
	}
	
	public Boolean getWednesdayAfternoon() {
		return true;
	}
	
	public Boolean getThursdayAfternoon() {
		return true;
	}
	
	public Boolean getFridayAfternoon() {
		return true;
	}
	
	
	public void setMondayMorning(Boolean value) {
		
	}
	
	public void setTuesdayMorning(Boolean value) {
		
	}
	
	public void setWednesdayMorning(Boolean value) {
		
	}
	
	public void setThursdayMorning(Boolean value) {
		
	}
	
	public void setFridayMorning(Boolean value) {
		
	}
}
