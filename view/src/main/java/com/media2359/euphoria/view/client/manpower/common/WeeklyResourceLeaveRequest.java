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

import java.util.ArrayList;
import java.util.Date;



public class WeeklyResourceLeaveRequest {
	String id;
	ArrayList<Date> weekDays;
	ArrayList<ResourceDayPlan> weeklyPlanList;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Boolean getMondayMorning() {
		return weeklyPlanList.get(0).isAvailableInMorning();
	}
	
	public Boolean getTuesdayMorning() {
		return weeklyPlanList.get(1).isAvailableInMorning();
	}
	
	public Boolean getWednesdayMorning() {
		return weeklyPlanList.get(2).isAvailableInMorning();
	}
	
	public Boolean getThursdayMorning() {
		return weeklyPlanList.get(3).isAvailableInMorning();
	}
	
	public Boolean getFridayMorning() {
		return weeklyPlanList.get(4).isAvailableInMorning();
	}
	
	public Boolean getMondayAfternoon() {
		return weeklyPlanList.get(0).isAvailableInEvening();
	}
	
	public Boolean getTuesdayAfternoon() {
		return weeklyPlanList.get(1).isAvailableInEvening();
	}
	
	public Boolean getWednesdayAfternoon() {
		return weeklyPlanList.get(2).isAvailableInEvening();
	}
	
	public Boolean getThursdayAfternoon() {
		return weeklyPlanList.get(3).isAvailableInEvening();
	}
	
	public Boolean getFridayAfternoon() {
		return weeklyPlanList.get(4).isAvailableInEvening();
	}

	public ArrayList<Date> getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(ArrayList<Date> weekDays) {
		this.weekDays = weekDays;
	}

	public ArrayList<ResourceDayPlan> getWeeklyPlanList() {
		return weeklyPlanList;
	}

	public void setWeeklyPlanList(ArrayList<ResourceDayPlan> weeklyPlanList) {
		this.weeklyPlanList = weeklyPlanList;
	}
}
