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
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.user.client.ui.Composite;
import com.media2359.euphoria.view.client.core.ViewCell;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
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
import com.sencha.gxt.widget.core.client.grid.filters.GridFilters;
import com.sencha.gxt.widget.core.client.grid.filters.StringFilter;
import com.sencha.gxt.widget.core.client.info.Info;

public class ProjectGrid extends Composite {
	private GridView<ProjectDTO> gridView;
	private Grid<ProjectDTO> grid;
	private ListStore<ProjectDTO> listStore;

	// Property access definitions for the values in the Project object
	public interface GridProperties extends PropertyAccess<ProjectDTO> {
		@Path("id")
		ModelKeyProvider<ProjectDTO> key();		
		ValueProvider<ProjectDTO, String> name();
		ValueProvider<ProjectDTO, Double> manDaysLeft();		
		ValueProvider<ProjectDTO, Integer> milestoneCount();		
		ValueProvider<ProjectDTO, Integer> completedMilestoneCount();
		
	}

	// Setup the property access definitions for the values for the grid columns
	public static GridProperties gridProperties = GWT
			.create(GridProperties.class);

	public ProjectGrid() {
		listStore = new ListStore<ProjectDTO>(gridProperties.key());

		ColumnConfig<ProjectDTO, String> nameCol = new ColumnConfig<ProjectDTO, String>(
				gridProperties.name(), 150, "Name");
		ColumnConfig<ProjectDTO, Double> manDaysCol = new ColumnConfig<ProjectDTO, Double>(
				gridProperties.manDaysLeft(), 150, "ManDays Left");
		ColumnConfig<ProjectDTO, Integer> mileStoneCol = new ColumnConfig<ProjectDTO, Integer>(
				gridProperties.milestoneCount(), 150, "Total No Of Milestones");
		ColumnConfig<ProjectDTO, Integer> mileStoneCompCol = new ColumnConfig<ProjectDTO, Integer>(
				gridProperties.completedMilestoneCount(), 150, "Completed Milestones");
		ColumnConfig viewDetailsCol = new ColumnConfig<ProjectDTO, String>(
				gridProperties.name(), 90, "View Project");

		
		populateViewButton(viewDetailsCol);
		
		List<ColumnConfig<ProjectDTO, ?>> columns = new ArrayList<ColumnConfig<ProjectDTO, ?>>();
		columns.add(nameCol);
		columns.add(manDaysCol);
		columns.add(mileStoneCol);
		columns.add(mileStoneCompCol);
		columns.add(viewDetailsCol);
		ColumnModel<ProjectDTO> columnModel = new ColumnModel<ProjectDTO>(columns);
		
		gridView = new GridView<ProjectDTO>();
		gridView.setAutoFill(true);
		gridView.setStripeRows(true);

		grid = new Grid<ProjectDTO>(listStore, columnModel, gridView);
		//grid.setSize("600", "500");
		initWidget(grid);
	}
	
	private void populateViewButton(ColumnConfig viewDetailsCol){
		viewDetailsCol.setColumnTextClassName(CommonStyles.get().inlineBlock());
		viewDetailsCol.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 1px 3px;"));
		ViewCell image = new ViewCell();

		image.addSelectHandler(new SelectHandler() {
			
			public void onSelect(SelectEvent event) {
		        Context c = event.getContext();
		        int row = c.getIndex();
		        ProjectDTO p = listStore.get(row);
		        Info.display("Event", "The project " + p.getName() + " was clicked.");
				
			}
		});
		viewDetailsCol.setCell(image);
	}
	
	private void addFilters(){
		StringFilter<ProjectDTO> nameFilter = new StringFilter<ProjectDTO>(gridProperties.name());
		GridFilters<ProjectDTO> filters = new GridFilters<ProjectDTO>();
		filters.initPlugin(grid);
		filters.setLocal(true);
		filters.addFilter(nameFilter);
	}

	public void populateData(List<ProjectDTO> projects) {
		listStore.replaceAll(projects);
		addFilters();
	}
	
	public void clear() {
		listStore.clear();
	}
}
