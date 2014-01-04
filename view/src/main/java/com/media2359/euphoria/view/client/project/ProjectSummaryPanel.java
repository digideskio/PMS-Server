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

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.message.project.ProjectListRequest;
import com.media2359.euphoria.view.message.project.ProjectListResponse;
import com.media2359.euphoria.view.server.project.ProjectService;
import com.media2359.euphoria.view.server.project.ProjectServiceAsync;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class ProjectSummaryPanel extends Composite {
	interface ProjectSummaryUiBinder extends
			UiBinder<VerticalLayoutContainer, ProjectSummaryPanel> {
	}

	ProjectSummaryUiBinder uiBinder = GWT.create(ProjectSummaryUiBinder.class);

//	private ProjectServiceAsync projectService = GWT
//			.create(ProjectService.class);

	@UiField
	ProjectGrid projectGrid;
	private Logger log = Logger.getLogger("EuphoriaLogger");

	/**
	 * This is the entry point method.
	 */
	public ProjectSummaryPanel() {
		initWidget(uiBinder.createAndBindUi(this));

		/**
		 * Fetch the data when this panel is shown
		 */
		loadData();
	}

	private void loadData() {
		final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Loading data. Please wait...");

		final AsyncCallback<ProjectListResponse> callback = new AsyncCallback<ProjectListResponse>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert = new AlertMessageBox("Error",
						caught.getMessage());
				alert.show();
			}

			public void onSuccess(ProjectListResponse result) {
				messageBox.hide();
				List<ProjectDTO> projects = result.getProjects();

				if ((projects != null) && (!projects.isEmpty())) {
					// Now populate GXT Grid
					projectGrid.populateData(projects);
				} else {
					// Remove all items
					projectGrid.clear();
				}
			}
		};
		log.info("Getting all projects in ProjectSummaryPanel");
//		projectService.getAllProjects(new ProjectListRequest(), callback);
		//messageBox.auto();
		//messageBox.show();

	}
}
