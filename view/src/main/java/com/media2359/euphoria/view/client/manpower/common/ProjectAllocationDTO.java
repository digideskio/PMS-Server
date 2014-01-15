package com.media2359.euphoria.view.client.manpower.common;

import java.util.Date;
import java.util.List;

import com.media2359.euphoria.view.dto.project.ProjectDTO;

public class ProjectAllocationDTO {
	ProjectDTO projectDTO;

	Date startOfWeek;
	List<WeeklyResourcePlan> weeklyResourcePlan;

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}
	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
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
