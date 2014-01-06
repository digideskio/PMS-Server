package com.media2359.euphoria.view.client.manpower.common;

import java.util.ArrayList;
import java.util.Date;

public class WeeklyResourcePlanResponse {
	Date weekStartDate;
	ArrayList<WeeklyResourcePlan> weeklyResourcePlanList;

	public ArrayList<WeeklyResourcePlan> getWeeklyResourcePlanList() {
		return weeklyResourcePlanList;
	}

	public void setWeeklyResourcePlanList(
			ArrayList<WeeklyResourcePlan> weeklyResourcePlanList) {
		this.weeklyResourcePlanList = weeklyResourcePlanList;
	}

	public Date getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(Date weekStartDate) {
		this.weekStartDate = weekStartDate;
	}
}
