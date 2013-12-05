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
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.AggregationRowConfig;
import com.sencha.gxt.widget.core.client.grid.AggregationSafeHtmlRenderer;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.HeaderGroupConfig;
import com.sencha.gxt.widget.core.client.info.Info;

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
	@Override
	public Widget asWidget() {
	    WeeklyResourceLeaveRequestProperties props = GWT.create(WeeklyResourceLeaveRequestProperties.class);
	    List<ColumnConfig<WeeklyResourceLeaveRequest, ?>> configs = new ArrayList<ColumnConfig<WeeklyResourceLeaveRequest, ?>>();
	 
	    ColumnModel<WeeklyResourceLeaveRequest> cm = new ColumnModel<WeeklyResourceLeaveRequest>(configs);
	    
	    for(int i=0; i < 10; i = i + 2) {

		    ColumnConfig<WeeklyResourceLeaveRequest, Boolean> amColumn = new ColumnConfig<WeeklyResourceLeaveRequest, Boolean>(props.mondayMorning(), 100, "AM");
		    configs.add(amColumn);
		 
		    ColumnConfig<WeeklyResourceLeaveRequest, Boolean> pmColumn = new ColumnConfig<WeeklyResourceLeaveRequest, Boolean>(props.mondayAfternoon(), 100, "PM");
		    configs.add(pmColumn);
		    
		    cm.addHeaderGroup(0, i, new HeaderGroupConfig("16/09/2013", 1, 2));
		    
		    AggregationRowConfig<WeeklyResourceLeaveRequest> dayConfig = new AggregationRowConfig<WeeklyResourceLeaveRequest>();
		    dayConfig.setRenderer(amColumn, new AggregationSafeHtmlRenderer<WeeklyResourceLeaveRequest>("Average"));
		    dayConfig.setRenderer(pmColumn, new AggregationSafeHtmlRenderer<WeeklyResourceLeaveRequest>("Average"));
		    
		    cm.addAggregationRow(dayConfig);
	    
	    }
	    

	    final ListStore<WeeklyResourceLeaveRequest> store = new ListStore<WeeklyResourceLeaveRequest>(props.key());
	    store.addAll(getWeeklyResourceLeaveRequests());
	 
	    FramedPanel cp = new FramedPanel();
	    cp.setCollapsible(true);
	    cp.setAnimCollapse(false);
	    cp.setHeadingText("Project Allocation");
	    cp.setPixelSize(600, 350);
	    cp.addStyleName("margin-10");
	 
	    Grid<WeeklyResourceLeaveRequest> grid = new Grid<WeeklyResourceLeaveRequest>(store, cm);
	    grid.setBorders(true);
	    cp.add(grid);
	    
	    return cp;
	}

	private ArrayList<WeeklyResourceLeaveRequest> getWeeklyResourceLeaveRequests() {
		ArrayList<WeeklyResourceLeaveRequest> leaveList = new ArrayList<WeeklyResourceLeaveRequest>();
		
		WeeklyResourceLeaveRequest leave = new WeeklyResourceLeaveRequest();
		leave.setId("1");
		leaveList.add(leave);
		
		return leaveList;
	}
}
