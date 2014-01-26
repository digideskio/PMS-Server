/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.approval;

import java.util.Date;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.common.NotificationBox;
import com.media2359.euphoria.view.client.common.Resources;
import com.media2359.euphoria.view.client.manpower.common.MyProjectsPanel;
import com.media2359.euphoria.view.client.manpower.common.ProjectReceiver;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.sencha.gxt.cell.core.client.ButtonCell.IconAlign;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.widget.core.client.Header;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ManpowerApprovePanel  implements IsWidget, ProjectReceiver {
	interface ManpowerUiBinder extends UiBinder<VerticalLayoutContainer, ManpowerApprovePanel> {
	}

	private static ManpowerUiBinder uiBinder = GWT
			.create(ManpowerUiBinder.class);
	@UiField
	MyProjectsPanel selector;
	@UiField
	ManpowerApproveAllocationPanel allocator;
	
	@UiField
	TextField weekStarting;
	
	@UiField
	Header header;
	
	VerticalLayoutContainer vp;
	
	@UiField
	TextButton approveAllocation;
	
	@UiField
	TextButton rejectAllocation;
	
	private Logger log = Logger.getLogger("EuphoriaLogger");
	
	 // A custom date format
    DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
    
    private Date currentWeekStartDate = null;
    
    private static final String HEADER_TEMPLATE = "Allocate resource for the week starting ";

	@Override
	public Widget asWidget() {
		if(vp == null) {
			vp = uiBinder.createAndBindUi(this);
			selector.setReceiver(this);
		}
		DateWrapper wrapper = new DateWrapper();
		wrapper = wrapper.addDays(-1 * (wrapper.getDayInWeek()-1));
		currentWeekStartDate = wrapper.asDate();
		
		String dateStr = fmt.format(currentWeekStartDate);
		weekStarting.setText(dateStr);
		weekStarting.setSize("80", "50");
		
		Resources resources = GWT.create(Resources.class);
		approveAllocation.setIcon(resources.approve());
		approveAllocation.setIconAlign(IconAlign.LEFT);
		rejectAllocation.setIcon(resources.reject());
		rejectAllocation.setIconAlign(IconAlign.LEFT);
		
		header.setText(HEADER_TEMPLATE + dateStr);
		return vp;
	}
	
	@UiHandler("nextWeek")
	public void nextWeek(SelectEvent event) {
		DateWrapper wrapper = new DateWrapper(currentWeekStartDate);
		wrapper = wrapper.addDays(7);//Next week start
		currentWeekStartDate = wrapper.asDate();
		log.info("New date is"+currentWeekStartDate);
		String dateStr = fmt.format(currentWeekStartDate);
		weekStarting.setText(dateStr);
		header.setText(HEADER_TEMPLATE + dateStr);
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
	
	@UiHandler("approveAllocation")
	public void approveAllocation(SelectEvent event) {
		allocator.getAllocationData();
		NotificationBox.success("Success", "The allocation was saved successfully.");
	}
	
	@UiHandler("rejectAllocation")
	public void rejectAllocation(SelectEvent event) {
		allocator.getAllocationData();
		NotificationBox.success("Success", "The allocation was saved successfully.");
	}

	@Override
	public void selectedProject(ProjectDTO project) {
		allocator.setProject(project, currentWeekStartDate);
	}
}
