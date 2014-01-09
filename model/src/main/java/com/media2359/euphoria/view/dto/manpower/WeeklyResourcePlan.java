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

import com.media2359.euphoria.view.dto.employee.EmployeeDTO;



public class WeeklyResourcePlan {
	String id;
	
	private String platform = "";
	private EmployeeDTO developer = null;

	private Boolean day1Am = false;
	private Boolean day2Am = false;
	private Boolean day3Am = false;
	private Boolean day4Am = false;
	private Boolean day5Am = false;
	private Boolean day6Am = false;
	private Boolean day7Am = false;

	private Boolean day1Pm = false;
	private Boolean day2Pm = false;
	private Boolean day3Pm = false;
	private Boolean day4Pm = false;
	private Boolean day5Pm = false;
	private Boolean day6Pm = false;
	private Boolean day7Pm = false;
	
	
	
	public EmployeeDTO getDeveloper() {
		return developer;
	}

	public String getPlatform() {
		return platform;
	}


	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Boolean getDay1Am() {
		return day1Am;
	}
	
	public Boolean getDay2Am() {
		return day2Am;
	}
	
	public Boolean getDay3Am() {
		return day3Am;
	}
	
	public Boolean getDay4Am() {
		return day4Am;
	}
	
	public Boolean getDay5Am() {
		return day5Am;
	}

	public Boolean getDay6Am() {
		return day6Am;
	}
	
	public Boolean getDay7Am() {
		return day7Am;
	}
	
	public Boolean getDay1Pm() {
		return day1Pm;
	}
	
	public Boolean getDay2Pm() {
		return day2Pm;
	}
	
	public Boolean getDay3Pm() {
		return day3Pm;
	}
	
	public Boolean getDay4Pm() {
		return day4Pm;
	}
	
	public Boolean getDay5Pm() {
		return day5Pm;
	}
	
	public Boolean getDay6Pm() {
		return day6Pm;
	}
	
	public Boolean getDay7Pm() {
		return day7Pm;
	}
	
	public void setDeveloper(EmployeeDTO developer) {
		this.developer = developer;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void setDay1Am(Boolean day1Am) {
		this.day1Am = day1Am;
	}

	public void setDay2Am(Boolean day2Am) {
		this.day2Am = day2Am;
	}

	public void setDay3Am(Boolean day3Am) {
		this.day3Am = day3Am;
	}

	public void setDay4Am(Boolean day4Am) {
		this.day4Am = day4Am;
	}

	public void setDay5Am(Boolean day5Am) {
		this.day5Am = day5Am;
	}

	public void setDay6Am(Boolean day6Am) {
		this.day6Am = day6Am;
	}

	public void setDay7Am(Boolean day7Am) {
		this.day7Am = day7Am;
	}

	public void setDay1Pm(Boolean day1Pm) {
		this.day1Pm = day1Pm;
	}

	public void setDay2Pm(Boolean day2Pm) {
		this.day2Pm = day2Pm;
	}

	public void setDay3Pm(Boolean day3Pm) {
		this.day3Pm = day3Pm;
	}

	public void setDay4Pm(Boolean day4Pm) {
		this.day4Pm = day4Pm;
	}

	public void setDay5Pm(Boolean day5Pm) {
		this.day5Pm = day5Pm;
	}

	public void setDay6Pm(Boolean day6Pm) {
		this.day6Pm = day6Pm;
	}

	public void setDay7Pm(Boolean day7Pm) {
		this.day7Pm = day7Pm;
	}
}
