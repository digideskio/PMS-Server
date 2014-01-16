package com.media2359.euphoria.view.client.manpower.common;

import com.google.gwt.editor.client.Editor.Path;
import com.media2359.euphoria.view.client.core.AllocationStatus;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface WeeklyResourcePlanProperties extends
		PropertyAccess<WeeklyResourcePlan> {
	@Path("id")
	ModelKeyProvider<WeeklyResourcePlan> key();

	//@Path("platform.platformId")
	ValueProvider<WeeklyResourcePlan, PlatformDTO> platform();
	
	ValueProvider<WeeklyResourcePlan, EmployeeDTO> developer();
	
	ValueProvider<WeeklyResourcePlan, AllocationStatus> day1Am();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day2Am();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day3Am();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day4Am();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day5Am();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day6Am();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day7Am();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day1Pm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day2Pm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day3Pm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day4Pm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day5Pm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day6Pm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day7Pm();
}
