package com.media2359.euphoria.view.client.project;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.message.project.ProjectListResponse;

public class ProjectRpcHelper {
	//private ProjectServiceAsync projectService = GWT.create(ProjectService.class);

	/**
	 * Return the list of projects available in the system
	 *
	 * @returns void
	 */
	public static void getAllProjects(AsyncCallback<ProjectListResponse> callback) {
		callback.onSuccess(getDummyProjects());
	}
	
	private static ProjectListResponse getDummyProjects() {
		ProjectListResponse response = new ProjectListResponse();
		
		ArrayList<ProjectDTO> projects = new ArrayList<ProjectDTO>();
		ProjectDTO dto = new ProjectDTO();
		dto.setId(1);
		dto.setName("SGMalls");
		dto.setDescription("SGMalls project");
		dto.setManDaysLeft(300);
		dto.setMilestoneCount(10);
		dto.setCompletedMilestoneCount(2);
		dto.setProjectManager("Shiv.Kole@gmail.com");
		projects.add(dto);
		
		dto = new ProjectDTO();
		dto.setId(2);
		dto.setName("Burp Suite");
		dto.setDescription("Burp Suite project");
		dto.setManDaysLeft(400);
		dto.setMilestoneCount(20);
		dto.setCompletedMilestoneCount(12);
		dto.setProjectManager("Kate.Moss@gmail.com");
		projects.add(dto);

		dto = new ProjectDTO();
		dto.setId(3);
		dto.setName("Bill Me");
		dto.setDescription("Bill Me project");
		dto.setManDaysLeft(10);
		dto.setMilestoneCount(15);
		dto.setCompletedMilestoneCount(13);
		dto.setProjectManager("Lee.Chang@gmail.com");
		projects.add(dto);
		
		dto = new ProjectDTO();
		dto.setId(1);
		dto.setName("Phoenix Radio");
		dto.setDescription("Phoenix Radio project");
		dto.setManDaysLeft(14);
		dto.setMilestoneCount(26);
		dto.setCompletedMilestoneCount(16);
		dto.setProjectManager("John.Deo@gmail.com");
		projects.add(dto);
		
		dto = new ProjectDTO();
		dto.setId(1);
		dto.setName("VCMS");
		dto.setDescription("VCMS project");
		dto.setManDaysLeft(56);
		dto.setMilestoneCount(17);
		dto.setCompletedMilestoneCount(2);
		dto.setProjectManager("PM.Lee@gmail.com");
		projects.add(dto);
		response.setProjects(projects);
		
		return response;
	}
}
