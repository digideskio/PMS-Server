package com.media2359.euphoria.view.client.project;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.project.ProjectContainer;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectServiceAsync;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EuphoriaProjects implements EntryPoint,IsWidget {
	
	private ProjectServiceAsync projectService = GWT.create(ProjectService.class);		
	private com.media2359.euphoria.view.client.project.ProjectContainer projectContainer;
	
	
	
	private SimpleContainer simpleCon;
	


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
	    Widget con = asWidget();
	    Viewport viewport = new Viewport();
	    viewport.add(con);
	    RootPanel.get().add(viewport);
	    final AutoProgressMessageBox messageBox = new AutoProgressMessageBox("Progress", "Contacting server. Please wait...");
	    messageBox.auto();
		messageBox.show();
		
	    final AsyncCallback<ProjectListResponse> callback = new AsyncCallback<ProjectListResponse>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert  = new AlertMessageBox("Error", caught.getMessage()); 
				alert.show();
			}

			public void onSuccess(ProjectListResponse result) {
				projectContainer.populateMainGrid(result.getProjects());
				messageBox.hide();					
			}
		};
		
	    projectService.getAllProjects(new ProjectListRequest(), callback);

	}

	public Widget asWidget() {
		if(simpleCon==null){
			
			projectContainer = new ProjectContainer();
		    simpleCon = new SimpleContainer();
		    simpleCon.add(projectContainer, new MarginData(30));
		}
		return simpleCon;
	}
}
