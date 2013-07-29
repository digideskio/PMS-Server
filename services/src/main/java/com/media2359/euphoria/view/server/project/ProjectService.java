package com.media2359.euphoria.view.server.project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;

@RemoteServiceRelativePath("service/ProjectService")
public interface ProjectService extends RemoteService {
	public ProjectListResponse getAllProjects(ProjectListRequest request);
}
