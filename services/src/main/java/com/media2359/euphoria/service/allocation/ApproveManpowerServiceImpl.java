package com.media2359.euphoria.service.allocation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.server.allocation.ApproveManpowerService;

@Service("ApproveManpowerService")
public class ApproveManpowerServiceImpl implements ApproveManpowerService{

	@Override
	public String approveWeeklyRequest(Project project, Date weekStartDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeeklyManpowerRequest getWeeklyManpower(Project project,
			String weekStartDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
