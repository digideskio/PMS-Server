/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.server.project;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
/**
 * ProjectTeamServiceAsync
 *
 * TODO Write something about this class
 * 
 * @author shivkole
 * @version 1.0 2013
 **/

public interface ProjectTeamServiceAsync {
		
	// Gets the project team member
	public void getProjectTeam(ProjectDTO projectDto,AsyncCallback<ProjectTeamDTO> callback);
	
	// Adds the project team member 
	public void submitProjectTeam(ProjectTeamDTO projectTeamDTO,AsyncCallback<String> callback);

}
