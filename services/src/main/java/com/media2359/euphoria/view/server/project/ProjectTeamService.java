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
	
	// Adds the prject team to the prject
	public String addProjectTeam(Project project, ProjectTeam projectTeam);
	
	// Modifies the project team to the prject
	public String modifyProjectTeam(Project project, ProjectTeam projectTeam);
	
	// Get all the team members 
	public ProjectTeam getAllTeamMembers(Project project);
	
	// Deletes the team member for a project
	public String deleteProjectTeamMember(Project project, Employee employee);
	// Adds new team member to the project
	public String addProjectTeamMember (Project project, Employee employee);
	
	

}
