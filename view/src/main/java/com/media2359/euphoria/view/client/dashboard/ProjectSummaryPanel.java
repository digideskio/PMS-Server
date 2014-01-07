package com.media2359.euphoria.view.client.dashboard;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class ProjectSummaryPanel implements IsWidget {

	// Property access definitions for the values in the Project object
	public interface GridProperties extends PropertyAccess<ProjectDTO> {
		@Path("id")
		ModelKeyProvider<ProjectDTO> key();

		ValueProvider<ProjectDTO, String> name();

		ValueProvider<ProjectDTO, Integer> manDaysLeft();

		ValueProvider<ProjectDTO, Integer> milestoneCount();

		ValueProvider<ProjectDTO, Integer> completedMilestoneCount();

	}

	private static final GridProperties gridProperties = GWT
			.create(GridProperties.class);

	private ColumnModel<ProjectDTO> cm;
	private ListStore<ProjectDTO> store;
	Grid<ProjectDTO> grid;

	@Override
	public Widget asWidget() {
		store = new ListStore<ProjectDTO>(gridProperties.key());

		ColumnConfig<ProjectDTO, String> nameCol = new ColumnConfig<ProjectDTO, String>(
				gridProperties.name(), 150, "Name");
		ColumnConfig<ProjectDTO, Integer> manDaysCol = new ColumnConfig<ProjectDTO, Integer>(
				gridProperties.manDaysLeft(), 150,
				"Actual Cost/Project Estimate");
		ColumnConfig<ProjectDTO, Integer> mileStoneCol = new ColumnConfig<ProjectDTO, Integer>(
				gridProperties.milestoneCount(), 150, "Total No Of Milestones");
		ColumnConfig<ProjectDTO, Integer> mileStoneCompCol = new ColumnConfig<ProjectDTO, Integer>(
				gridProperties.completedMilestoneCount(), 150,
				"Completed Milestones");
		ColumnConfig<ProjectDTO, String> controlsCol = new ColumnConfig<ProjectDTO, String>(
				gridProperties.name(), 90, "Controls");

		List<ColumnConfig<ProjectDTO, ?>> columns = new ArrayList<ColumnConfig<ProjectDTO, ?>>();
		columns.add(nameCol);
		columns.add(manDaysCol);
		columns.add(mileStoneCol);
		columns.add(mileStoneCompCol);
		columns.add(controlsCol);
		cm = new ColumnModel<ProjectDTO>(columns);

		grid = new Grid<ProjectDTO>(store, cm);
		grid.setWidth("100%");
		grid.getView().setStripeRows(true);

		ArrayList<ProjectDTO> projects = getDummyProjects();
		if (projects != null) {
			store.addAll(projects);
		}
		return grid;
	}

	public ArrayList<ProjectDTO> getDummyProjects() {
		ArrayList<ProjectDTO> projects = new ArrayList<ProjectDTO>();

		ProjectDTO dto = new ProjectDTO();
		dto.setName("Euphoria");
		dto.setManDaysLeft(300);
		dto.setMilestoneCount(10);
		dto.setCompletedMilestoneCount(5);
		projects.add(dto);

		dto = new ProjectDTO();
		dto.setName("SGMallsd");
		dto.setManDaysLeft(50);
		dto.setMilestoneCount(23);
		dto.setCompletedMilestoneCount(1);
		projects.add(dto);

		dto = new ProjectDTO();
		dto.setName("Billing App");
		dto.setManDaysLeft(10);
		dto.setMilestoneCount(12);
		dto.setCompletedMilestoneCount(0);
		projects.add(dto);

		dto = new ProjectDTO();
		dto.setName("Phoenix Radio");
		dto.setManDaysLeft(100);
		dto.setMilestoneCount(25);
		dto.setCompletedMilestoneCount(10);
		projects.add(dto);

		return projects;
	}
}
