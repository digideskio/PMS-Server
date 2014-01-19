package com.media2359.euphoria.view.client.project;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.client.core.Alert;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectServiceAsync;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class ProjectPresenter {
	
	private ProjectSummaryPanel projectSummaryPanel;
	
	private List<ProjectDTO> allProjects;
	private ProjectGrid projectGrid;
	
	Logger log = Logger.getLogger("EuphoriaLogger");
	
	public ProjectPresenter(ProjectSummaryPanel projectSummaryPanel,ProjectGrid projectGrid) {
		this.projectSummaryPanel=projectSummaryPanel;
		this.projectGrid=projectGrid;
	}
	public void addButtonClicked(SelectEvent event) {
		new AddProjectWindow(this).show();
		
	}
	
	
	public void loadProjectsFromDB(final boolean test){
		final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Loading data. Please wait...");
		final AsyncCallback<ProjectListResponse> callback = new AsyncCallback<ProjectListResponse>() {
	  
			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert = new AlertMessageBox("Error",
						caught.getMessage());
				alert.show();
			}

			public void onSuccess(ProjectListResponse result) {
				messageBox.hide();
				 allProjects = result.getProjects();

				if(!test)
					populateProjectSummaryGrid();
			}

		};
			
		ProjectRpcHelper.projectService.getAllProjects(new ProjectListRequest(), callback);
		messageBox.auto();
		messageBox.show();
	}
	
	private void populateProjectSummaryGrid() {
		if ((allProjects != null) && (!allProjects.isEmpty())) {
			// Now populate GXT Grid
			projectGrid.populateData(allProjects);
		} else {
			// Remove all items
			projectGrid.clear();
		}
		
	}
	
	public void saveButtonClicked(AddProjectWindow sourceWindow) {
		if(!sourceWindow.getFormPanel().isValid(false))
	    {
	    	new Alert("Save", "Please correct highlighted errors before you can save!");
	    	return;
	    }
	    
		sourceWindow.getWindow().hide();
		
	}
	public void cancelButtonClicked(AddProjectWindow sourceWindow) {
			sourceWindow.getWindow().hide();
		
	}

}
