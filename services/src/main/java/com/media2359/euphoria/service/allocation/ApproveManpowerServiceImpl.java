package com.media2359.euphoria.service.allocation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.server.allocation.ApproveManpowerService;

@Service("ApproveManpowerService")
public class ApproveManpowerServiceImpl implements ApproveManpowerService{

	@Override
	public String approveWeeklyRequest(
			ProjectAllocationDTO projectAllocationDTO, Date weekStartDate) {
		String status = "APPROVED";
		
		
		return status;
	
	}

	

}
