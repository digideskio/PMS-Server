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
import com.media2359.euphoria.model.manpower.WeeklyManpowerAllocation;
import com.media2359.euphoria.model.project.Project;

/**
 * ModifyAllocationServiceAsync
 *
 * TODO Write something about this class
 * 
 * @author shivkole
 * @version 1.0 2013
 **/

public interface ModifyAllocationServiceAsync {
	
	
	// Get the allocation 
	
		public void getWeeklyManpowerAllocation(Project project, 
				String weekStartDate,AsyncCallback<WeeklyManpowerAllocation> callback);
		
		// update the allocation 
		public void updateWeeklyManpowerAllocation(Project project,String weekStartDate,
				WeeklyManpowerAllocation manpowerAllocation,AsyncCallback<String> callback);

}
