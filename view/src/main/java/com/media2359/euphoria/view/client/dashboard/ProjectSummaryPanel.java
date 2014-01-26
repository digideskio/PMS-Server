package com.media2359.euphoria.view.client.dashboard;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
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

public class ProjectSummaryPanel implements IsWidget, AsyncCallback<ProjectListResponse> {

	private static final ProjectProperties ProjectProperties = GWT
			.create(ProjectProperties.class);

	private ColumnModel<ProjectDTO> cm;
	private ListStore<ProjectDTO> store;
	Grid<ProjectDTO> grid;

	@Override
	public Widget asWidget() {
		store = new ListStore<ProjectDTO>(ProjectProperties.key());
		/**
		 * Now trigger project request
		 */
		ProjectRpcHelper.getAllProjects(this);

		ColumnConfig<ProjectDTO, String> nameCol = new ColumnConfig<ProjectDTO, String>(
				ProjectProperties.name(), 150, "Name");
		ColumnConfig<ProjectDTO, Double> manDaysCol = new ColumnConfig<ProjectDTO, Double>(
				ProjectProperties.manDaysLeft(), 150,
				"Actual Cost/Project Estimate");
		ColumnConfig<ProjectDTO, Integer> mileStoneCol = new ColumnConfig<ProjectDTO, Integer>(
				ProjectProperties.milestoneCount(), 150, "Total No Of Milestones");
		ColumnConfig<ProjectDTO, Integer> mileStoneCompCol = new ColumnConfig<ProjectDTO, Integer>(
				ProjectProperties.completedMilestoneCount(), 150,
				"Completed Milestones");
//		ColumnConfig<ProjectDTO, String> controlsCol = new ColumnConfig<ProjectDTO, String>(
//				ProjectProperties.name(), 90, "Controls");
		
		
		List<ColumnConfig<ProjectDTO, ?>> columns = new ArrayList<ColumnConfig<ProjectDTO, ?>>();
		columns.add(nameCol);
		columns.add(manDaysCol);
		columns.add(mileStoneCol);
		columns.add(mileStoneCompCol);
		//columns.add(controlsCol);
		cm = new ColumnModel<ProjectDTO>(columns);

		grid = new Grid<ProjectDTO>(store, cm);
		grid.setWidth("100%");
		grid.getView().setStripeRows(true);
		
		return grid;
	}

	@Override
	public void onFailure(Throwable caught) {
		//Nothing to do now
	}

	@Override
	public void onSuccess(ProjectListResponse response) {
		if ((response != null) && (response.getProjects() != null)) {
			store.addAll(response.getProjects());
		}
	}
}
