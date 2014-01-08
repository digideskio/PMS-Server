/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.common;

import com.media2359.euphoria.view.client.core.AllocationStatus;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;



public class WeeklyResourcePlan {
	String id;
	
	private String platform = "";
	private EmployeeDTO developer = null;

	private AllocationStatus day1Am = AllocationStatus.FREE;
	private AllocationStatus day2Am = AllocationStatus.FREE;
	private AllocationStatus day3Am = AllocationStatus.FREE;
	private AllocationStatus day4Am = AllocationStatus.FREE;
	private AllocationStatus day5Am = AllocationStatus.FREE;


	private AllocationStatus day1Pm = AllocationStatus.FREE;
	private AllocationStatus day2Pm = AllocationStatus.FREE;
	private AllocationStatus day3Pm = AllocationStatus.FREE;
	private AllocationStatus day4Pm = AllocationStatus.FREE;
	private AllocationStatus day5Pm = AllocationStatus.FREE;

	
	
	
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
	
	public AllocationStatus getDay1Am() {
		return day1Am;
	}
	
	public AllocationStatus getDay2Am() {
		return day2Am;
	}
	
	public AllocationStatus getDay3Am() {
		return day3Am;
	}
	
	public AllocationStatus getDay4Am() {
		return day4Am;
	}
	
	public AllocationStatus getDay5Am() {
		return day5Am;
	}

	
	public AllocationStatus getDay1Pm() {
		return day1Pm;
	}
	
	public AllocationStatus getDay2Pm() {
		return day2Pm;
	}
	
	public AllocationStatus getDay3Pm() {
		return day3Pm;
	}
	
	public AllocationStatus getDay4Pm() {
		return day4Pm;
	}
	
	public AllocationStatus getDay5Pm() {
		return day5Pm;
	}
	
	public void setDeveloper(EmployeeDTO developer) {
		this.developer = developer;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void setDay1Am(AllocationStatus day1Am) {
		this.day1Am = day1Am;
	}

	public void setDay2Am(AllocationStatus day2Am) {
		this.day2Am = day2Am;
	}

	public void setDay3Am(AllocationStatus day3Am) {
		this.day3Am = day3Am;
	}

	public void setDay4Am(AllocationStatus day4Am) {
		this.day4Am = day4Am;
	}

	public void setDay5Am(AllocationStatus day5Am) {
		this.day5Am = day5Am;
	}

	public void setDay1Pm(AllocationStatus day1Pm) {
		this.day1Pm = day1Pm;
	}

	public void setDay2Pm(AllocationStatus day2Pm) {
		this.day2Pm = day2Pm;
	}

	public void setDay3Pm(AllocationStatus day3Pm) {
		this.day3Pm = day3Pm;
	}

	public void setDay4Pm(AllocationStatus day4Pm) {
		this.day4Pm = day4Pm;
	}

	public void setDay5Pm(AllocationStatus day5Pm) {
		this.day5Pm = day5Pm;
	}

}
