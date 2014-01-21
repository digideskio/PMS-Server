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

import java.util.logging.Logger;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectServiceAsync;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class ProjectSummaryPanel extends Composite{
	interface ProjectSummaryUiBinder extends
			UiBinder<VerticalLayoutContainer, ProjectSummaryPanel> {
	}

	ProjectSummaryUiBinder uiBinder = GWT.create(ProjectSummaryUiBinder.class);

	private ProjectServiceAsync projectService = GWT.create(ProjectService.class);

	@UiField
	ProjectGrid projectGrid;
	private Logger log = Logger.getLogger("EuphoriaLogger");
	private ProjectPresenter projectPresenter;

	/**
	 * This is the entry point method.
	 */
	public ProjectSummaryPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		projectPresenter = new ProjectPresenter(this,projectGrid);
		/**
		 * Fetch the data when this panel is shown
		 */
		projectPresenter.loadProjectsFromDB(false);
	}

		
	@UiHandler({"addButton"})
	  public void onButtonClick(SelectEvent event) {

		projectPresenter.addButtonClicked(event);
	  }
}
