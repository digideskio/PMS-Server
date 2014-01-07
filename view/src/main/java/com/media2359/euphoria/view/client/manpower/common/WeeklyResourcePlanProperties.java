package com.media2359.euphoria.view.client.manpower.common;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface WeeklyResourcePlanProperties extends
		PropertyAccess<WeeklyResourcePlan> {
	@Path("id")
	ModelKeyProvider<WeeklyResourcePlan> key();

	ValueProvider<WeeklyResourcePlan, String> platform();
	
	ValueProvider<WeeklyResourcePlan, String> developer();
	
	ValueProvider<WeeklyResourcePlan, Boolean> day1Am();

	ValueProvider<WeeklyResourcePlan, Boolean> day2Am();

	ValueProvider<WeeklyResourcePlan, Boolean> day3Am();

	ValueProvider<WeeklyResourcePlan, Boolean> day4Am();

	ValueProvider<WeeklyResourcePlan, Boolean> day5Am();

	ValueProvider<WeeklyResourcePlan, Boolean> day6Am();

	ValueProvider<WeeklyResourcePlan, Boolean> day7Am();

	ValueProvider<WeeklyResourcePlan, Boolean> day1Pm();

	ValueProvider<WeeklyResourcePlan, Boolean> day2Pm();

	ValueProvider<WeeklyResourcePlan, Boolean> day3Pm();

	ValueProvider<WeeklyResourcePlan, Boolean> day4Pm();

	ValueProvider<WeeklyResourcePlan, Boolean> day5Pm();

	ValueProvider<WeeklyResourcePlan, Boolean> day6Pm();

	ValueProvider<WeeklyResourcePlan, Boolean> day7Pm();
}
