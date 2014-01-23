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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.project.ProjectProperties;
import com.media2359.euphoria.view.client.project.ProjectRpcHelper;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridSelectionModel;

public class MyProjectsPanel implements IsWidget, AsyncCallback<ProjectListResponse> {
	
	private static final ProjectProperties props = GWT
			.create(ProjectProperties.class);

	private ColumnModel<ProjectDTO> cm;
	private ListStore<ProjectDTO> store;

	Grid<ProjectDTO> grid;

	private ProjectReceiver receiver;
	
	@Override
	public Widget asWidget() {
		store = new ListStore<ProjectDTO>(props.key());
		/**
		 * Trigger request to server
		 */
		ProjectRpcHelper.getAllProjects(this);
		
		ColumnConfig<ProjectDTO, String> col = new ColumnConfig<ProjectDTO, String>(props.name(), 150, "My Projects");
		List<ColumnConfig<ProjectDTO, ?>> l = new ArrayList<ColumnConfig<ProjectDTO, ?>>();
		l.add(col);

		cm = new ColumnModel<ProjectDTO>(l);
		
		grid = new Grid<ProjectDTO>(store, cm);
		grid.setWidth("100%");

		grid.getView().setAutoExpandColumn(col);
		grid.getView().setStripeRows(true);
		
		GridSelectionModel<ProjectDTO> sm = new GridSelectionModel<ProjectDTO>();
		sm.addSelectionHandler(new SelectionHandler<ProjectDTO>() {

			@Override
			public void onSelection(SelectionEvent<ProjectDTO> event) {
				ProjectDTO selectedProject = event.getSelectedItem();
				receiver.selectedProject(selectedProject);
			}			
		});
		grid.setSelectionModel(sm);
		return grid;
	}
	
	public void populateData(List<ProjectDTO> projects) {
		store.replaceAll(projects);
	}
	
	public void clear() {
		store.clear();
	}

	@Override
	public void onFailure(Throwable caught) {
		// TODO Nothing as of now
	}

	@Override
	public void onSuccess(ProjectListResponse response) {
		if ((response != null) && (response.getProjects() != null)) {
			store.addAll(response.getProjects());
		}		
	}

	public void setReceiver(ProjectReceiver receiver) {
		this.receiver = receiver;
	}
}
