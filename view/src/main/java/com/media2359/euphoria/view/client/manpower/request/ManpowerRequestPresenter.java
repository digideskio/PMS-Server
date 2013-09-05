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

import com.media2359.euphoria.view.dto.manpower.ManpowerRequestDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;

/**
 * ManpowerRequestPresenter
 *
 * Presentation logic for Manpower Request view
 * 
 * @author AJ
 * @version 1.0 2013
 **/

public class ManpowerRequestPresenter {
	ManpowerRequestView view;

	/**
	 * 
	 */
	public ManpowerRequestPresenter(ManpowerRequestView view) {
		this.view = view;
	}
	
	/**
	 * 
	 * When a project is selected in the Left Pane
	 *
	 * @returns void
	 */
	public void onProjectSelected(ProjectDTO project) {
		view.setProjectTitle(project.getName());
	}
	
	public void saveAllocation(ManpowerRequestDTO manpowerRequest) {
		
	}
}
