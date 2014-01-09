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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;

/**
 * ProjectTeamService
 *
 * TODO Write something about this class
 * 
 * @author shivkole
 * @version 1.0 2013
 **/

@RemoteServiceRelativePath("service/ProjectTeamService")
public interface ProjectTeamService extends RemoteService{
	
	
	// Gets the project team member
	public ProjectTeamDTO getProjectTeam(ProjectDTO projectDto);
	
	// Adds the project team member 
	public String submitProjectTeam(ProjectTeamDTO projectTeamDTO);
	
	

}
