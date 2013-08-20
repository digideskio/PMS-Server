package com.media2359.euphoria.view.client.project;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.media2359.euphoria.view.message.project.Project;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectServiceAsync;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class ProjectSummaryPanel extends Composite {
	private ProjectServiceAsync projectService = GWT.create(ProjectService.class);

	/**
	 * This is the entry point method.
	 */
	public ProjectSummaryPanel() {
		final TextButton sendButton = new TextButton("Get All Projects");
		final ProjectGrid basicGrid = new ProjectGrid();
		final AutoProgressMessageBox messageBox = new AutoProgressMessageBox("Progress", "Contacting server. Please wait...");

		VerticalPanel panel = new VerticalPanel();
		panel.add(sendButton);
		panel.add(basicGrid);
		
		final AsyncCallback<ProjectListResponse> callback = new AsyncCallback<ProjectListResponse>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert  = new AlertMessageBox("Error", caught.getMessage()); 
				alert.show();
			}

			public void onSuccess(ProjectListResponse result) {
				messageBox.hide();
				List<Project> projects = result.getProjects();
				
				if((projects != null) && (!projects.isEmpty())) {
				    //Now populate GXT Grid
				    basicGrid.populateData(projects);
				} else {
					//Remove all items
					basicGrid.clear();
				}
			}
		};

		sendButton.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				messageBox.auto();
				messageBox.show();
				projectService.getAllProjects(new ProjectListRequest(), callback);
			}
			
		});
		
		initWidget(panel);
	}
}
