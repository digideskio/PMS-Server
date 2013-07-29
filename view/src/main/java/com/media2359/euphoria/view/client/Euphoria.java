package com.media2359.euphoria.view.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.media2359.euphoria.view.message.project.Project;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectServiceAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Euphoria implements EntryPoint {
	private ProjectServiceAsync projectService = GWT.create(ProjectService.class);
	private String[] columns = {"Project Id", "Project Name", "Project Description"};

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Label label = new Label("....");
		final Button sendButton = new Button("Get All Projects");
		// Grids must be sized explicitly, though they can be resized later.
	    final Grid grid = new Grid(2, 3);
	    grid.setBorderWidth(1);//set a border
	    grid.setTitle("Project List");
	    for(int idx=0; idx < columns.length; idx++) {
	    	grid.setText(0, idx, columns[idx]);
	    }
	    
		RootPanel rootPanel = RootPanel.get("rootpane");

		rootPanel.add(sendButton);
		rootPanel.add(label);
		rootPanel.add(grid);

		final AsyncCallback<ProjectListResponse> callback = new AsyncCallback<ProjectListResponse>() {

			public void onFailure(Throwable caught) {
				label.setText("Error receiving data:"+caught.getMessage());

			}

			public void onSuccess(ProjectListResponse result) {
				List<Project> projects = result.getProjects();
				
				if((projects != null) && (!projects.isEmpty())) {
					// Put received values in the grid cells.
					grid.resize(projects.size() + 1, columns.length); //Resize table to have enough rows
				    for (int row = 1; row <= projects.size(); row++) {
				    	Project project = projects.get(row - 1);
				        grid.setText(row, 0, project.getId());
				        grid.setText(row, 1, project.getName());
				        grid.setText(row, 2, project.getDescription());
				    }
				} else {
					grid.resize(2, columns.length); //Resize table to have only one data row
					for(int idx=0; idx < columns.length; idx++) //Clear that row
						grid.clearCell(1, idx);
				}
			}
		};

		sendButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				projectService.getAllProjects(new ProjectListRequest(), callback);
			}
		});
	}
}
