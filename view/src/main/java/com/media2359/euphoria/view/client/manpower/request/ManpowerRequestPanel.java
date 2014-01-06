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

import java.util.Date;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.manpower.common.MyProjectsPanel;
import com.media2359.euphoria.view.client.manpower.common.ProjectDTO;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

public class ManpowerRequestPanel  implements IsWidget {
	interface ManpowerUiBinder extends UiBinder<VerticalLayoutContainer, ManpowerRequestPanel> {
	}

	private static ManpowerUiBinder uiBinder = GWT
			.create(ManpowerUiBinder.class);
	@UiField
	MyProjectsPanel selector;
	@UiField
	ManpowerRequestAllocationPanel allocator;
	
	@UiField
	TextField weekStarting;
	
	VerticalLayoutContainer vp;
	
	private Logger log = Logger.getLogger("EuphoriaLogger");
	
	 // A custom date format
    DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
    
    private Date currentWeekStartDate = null;

	@Override
	public Widget asWidget() {
		if(vp == null) {
			vp = uiBinder.createAndBindUi(this);
			selector.setParent(this);
		}
		DateWrapper wrapper = new DateWrapper();
		wrapper = wrapper.addDays(-1 * (wrapper.getDayInWeek()-1));
		currentWeekStartDate = wrapper.asDate();
		
		weekStarting.setText(fmt.format(currentWeekStartDate));
		weekStarting.setSize("80", "50");
		return vp;
	}

	public void setProject(ProjectDTO project) {
		allocator.setProject(project, currentWeekStartDate);
	}
	
	@UiHandler("nextWeek")
	public void nextWeek(SelectEvent event) {
		DateWrapper wrapper = new DateWrapper(currentWeekStartDate);
		wrapper = wrapper.addDays(7);//Next week start
		currentWeekStartDate = wrapper.asDate();
		log.info("New date is"+currentWeekStartDate);
		
		weekStarting.setText(fmt.format(currentWeekStartDate));
		
		allocator.setWeekStartDate(currentWeekStartDate);
	}
	
	@UiHandler("previousWeek")
	public void previousWeek(SelectEvent event) {
		DateWrapper wrapper = new DateWrapper(currentWeekStartDate);
		wrapper = wrapper.addDays(-7);//Previous week start
		currentWeekStartDate = wrapper.asDate();
		log.info("New date is"+currentWeekStartDate);
		
		weekStarting.setText(fmt.format(currentWeekStartDate));
		
		allocator.setWeekStartDate(currentWeekStartDate);
	}
	
	@UiHandler("saveAllocation")
	public void saveAllocation(SelectEvent event) {
		Info.display("Info", "The allocation was saved successfully.");
	}
}
