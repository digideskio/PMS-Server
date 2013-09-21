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

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeServiceAsync;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;

/**
 * EmployeePresenter
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

  public class EmployeePresenter {
  private EmployeeGrid employeeGrid;
  private EmployeeServiceAsync employeeService;
  private Logger log = Logger.getLogger("EuphoriaLogger");
  private List<EmployeeDTO> employees;
  
  
  public EmployeePresenter(){
	  
  }
  
  public EmployeePresenter(EmployeeGrid employeeGrid, EmployeeServiceAsync employeeService){
	  this.employeeGrid = employeeGrid;
	  this.employeeService = employeeService;
	  
  }
  
  
  public void loadData() {
	  

	  	employees = null;
	  	
		loadDataFromDB(false);


	}
  
  private void loadDataFromDB(final boolean test){
	  
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
				employees = result.getEmployees();

				if(!test)
					populateEmployeeGrid();
			}

		};
		log.info("Getting all Employees to EmployeeSummaryPanel");
		employeeService.getAllEmployees(new EmployeeListRequest(), callback);
		messageBox.auto();
		messageBox.show();
  }
  protected void addButtonClicked(SelectEvent event){
	    Info.display("Click", ((TextButton) event.getSource()).getText() + " clicked");
	    
	    new EmployeeDetailsWindow(EmployeeDetailsWindow.ADD,null).show();
  }
  
  
  protected void viewEmployeeDetailsButtonClicked(SelectEvent event, ListStore<EmployeeDTO> listStore){
	  
      Context c = event.getContext();
      int row = c.getIndex();
      EmployeeDTO p = listStore.get(row);

	  new EmployeeDetailsWindow(EmployeeDetailsWindow.VIEW,p).show();
	  
  }
  
  
  protected void editEmployeeDetailsButtonClicked(SelectEvent event, ListStore<EmployeeDTO> listStore){
	  
      Context c = event.getContext();
      int row = c.getIndex();
      EmployeeDTO p = listStore.get(row);
      log.info("The employee " + p.getName() + " was clicked to Edit.");
	  new EmployeeDetailsWindow(EmployeeDetailsWindow.EDIT,p).show();
  }
  
  private void populateEmployeeGrid(){

		if ((employees != null) && (!employees.isEmpty())) {
			employeeGrid.populateData(employees);
		} else {
			employeeGrid.clear();
		}
		
  }
}
