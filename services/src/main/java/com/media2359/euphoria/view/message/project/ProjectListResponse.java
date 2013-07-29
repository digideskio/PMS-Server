package com.media2359.euphoria.view.message.project;

import java.io.Serializable;
import java.util.List;

public class ProjectListResponse implements Serializable {
	List<Project> projects;
	
	public ProjectListResponse() {

	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
