package com.media2359.euphoria.view.client.manpower.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;

public class WeeklyResourcePlanResponse {
	Date weekStartDate;
	List<WeeklyResourcePlan> weeklyResourcePlanList;

	public List<WeeklyResourcePlan> getWeeklyResourcePlanList() {
		return weeklyResourcePlanList;
	}

	public void setWeeklyResourcePlanList(
			List<WeeklyResourcePlan> weeklyResourcePlanList) {
		this.weeklyResourcePlanList = weeklyResourcePlanList;
	}

	public Date getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(Date weekStartDate) {
		this.weekStartDate = weekStartDate;
	}
}
