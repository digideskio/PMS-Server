/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.employee;

/**
 * EmployeePanel
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **
 **/

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.media2359.euphoria.view.message.employee.Employee;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;
import com.media2359.euphoria.view.server.employee.EmployeeServiceAsync;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;

public class EmployeePanel extends Composite {
	interface EmployeePanelUiBinder extends
			UiBinder<VerticalLayoutContainer, EmployeePanel> {
	}
	
	EmployeePanelUiBinder uiBinder = GWT.create(EmployeePanelUiBinder.class);

	private EmployeeServiceAsync employeeService = GWT
			.create(EmployeeService.class);
	
	@UiField
	EmployeeGrid employeeGrid;
	private Logger log = Logger.getLogger("EuphoriaLogger");

	/**
	 * This is the entry point method.
	 */
	public EmployeePanel() {
		initWidget(uiBinder.createAndBindUi(this));

		/**
		 * Fetch the data when this panel is shown
		 */
		loadData();
	}
	
	@UiHandler({"addButton"})
	  public void onButtonClick(SelectEvent event) {
	    Info.display("Click", ((TextButton) event.getSource()).getText() + " clicked");
	    new NewEmployeeWindow().show();
	 
	  }

	private void loadData() {
		final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Loading data. Please wait...");

		final AsyncCallback<EmployeeListResponse> callback = new AsyncCallback<EmployeeListResponse>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert = new AlertMessageBox("Error",
						caught.getMessage());
				alert.show();
			}

			public void onSuccess(EmployeeListResponse result) {
				messageBox.hide();
				List<Employee> employees = result.getEmployees();

				if ((employees != null) && (!employees.isEmpty())) {
					// Now populate GXT Grid
					employeeGrid.populateData(employees);
				} else {
					// Remove all items
					employeeGrid.clear();
				}
			}

		};
		log.info("Getting all Employees to EmployeeSummaryPanel");
		employeeService.getAllEmployees(new EmployeeListRequest(), callback);
		messageBox.auto();
		messageBox.show();
		

	}
}
