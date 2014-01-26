package com.media2359.euphoria.view.dto.manpower;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		
		Date formattedStartOfWeek=startOfWeek;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strStartDate = simpleDateFormat.format(startOfWeek);
		System.out.println("Date is "+strStartDate);
		try{
			formattedStartOfWeek = simpleDateFormat.parse(strStartDate);
			System.out.println("New date is "+formattedStartOfWeek);
		}catch(Exception exp){
			
		}
		return formattedStartOfWeek;
		
	}
	public void setStartOfWeek(Date startOfWeek) {
		this.startOfWeek = startOfWeek;
	}
	public List<WeeklyResourcePlan> getWeeklyResourcePlanList() {
		return weeklyResourcePlanList;
	}
	public void setWeeklyResourcePlanList(List<WeeklyResourcePlan> weeklyResourcePlanList) {
		List<WeeklyResourcePlan> newList = new ArrayList<WeeklyResourcePlan>();
		for(WeeklyResourcePlan weeklyResourcePlan2 : weeklyResourcePlanList)
			newList.add(weeklyResourcePlan2);
		
		this.weeklyResourcePlanList = newList;
	}
	@Override
	public String toString() {
		return "ProjectAllocationDTO [projectDTO=" + projectDTO
				+ ", startOfWeek=" + startOfWeek + ", weeklyResourcePlan="
				+ weeklyResourcePlanList + "]";
	}

	
	
}
