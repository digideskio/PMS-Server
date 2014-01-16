package com.media2359.euphoria.view.client.manpower.common;

import com.google.gwt.editor.client.Editor.Path;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.util.AllocationStatus;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface WeeklyResourcePlanProperties extends
		PropertyAccess<WeeklyResourcePlan> {
	@Path("id")
	ModelKeyProvider<WeeklyResourcePlan> key();

	ValueProvider<WeeklyResourcePlan, PlatformDTO> platform();
	
	ValueProvider<WeeklyResourcePlan, EmployeeDTO> developer();
	
	ValueProvider<WeeklyResourcePlan, AllocationStatus> day1AmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day2AmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day3AmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day4AmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day5AmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day6AmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day7AmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day1PmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day2PmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day3PmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day4PmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day5PmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day6PmEnm();

	ValueProvider<WeeklyResourcePlan, AllocationStatus> day7PmEnm();
}
