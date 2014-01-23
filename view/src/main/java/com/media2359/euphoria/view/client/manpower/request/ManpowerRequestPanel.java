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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.common.NotificationBox;
import com.media2359.euphoria.view.client.manpower.common.MyProjectsPanel;
import com.media2359.euphoria.view.client.manpower.common.ProjectReceiver;
import com.media2359.euphoria.view.dto.manpower.ProjectAllocationDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.server.allocation.RequestManpowerService;
import com.media2359.euphoria.view.server.allocation.RequestManpowerServiceAsync;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.widget.core.client.Header;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ManpowerRequestPanel  implements IsWidget, ProjectReceiver,  AsyncCallback<String>  {
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
	
	@UiField
	Header header;
	
	VerticalLayoutContainer vp;
	
	private Logger log = Logger.getLogger("EuphoriaLogger");
	
	 // A custom date format
    DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
    
    private Date currentWeekStartDate = null;
    
    private static final String HEADER_TEMPLATE = "Allocate resource for the week starting ";

    RequestManpowerServiceAsync manpowerService = GWT.create(RequestManpowerService.class);
    
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
	
	@UiHandler("saveAllocation")
	public void saveAllocation(SelectEvent event) {
		ProjectAllocationDTO data = allocator.getAllocationData();
		manpowerService.submitManpowerRequest(data, this);
	}

	@Override
	public void selectedProject(ProjectDTO project) {
		allocator.setProject(project, currentWeekStartDate);
	}

	@Override
	public void onFailure(Throwable caught) {
		GWT.log("Error saving data in to server", caught);
		caught.printStackTrace();
		StackTraceElement[] stackErrors = caught.getStackTrace();
		for(StackTraceElement stackElement:stackErrors)
				log.info(stackElement.toString());	
		NotificationBox.success("Error", caught.getMessage());
	}

	@Override
	public void onSuccess(String result) {
		NotificationBox.success("Success", "The allocation was saved successfully:"+result);
	}
}
