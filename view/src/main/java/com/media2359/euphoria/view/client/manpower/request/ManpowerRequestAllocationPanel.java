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

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

/**
 * View class for allocating Weekly Manpower requests
 * 
 * @author AJ
 * @version 1.0
 * 
 */
public class ManpowerRequestAllocationPanel implements IsWidget {
	VerticalLayoutContainer projectListContainer = null; 
	ArrayList<Project> activeProjects = new ArrayList<Project>();
	final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
														"Progress", "Loading. Please wait...");
			
	/**
	 * Main method to create this widget. Called by the GWT Framework
	 */
	public Widget asWidget() {
		projectListContainer = new VerticalLayoutContainer();
		return projectListContainer;
	}
	
	public void addProject(Project project) {
		if(!activeProjects.contains(project)) {
			messageBox.auto();
			messageBox.show();//Show progress bar
			
			ManpowerAllocationProjectPanel projectPanel = new ManpowerAllocationProjectPanel();
			projectPanel.setProject(project);
			projectListContainer.add(projectPanel);
			
			messageBox.hide();//Hide progress bar
		}
	}
	
	public void removeProject(Project project) {
		if(activeProjects.contains(project)) {
			activeProjects.remove(project);
		}
	}
}
