package com.media2359.euphoria.view.client.dashboard;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.dto.milestone.MilestoneDTO;
import com.media2359.euphoria.view.dto.milestone.MilestoneListRequest;
import com.media2359.euphoria.view.dto.milestone.MilestoneListResponse;

public class MilestoneRpcHelper {
	//private ProjectServiceAsync projectService = GWT.create(ProjectService.class);

	/**
	 * Return the list of projects available in the system
	 *
	 * @returns void
	 */
	public static void getAllMilestones(Date startDate, Date endDate, AsyncCallback<MilestoneListResponse> callback) {
		MilestoneListRequest request = new MilestoneListRequest();
		request.setStartDate(startDate);
		request.setEndDate(endDate);
		callback.onSuccess(getDummyMilestones());
	}
	
	private static MilestoneListResponse getDummyMilestones() {
		MilestoneListResponse response = new MilestoneListResponse();
		ArrayList<MilestoneDTO> milestones = new ArrayList<MilestoneDTO>();
		MilestoneDTO milestone = new MilestoneDTO();
		milestone.setProjectName("SGMalls");
		milestone.setMilestoneName("Payment 1");
		milestone.setDueDate(new Date());
		milestones.add(milestone);
		
		milestone = new MilestoneDTO();
		milestone.setProjectName("BlackBuck");
		milestone.setMilestoneName("Payment 1");
		milestone.setDueDate(new Date());
		milestones.add(milestone);
		response.setMilestones(milestones);
		return response;
	}
}
