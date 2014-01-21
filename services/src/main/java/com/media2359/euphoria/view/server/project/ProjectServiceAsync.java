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
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;

public interface ProjectServiceAsync {
	public void getAllProjects(ProjectListRequest request, AsyncCallback<ProjectListResponse> callback);
	
	public void  getProjectDetails(Integer projectId,AsyncCallback<ProjectDTO> callback);
	// Adds the project to the project database
	public void addProject(ProjectDTO project,AsyncCallback<String> callback);
	// Modifies the project to the project database
	public void modifyProject(ProjectDTO project,AsyncCallback<String> callback);
	// Deletes the project
	public void deleteProject(ProjectDTO project,AsyncCallback<String> callback);
	
	// Calculates the cost of the project 
	public void calculateProjectCost(ProjectDTO project,AsyncCallback<Integer> callback);
	
	// Get the maximum key of the project 
	public void getMaxKey(AsyncCallback<Integer> callback);
}
