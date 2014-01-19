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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;
import com.media2359.euphoria.view.server.employee.EmployeeServiceAsync;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.CellClickEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
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
  private Logger log = Logger.getLogger("EuphoriaLogger");
  private static List<EmployeeDTO> employees;
  private final EmployeeServiceAsync employeeService = GWT.create(EmployeeService.class);
  
  public EmployeePresenter(EmployeeGrid employeeGrid){
	  this.employeeGrid = employeeGrid;
	  
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
			
		employeeService.getAllEmployees(new EmployeeListRequest(), callback);
		messageBox.auto();
		messageBox.show();
  }
  protected void addButtonClicked(SelectEvent event){
	    Info.display("Click", ((TextButton) event.getSource()).getText() + " clicked");
	    
	    new EmployeeDetailsWindow(EmployeeDetailsWindow.ADD,null,this).show();
  }
  
  
  protected void editEmployeeDetailsButtonClicked(SelectEvent event, ListStore<EmployeeDTO> listStore){
	  
      Context c = event.getContext();
      int row = c.getIndex();
      EmployeeDTO p = listStore.get(row);
	  new EmployeeDetailsWindow(EmployeeDetailsWindow.EDIT,p,this).show();
  }
  
  protected void deleteEmployeeDetailsButtonClicked(SelectEvent event, ListStore<EmployeeDTO> listStore){
	  
      Context c = event.getContext();
      int row = c.getIndex();
      final EmployeeDTO p = listStore.get(row);
      
      final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Deleting data. Please wait...");
		
		
	  final ConfirmMessageBox mb = new ConfirmMessageBox("Confirmation Required", "Please Confirm you wish to delete record of '"+p.getName()+"' !");
	    mb.addHideHandler(new HideHandler() {
	      public void onHide(HideEvent event) {
	        if (mb.getHideButton() == mb.getButtonById(PredefinedButton.YES.name())) {
	        	
	        	final AsyncCallback<String> callback = new AsyncCallback<String>() {
	        		  
	    			public void onFailure(Throwable caught) {
	    				messageBox.hide();
	    				AlertMessageBox alert = new AlertMessageBox("Error",
	    						caught.getMessage());
	    				alert.show();
	    			}

	    			public void onSuccess(String result) {
	    				messageBox.hide();
	    				loadData();		
	    			}

	    		};
	        	
	        	employeeService.deleteEmployee(p, callback);
	        	messageBox.auto();
	    		messageBox.show();
	        }
	      }
	    });
//	    mb.setWidth(40);
	    mb.show();
	    		
  }
  
  private void populateEmployeeGrid(){

		if ((employees != null) && (!employees.isEmpty())) {
			employeeGrid.populateData(employees);
		} else {
			employeeGrid.clear();
		}
		
  }
  
  public EmployeeServiceAsync getEmployeeService(){
	  return employeeService;
  }
  
  protected void gridCellClicked(CellClickEvent event, ListStore<EmployeeDTO> listStore){
	  
     if(event.getCellIndex()>4)
    	 return;
     EmployeeDTO p = listStore.get(event.getRowIndex());
	 new EmployeeDetailsWindow(EmployeeDetailsWindow.VIEW,p, this).show();
  }
  
  
  public static List<EmployeeDTO> getEmployees(){
	  return employees;
  }
  
}
