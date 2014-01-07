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
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.CellSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.HeaderGroupConfig;
import com.sencha.gxt.widget.core.client.selection.CellSelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.CellSelectionChangedEvent.CellSelectionChangedHandler;

/**
 * View class for allocating Weekly Manpower requests
 * 
 * @author AJ
 * @version 1.0
 * 
 */
public class ManpowerAllocationProjectPanel implements IsWidget {
	private ProjectDTO project;
	private Date weekStartDate;
	Grid<WeeklyResourcePlan> grid;
	// A custom date format
	DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
	ListStore<WeeklyResourcePlan> store = null;

	/**
	 * Main method to create this widget. Called by the GWT Framework
	 */
	public Widget asWidget() {
		ArrayList<ColumnConfig<WeeklyResourcePlan, ?>> configs = new ArrayList<ColumnConfig<WeeklyResourcePlan, ?>>();

		ColumnModel<WeeklyResourcePlan> cm = new ColumnModel<WeeklyResourcePlan>(
				configs);

		WeeklyResourcePlanProperties props = GWT
				.create(WeeklyResourcePlanProperties.class);
		ColumnConfig<WeeklyResourcePlan, Boolean> amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day1Am(), 100, "AM");
		ColumnConfig<WeeklyResourcePlan, Boolean> pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day1Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);

		cm.addHeaderGroup(0, 0, new HeaderGroupConfig(" Monday ", 1, 2));

		amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day2Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day2Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 2, new HeaderGroupConfig(" Tuesday ", 1, 2));

		amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day3Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day3Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 4, new HeaderGroupConfig("Wednesday", 1, 2));

		amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day4Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day4Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 6, new HeaderGroupConfig("Thursday", 1, 2));

		amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day5Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(
				props.day5Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 8, new HeaderGroupConfig(" Friday ", 1, 2));

		store = new ListStore<WeeklyResourcePlan>(props.key());

		grid = new Grid<WeeklyResourcePlan>(store, cm);
		grid.setBorders(true);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);

		CellSelectionModel<WeeklyResourcePlan> c = new CellSelectionModel<WeeklyResourcePlan>();
		c.addCellSelectionChangedHandler(new CellSelectionChangedHandler<WeeklyResourcePlan>() {

			@Override
			public void onCellSelectionChanged(
					CellSelectionChangedEvent<WeeklyResourcePlan> event) {
				//
			}
		});

		grid.setSelectionModel(c);
		return grid;
	}

	private WeeklyResourcePlanResponse getDummyWeeklyResourcePlan() {
		WeeklyResourcePlanResponse response = new WeeklyResourcePlanResponse();
		response.setWeekStartDate(new Date());

		ArrayList<WeeklyResourcePlan> weeklyResourcePlanList = new ArrayList<WeeklyResourcePlan>();

		WeeklyResourcePlan resourcePlan = new WeeklyResourcePlan();
		resourcePlan.setId("1");
		resourcePlan.setDay1Am(true);
		resourcePlan.setDay3Am(true);
		resourcePlan.setDay5Pm(true);
		weeklyResourcePlanList.add(resourcePlan);

		response.setWeeklyResourcePlanList(weeklyResourcePlanList);

		return response;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;

		// TODO: Add logic to fetch allocation data from server
		WeeklyResourcePlanResponse response = getDummyWeeklyResourcePlan();
		grid.getStore().replaceAll(response.getWeeklyResourcePlanList());
	}

	public void setWeekStartDate(Date startDate) {
		this.weekStartDate = startDate; /*
										 * DateWrapper wrapper = new
										 * DateWrapper(startDate);
										 * ColumnModel<WeeklyResourcePlan> cm =
										 * grid.getColumnModel();
										 * List<HeaderGroupConfig> headerGroups
										 * = cm.getHeaderGroups(); for
										 * (HeaderGroupConfig config :
										 * headerGroups) {
										 * config.setHtml(SafeHtmlUtils
										 * .fromString
										 * (fmt.format(wrapper.asDate())));
										 * wrapper = wrapper.addDays(1); }
										 * 
										 * // Set the focus on the widget after
										 * setup completes.
										 * Scheduler.get().scheduleDeferred(new
										 * Command() { public void execute() {
										 * grid.getView().refresh(true);//Update
										 * the grid headers } });
										 */
	}

	public void reload() {
		// grid.getView().refresh(true);//Update the grid headers
	}

	public void resetAllocation() {
		// Allocation is being requested to be reset
	}

	/**
	 * 
	 * TODO This needs to be implemented by Praveen Jose. This will be called
	 * during 'Review Allocation' and 'Approve Allocation'
	 * 
	 * @returns void
	 */
	public void setAllocationData(ProjectAllocationDTO allocationData) {

	}

	/**
	 * 
	 * TODO This needs to be implemented by Praveen Jose. This will be called
	 * during 'Request Allocation' and 'Approve Allocation'
	 * 
	 * @returns ProjectAllocationDTO
	 */
	public ProjectAllocationDTO getAllocationData() {
		return new ProjectAllocationDTO();
	}
}
