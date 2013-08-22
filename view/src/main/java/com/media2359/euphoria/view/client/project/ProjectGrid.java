/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.project;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.user.client.ui.Composite;
import com.media2359.euphoria.view.message.project.Project;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.info.Info;

public class ProjectGrid extends Composite {
	private GridView<Project> gridView;
	private Grid<Project> grid;
	private ListStore<Project> listStore;

	// Property access definitions for the values in the Project object
	public interface GridProperties extends PropertyAccess<Project> {

		ModelKeyProvider<Project> key();
		
		ValueProvider<Project, String> name();

		ValueProvider<Project, Integer> manDaysLeft();
		
		ValueProvider<Project, Integer> milestoneCount();
		
		ValueProvider<Project, Integer> completedMilestoneCount();
		
		ValueProvider<Project, String> detailsImage();
	}

	// Setup the property access definitions for the values for the grid columns
	public static GridProperties gridProperties = GWT
			.create(GridProperties.class);

	public ProjectGrid() {
		listStore = new ListStore<Project>(gridProperties.key());

		ColumnConfig<Project, String> nameCol = new ColumnConfig<Project, String>(
				gridProperties.name(), 150, "Name");
		ColumnConfig<Project, Integer> manDaysCol = new ColumnConfig<Project, Integer>(
				gridProperties.manDaysLeft(), 150, "ManDays Left");
		ColumnConfig<Project, Integer> mileStoneCol = new ColumnConfig<Project, Integer>(
				gridProperties.milestoneCount(), 150, "Total No Of Milestones");
		ColumnConfig<Project, Integer> mileStoneCompCol = new ColumnConfig<Project, Integer>(
				gridProperties.completedMilestoneCount(), 150, "Completed Milestones");
		ColumnConfig<Project, String> arrowImageCol = new ColumnConfig<Project, String>(
				gridProperties.detailsImage(), 40, "View Project");
		
		arrowImageCol.setColumnTextClassName(CommonStyles.get().inlineBlock());
		arrowImageCol.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 1px 3px;"));
		ViewProjectCell image = new ViewProjectCell();

		image.addSelectHandler(new SelectHandler() {
			
			public void onSelect(SelectEvent event) {
		        Context c = event.getContext();
		        int row = c.getIndex();
		        Project p = listStore.get(row);
		        Info.display("Event", "The " + p.getName() + " was clicked.");
				
			}
		});
		arrowImageCol.setCell(image);
		
		
		List<ColumnConfig<Project, ?>> columns = new ArrayList<ColumnConfig<Project, ?>>();
		columns.add(nameCol);
		columns.add(manDaysCol);
		columns.add(mileStoneCol);
		columns.add(mileStoneCompCol);
		columns.add(arrowImageCol);
		ColumnModel<Project> columnModel = new ColumnModel<Project>(columns);
		
		gridView = new GridView<Project>();
		gridView.setAutoFill(true);

		grid = new Grid<Project>(listStore, columnModel, gridView);
		initWidget(grid);
	}

	public void populateData(List<Project> projects) {
		listStore.replaceAll(projects);
	}
	
	public void clear() {
		listStore.clear();
	}
}
