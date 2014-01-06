package com.media2359.euphoria.view.client.manpower.common;

import java.util.Date;

public class ResourceDayPlan {
	Date date;
	String leaveName;
	boolean availableInMorning;
	boolean availableInEvening;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLeaveName() {
		return leaveName;
	}
	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}
	public boolean isAvailableInMorning() {
		return availableInMorning;
	}
	public void setAvailableInMorning(boolean availableInMorning) {
		this.availableInMorning = availableInMorning;
	}
	public boolean isAvailableInEvening() {
		return availableInEvening;
	}
	public void setAvailableInEvening(boolean availableInEvening) {
		this.availableInEvening = availableInEvening;
	}
}
