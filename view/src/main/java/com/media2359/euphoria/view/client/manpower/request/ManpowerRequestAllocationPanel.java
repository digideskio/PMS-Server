/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.request;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
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
public class ManpowerRequestAllocationPanel implements IsWidget {
	/**
	 * Main method to create this widget. Called by the GWT Framework
	 */
	public Widget asWidget() {
	    ArrayList<ColumnConfig<WeeklyResourcePlan, ?>> configs = new ArrayList<ColumnConfig<WeeklyResourcePlan, ?>>();
	    
	    WeeklyResourcePlanResponse response = getWeeklyResourcePlan();
	 
	    ColumnModel<WeeklyResourcePlan> cm = new ColumnModel<WeeklyResourcePlan>(configs);
	    
	    WeeklyResourcePlanProperties props = GWT.create(WeeklyResourcePlanProperties.class);
	    ColumnConfig<WeeklyResourcePlan, Boolean> amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day1Am(), 100, "AM");
		ColumnConfig<WeeklyResourcePlan, Boolean> pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day1Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 0, new HeaderGroupConfig("16/09/2013", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day2Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day2Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 2, new HeaderGroupConfig("17/09/2013", 1, 2));

	    amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day3Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day3Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 4, new HeaderGroupConfig("18/09/2013", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day4Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day4Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 6, new HeaderGroupConfig("19/09/2013", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day5Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, Boolean>(props.day5Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		cm.addHeaderGroup(0, 8, new HeaderGroupConfig("20/09/2013", 1, 2));
		
		
	    final ListStore<WeeklyResourcePlan> store = new ListStore<WeeklyResourcePlan>(props.key());
	    store.addAll(response.getWeeklyResourcePlanList());
	    //store.addAll(new ArrayList<WeeklyResourcePlan>());
	 
	    Grid<WeeklyResourcePlan> grid = new Grid<WeeklyResourcePlan>(store, cm);
	    grid.setBorders(true);
	    
        CellSelectionModel<WeeklyResourcePlan> c = new CellSelectionModel<WeeklyResourcePlan>();
        c.addCellSelectionChangedHandler(new CellSelectionChangedHandler<WeeklyResourcePlan>() {

          @Override
          public void onCellSelectionChanged(CellSelectionChangedEvent<WeeklyResourcePlan> event) {

          }
        });

        grid.setSelectionModel(c);
	    
	    return grid;
	}

	private WeeklyResourcePlanResponse getWeeklyResourcePlan() {
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
}
