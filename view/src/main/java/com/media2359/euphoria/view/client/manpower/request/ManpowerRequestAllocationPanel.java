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
import java.util.logging.Logger;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.manpower.common.ManpowerAllocationProjectPanel;
import com.media2359.euphoria.view.client.manpower.common.ProjectDTO;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;

/**
 * View class for allocating Weekly Manpower requests
 * 
 * @author AJ
 * @version 1.0
 * 
 */
public class ManpowerRequestAllocationPanel implements IsWidget {
	ManpowerAllocationProjectPanel allocationPanel = null;
	ArrayList<ProjectDTO> activeProjects = new ArrayList<ProjectDTO>();
	final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
														"Progress", "Loading. Please wait...");
	private Logger log = Logger.getLogger("EuphoriaLogger");	
	ContentPanel projectPane = null;
	
	/**
	 * Main method to create this widget. Called by the GWT Framework
	 */
	public Widget asWidget() {
	    projectPane = new ContentPanel();
	    projectPane.addStyleName("margin-10");	
	    
	    allocationPanel = new ManpowerAllocationProjectPanel();
		projectPane.add(allocationPanel);
		return projectPane;
	}
	
	public void setProject(ProjectDTO project, Date weekStartDate) {
		//TODO: First get the existing allocation data
		
		//Now set the new project
		projectPane.setTitle(project.getName());
		allocationPanel.setWeekStartDate(weekStartDate);
		allocationPanel.setProject(project);
		allocationPanel.reload();
	}
	
	public void setWeekStartDate(Date startDate) {
		allocationPanel.setWeekStartDate(startDate);
		allocationPanel.reload();
	}
	
	public void removeProject(ProjectDTO project) {
		if(activeProjects.contains(project)) {
			activeProjects.remove(project);
		}
	}
}
