package com.media2359.euphoria.view.client.manpower;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridSelectionModel;

public class MyProjectsPanel implements IsWidget {
	
	private static final ProjectProperties props = GWT
			.create(ProjectProperties.class);

	private ColumnModel<Project> cm;
	private ListStore<Project> store;

	Grid<Project> grid;

	private ManpowerRequestPanel parent;

	@Override
	public Widget asWidget() {
		ColumnConfig<Project, String> col = new ColumnConfig<Project, String>(props.name(), 150, "My Project");

		List<ColumnConfig<Project, ?>> l = new ArrayList<ColumnConfig<Project, ?>>();
		l.add(col);

		cm = new ColumnModel<Project>(l);

		store = new ListStore<Project>(props.key());
		store.addAll(getMyProjects());

		grid = new Grid<Project>(store, cm);
		grid.setWidth("100%");

		grid.getView().setAutoExpandColumn(col);
		grid.getView().setStripeRows(true);
		
		GridSelectionModel<Project> sm = new GridSelectionModel<Project>();
		sm.addSelectionHandler(new SelectionHandler<Project>() {

			@Override
			public void onSelection(SelectionEvent<Project> event) {
				Project selectedProject = event.getSelectedItem();
				getParent().setAllocationPanelTitle(selectedProject.getName());
			}			
		});
		grid.setSelectionModel(sm);
		return grid;
	}
	
	private ArrayList<Project> getMyProjects() {
		ArrayList<Project> requestList = new ArrayList<Project>();
		
		Project request;
		
		request = new Project();
		request.setName("SGMalls");
		requestList.add(request);

		request = new Project();
		request.setName("Euphoria");
		requestList.add(request);

		request = new Project();
		request.setName("Phoenix Radio");
		requestList.add(request);

		request = new Project();
		request.setName("Delphi");
		requestList.add(request);

		return requestList;
	}
	
	public void setParent(ManpowerRequestPanel parent) {
		this.parent = parent;
	}
	
	private ManpowerRequestPanel getParent() {
		return this.parent;
	}
}
