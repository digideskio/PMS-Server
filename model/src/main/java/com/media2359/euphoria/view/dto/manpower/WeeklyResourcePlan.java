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
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.util.AllocationStatus;



public class WeeklyResourcePlan {
	String id;
	
	private PlatformDTO platform ;
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
	
	private AllocationStatus day1AmEnm = AllocationStatus.FREE;
	private AllocationStatus day2AmEnm = AllocationStatus.FREE;
	private AllocationStatus day3AmEnm = AllocationStatus.FREE;
	private AllocationStatus day4AmEnm = AllocationStatus.FREE;
	private AllocationStatus day5AmEnm = AllocationStatus.FREE;
	private AllocationStatus day6AmEnm = AllocationStatus.FREE;
	private AllocationStatus day7AmEnm = AllocationStatus.FREE;

	private AllocationStatus day1PmEnm = AllocationStatus.FREE;
	private AllocationStatus day2PmEnm = AllocationStatus.FREE;
	private AllocationStatus day3PmEnm = AllocationStatus.FREE;
	private AllocationStatus day4PmEnm = AllocationStatus.FREE;
	private AllocationStatus day5PmEnm = AllocationStatus.FREE;
	private AllocationStatus day6PmEnm = AllocationStatus.FREE;
	private AllocationStatus day7PmEnm = AllocationStatus.FREE;

	
	
	public EmployeeDTO getDeveloper() {
		return developer;
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



	public void setDeveloper(EmployeeDTO developer) {
		this.developer = developer;
	}
	

	public PlatformDTO getPlatform() {
		return platform;
	}



	public void setPlatform(PlatformDTO platform) {
		this.platform = platform;
	}
	
	

	public AllocationStatus getDay1AmEnm() {
		return day1AmEnm;
	}



	public void setDay1AmEnm(AllocationStatus day1AmEnm) {
		this.day1AmEnm = day1AmEnm;
	}



	public AllocationStatus getDay2AmEnm() {
		return day2AmEnm;
	}



	public void setDay2AmEnm(AllocationStatus day2AmEnm) {
		this.day2AmEnm = day2AmEnm;
	}



	public AllocationStatus getDay3AmEnm() {
		return day3AmEnm;
	}



	public void setDay3AmEnm(AllocationStatus day3AmEnm) {
		this.day3AmEnm = day3AmEnm;
	}



	public AllocationStatus getDay4AmEnm() {
		return day4AmEnm;
	}



	public void setDay4AmEnm(AllocationStatus day4AmEnm) {
		this.day4AmEnm = day4AmEnm;
	}



	public AllocationStatus getDay5AmEnm() {
		return day5AmEnm;
	}



	public void setDay5AmEnm(AllocationStatus day5AmEnm) {
		this.day5AmEnm = day5AmEnm;
	}



	public AllocationStatus getDay6AmEnm() {
		return day6AmEnm;
	}



	public void setDay6AmEnm(AllocationStatus day6AmEnm) {
		this.day6AmEnm = day6AmEnm;
	}



	public AllocationStatus getDay7AmEnm() {
		return day7AmEnm;
	}



	public void setDay7AmEnm(AllocationStatus day7AmEnm) {
		this.day7AmEnm = day7AmEnm;
	}



	public AllocationStatus getDay1PmEnm() {
		return day1PmEnm;
	}



	public void setDay1PmEnm(AllocationStatus day1PmEnm) {
		this.day1PmEnm = day1PmEnm;
	}



	public AllocationStatus getDay2PmEnm() {
		return day2PmEnm;
	}



	public void setDay2PmEnm(AllocationStatus day2PmEnm) {
		this.day2PmEnm = day2PmEnm;
	}



	public AllocationStatus getDay3PmEnm() {
		return day3PmEnm;
	}



	public void setDay3PmEnm(AllocationStatus day3PmEnm) {
		this.day3PmEnm = day3PmEnm;
	}



	public AllocationStatus getDay4PmEnm() {
		return day4PmEnm;
	}



	public void setDay4PmEnm(AllocationStatus day4PmEnm) {
		this.day4PmEnm = day4PmEnm;
	}



	public AllocationStatus getDay5PmEnm() {
		return day5PmEnm;
	}



	public void setDay5PmEnm(AllocationStatus day5PmEnm) {
		this.day5PmEnm = day5PmEnm;
	}



	public AllocationStatus getDay6PmEnm() {
		return day6PmEnm;
	}



	public void setDay6PmEnm(AllocationStatus day6PmEnm) {
		this.day6PmEnm = day6PmEnm;
	}



	public AllocationStatus getDay7PmEnm() {
		return day7PmEnm;
	}



	public void setDay7PmEnm(AllocationStatus day7PmEnm) {
		this.day7PmEnm = day7PmEnm;
	}



	
}
