package com.media2359.euphoria.view.client.manpower;

import java.util.Date;

public class WeeklyResourceRequest {
	String id;
	String platform;
	String resource;
	Float duration;
	String startDate;
	String comment;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comments) {
		this.comment = comments;
	}	
}
