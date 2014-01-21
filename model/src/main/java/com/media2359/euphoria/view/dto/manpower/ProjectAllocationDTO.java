package com.media2359.euphoria.view.dto.manpower;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.media2359.euphoria.view.dto.project.ProjectDTO;


public class ProjectAllocationDTO implements Serializable{
	ProjectDTO projectDTO;
	
	Date startOfWeek;
	List<WeeklyResourcePlan> weeklyResourcePlanList;
	
	
	
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
	public List<WeeklyResourcePlan> getWeeklyResourcePlanList() {
		return weeklyResourcePlanList;
	}
	public void setWeeklyResourcePlanList(List<WeeklyResourcePlan> weeklyResourcePlan) {
		this.weeklyResourcePlanList = weeklyResourcePlan;
	}
	@Override
	public String toString() {
		return "ProjectAllocationDTO [projectDTO=" + projectDTO
				+ ", startOfWeek=" + startOfWeek + ", weeklyResourcePlan="
				+ weeklyResourcePlanList + "]";
	}

	
	
}
