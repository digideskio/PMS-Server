package com.media2359.euphoria.view.client.project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectServiceAsync;

public class ProjectRpcHelper {
	
	/**
	 * Return the list of projects available in the system
	 *
	 * @returns void
	 */
	
	
	protected static final ProjectServiceAsync projectService = GWT.create(ProjectService.class);
	
	public static void getAllProjects(AsyncCallback<ProjectListResponse> callback) {
		projectService.getAllProjects(new ProjectListRequest(), callback);
	}
}
