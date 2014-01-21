package com.media2359.euphoria.service.allocation;

import org.springframework.stereotype.Service;

import com.media2359.euphoria.model.manpower.WeeklyManpowerAllocation;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.server.allocation.ModifyAllocationService;

@Service("ModifyAllocationService")
public class ModifyAllocationServiceImpl implements ModifyAllocationService {

	@Override
	public WeeklyManpowerAllocation getWeeklyManpowerAllocation(
			Project project, String weekStartDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateWeeklyManpowerAllocation(Project project,
			String weekStartDate, WeeklyManpowerAllocation manpowerAllocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
