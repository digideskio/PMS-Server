package com.media2359.euphoria.view.server.project;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;

public interface ProjectServiceAsync {
	public void getAllProjects(ProjectListRequest request, AsyncCallback<ProjectListResponse> callback);
}
