/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.common;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.manpower.request.ManpowerRequestPanel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridSelectionModel;

public class MyProjectsPanel implements IsWidget {
	
	private static final ProjectProperties props = GWT
			.create(ProjectProperties.class);

	private ColumnModel<ProjectDTO> cm;
	private ListStore<ProjectDTO> store;

	Grid<ProjectDTO> grid;

	private ManpowerRequestPanel parent;
	//private ProjectServiceAsync projectService = GWT.create(ProjectService.class);
	
	@Override
	public Widget asWidget() {
		ColumnConfig<ProjectDTO, String> col = new ColumnConfig<ProjectDTO, String>(props.name(), 150, "My Projects");

		List<ColumnConfig<ProjectDTO, ?>> l = new ArrayList<ColumnConfig<ProjectDTO, ?>>();
		l.add(col);

		cm = new ColumnModel<ProjectDTO>(l);

		store = new ListStore<ProjectDTO>(props.key());
		store.addAll(getMyProjects());

		grid = new Grid<ProjectDTO>(store, cm);
		grid.setWidth("100%");

		grid.getView().setAutoExpandColumn(col);
		grid.getView().setStripeRows(true);
		
		GridSelectionModel<ProjectDTO> sm = new GridSelectionModel<ProjectDTO>();
		sm.addSelectionHandler(new SelectionHandler<ProjectDTO>() {

			@Override
			public void onSelection(SelectionEvent<ProjectDTO> event) {
				ProjectDTO selectedProject = event.getSelectedItem();
				getParent().setProject(selectedProject);
				//getParent().setAllocationPanelTitle(selectedProject.getName());
			}			
		});
		grid.setSelectionModel(sm);
		return grid;
	}
	
	private ArrayList<ProjectDTO> getMyProjects() {
		ArrayList<ProjectDTO> requestList = new ArrayList<ProjectDTO>();
		
		ProjectDTO request;
		
		request = new ProjectDTO();
		request.setName("SGMalls");
		requestList.add(request);

		request = new ProjectDTO();
		request.setName("Euphoria");
		requestList.add(request);

		request = new ProjectDTO();
		request.setName("Phoenix Radio");
		requestList.add(request);

		request = new ProjectDTO();
		request.setName("Delphi");
		requestList.add(request);

		return requestList;
	}
	/**
	private void getAllProjects() {
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
				List<ProjectDTO> projects = result.getProjects();

				if ((projects != null) && (!projects.isEmpty())) {
					// Now populate GXT Grid
					populateData(projects);
				} else {
					// Remove all items
					clear();
				}
			}
		};		
		projectService.getAllProjects(new ProjectListRequest(), callback);
		messageBox.auto();
		messageBox.show();
	}**/
	
	public void populateData(List<ProjectDTO> projects) {
		store.replaceAll(projects);
	}
	
	public void clear() {
		store.clear();
	}
	
	public void setParent(ManpowerRequestPanel parent) {
		this.parent = parent;
	}
	
	private ManpowerRequestPanel getParent() {
		return this.parent;
	}
}
