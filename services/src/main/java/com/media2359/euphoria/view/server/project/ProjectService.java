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
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;

@RemoteServiceRelativePath("service/ProjectService")
public interface ProjectService extends RemoteService {
	// Gets all the project details 
	public ProjectListResponse getAllProjects(ProjectListRequest request);
	// Gets the details of the specific project
	public Project  getProjectDetails(Integer projectId);
	// Adds the project to the project database
	public String addProject(Project project);
	// Modifies the project to the project database
	public String modifyProject(Project project);
	// Deletes the project
	public String deleteProject(Project project);
	
	// Calculates the cost of the project 
	public Integer calculateProjectCost(Project project);
	
	// Get the maximum key of the project 
	public Integer getMaxKey();
	
	
}
