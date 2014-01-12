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
	public static void getAllProjects(AsyncCallback<ProjectListResponse> callback) {
		ProjectServiceAsync projectService = GWT.create(ProjectService.class);
		projectService.getAllProjects(new ProjectListRequest(), callback);
	}
}
