package com.media2359.euphoria.view.client.manpower.common;

import java.util.Date;
import java.util.List;

public class ProjectAllocationDTO {
	Integer projectId;
	Date startOfWeek;
	List<WeeklyResourcePlan> weeklyResourcePlan;
	
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Date getStartOfWeek() {
		return startOfWeek;
	}
	public void setStartOfWeek(Date startOfWeek) {
		this.startOfWeek = startOfWeek;
	}
	public List<WeeklyResourcePlan> getWeeklyResourcePlan() {
		return weeklyResourcePlan;
	}
	public void setWeeklyResourcePlan(List<WeeklyResourcePlan> weeklyResourcePlan) {
		this.weeklyResourcePlan = weeklyResourcePlan;
	}

	
	
}
