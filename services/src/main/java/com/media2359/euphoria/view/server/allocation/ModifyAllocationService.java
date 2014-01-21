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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.media2359.euphoria.model.manpower.WeeklyManpowerAllocation;
import com.media2359.euphoria.model.project.Project;

/**
 * ModifyAllocationService
 *
 * TODO Write something about this class
 * 
 * @author shivkole
 * @version 1.0 2013
 **/
@RemoteServiceRelativePath("service/ModifyAllocationService")
public interface ModifyAllocationService extends RemoteService{
	
	// Get the allocation 
	
	public WeeklyManpowerAllocation getWeeklyManpowerAllocation(Project project, 
			String weekStartDate);
	
	// update the allocation 
	public String updateWeeklyManpowerAllocation(Project project,String weekStartDate,
			WeeklyManpowerAllocation manpowerAllocation);
	
	

}
