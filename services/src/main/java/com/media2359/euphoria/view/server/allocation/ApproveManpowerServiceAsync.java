/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.server.allocation;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;

/**
 * ApproveManpowerServiceAsync
 *
 * TODO Write something about this class
 * 
 * @author shivkole
 * @version 1.0 2013
 **/

public interface ApproveManpowerServiceAsync {
	
	
		// Function to approve the manpower request
	
		public void approveWeeklyRequest(ProjectAllocationDTO projectAllocationDTO, 
				String weekStart,AsyncCallback<String> callback);
		

}
