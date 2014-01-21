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

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.client.core.Alert;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;
import com.media2359.euphoria.view.server.employee.EmployeeServiceAsync;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.info.Info;
/**
 * EmployeeDetailsPresenter
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/




public class EmployeeDetailsPresenter {

	Logger log = Logger.getLogger("EuphoriaLogger");
	private int createType;
	private EmployeePresenter empPresenter;
		
	public EmployeeDetailsPresenter(int createType, EmployeePresenter empPresenter) {
		this.createType=createType;
		this.empPresenter = empPresenter;
	}

	protected void submitButtonClicked(EmployeeDetailsWindow sourceWindow){
	    if(createType==EmployeeDetailsWindow.ADD && !sourceWindow.getFormPanel().isValid(false))
	    {
	    	new Alert("Save", "Please correct highlighted errors before you can save!");
	    	return;
	    }
    	
	    boolean atleastOnePlatformSelected = false;
    	for(int i=0; i<=sourceWindow.getPlatformChecks().length; i++){
    		if(!sourceWindow.getPlatformChecks()[i].getValue())
    			continue;
    		atleastOnePlatformSelected = true;
    		break;
    	}
    	if(atleastOnePlatformSelected){		    	
	    	saveEmployee(createEmployeeDTO(sourceWindow),sourceWindow);
    	}else{
    		new Alert("Save", "Please select atleast one platform before you can save!");
    	}
	    
	}

	protected void cancelButtonClicked(EmployeeDetailsWindow sourceWindow){
		sourceWindow.getWindow().hide();
	}
	
	
	protected void closeButtonClicked(EmployeeDetailsWindow sourceWindow){
		sourceWindow.getWindow().hide();
	}
	
	protected void createAccountButtonClicked(EmployeeDetailsWindow sourceWindow) {
	    if(sourceWindow.getFormPanel().isValid(false)){
	    	boolean atleastOnePlatformSelected = false;
	    	for(int i=0; i<=sourceWindow.getPlatformChecks().length; i++){
	    		if(!sourceWindow.getPlatformChecks()[i].getValue())
	    			continue;
	    		atleastOnePlatformSelected = true;
	    		break;
	    	}
	    	if(atleastOnePlatformSelected){
	    		sourceWindow.getWindow().hide();		    	
	    		createAccount(createEmployeeDTO(sourceWindow));
	    	}else{
	    		new Alert("Save", "Please select atleast one platform before you can save!");
	    	}
	    }else{
	    	new Alert("Save", "Please correct highlighted errors before you can save!");
	    }
		
	}
	
	protected void editButtonClicked(EmployeeDetailsWindow sourceWindow) {
		sourceWindow.getWindow().hide();
		new EmployeeDetailsWindow(EmployeeDetailsWindow.EDIT,sourceWindow.getEmployeeDTO(),empPresenter).show();
		
	}
	
	private void saveEmployee(EmployeeDTO employeeDTO, final EmployeeDetailsWindow sourceWindow){
		
		final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Saving Employee. Please wait...");
		final AsyncCallback<String> callback = new AsyncCallback<String>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				sourceWindow.getWindow().hide();
				AlertMessageBox alert = new AlertMessageBox("Error",
						caught.getMessage());
				alert.show();
			}

			public void onSuccess(String result) {
				log.info("#!#!#!#!#!#! Saving Employee Successful#!#!#!#!");
				messageBox.hide();	
				sourceWindow.getWindow().hide();
				empPresenter.loadData();
			}

		};
		
		
		log.info("#!#!#!#!Saving Employee: "+employeeDTO.toString());
		if(createType == EmployeeDetailsWindow.ADD)
			empPresenter.getEmployeeService().addEmployee(employeeDTO, callback);
		else if(createType == EmployeeDetailsWindow.EDIT)
			empPresenter.getEmployeeService().modifyEmployee(employeeDTO, callback);
		messageBox.auto();
	}

	private void createAccount(EmployeeDTO employeeDTO){
		Info.display("Create Account", "Create Account Done!");
	}
	
	private EmployeeDTO createEmployeeDTO(EmployeeDetailsWindow sourceWindow){
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName(((TextField)sourceWindow.getName()).getText());
		employeeDTO.setMobile(((NumberField)sourceWindow.getMobile()).getText());
		employeeDTO.setPersonalEmail(((TextField)sourceWindow.getPersonalEmail()).getText());
		employeeDTO.setCompanyEmail(((TextField)sourceWindow.getCompanyEmail()).getText());
		employeeDTO.setDesignation(((SimpleComboBox)sourceWindow.getDesignation()).getText());
		employeeDTO.setEmploymentType(((SimpleComboBox)sourceWindow.getEmployment()).getText());
		employeeDTO.setMandayRate(((TextField)sourceWindow.getMandayRate()).getText());
		employeeDTO.setAssignedOffice(((SimpleComboBox)sourceWindow.getAssignedOffice()).getText());
		employeeDTO.setStartDate(((DateField)sourceWindow.getStartDate()).getValue());
		employeeDTO.setEndDate(((DateField)sourceWindow.getEndDate()).getValue());
		employeeDTO.setStatus(((SimpleComboBox)sourceWindow.getStatus()).getText());
		employeeDTO.setCreatedById("whatIsThis?");
		/*StringBuffer platform = new StringBuffer();*/
		Set<PlatformDTO> platFormDtos = new HashSet(0);
		for(CheckBox checkBox : sourceWindow.getPlatformChecks())
		{
			if(checkBox.getValue()){
				
				String platFormID = checkBox.getBoxLabel();
				
				for(PlatformDTO platformDTO  : sourceWindow.getAllPlatformDTOs()){
					if(platformDTO.getPlatformId().equals(platFormID))
						platFormDtos.add(platformDTO);
				}
			}	
			
		}
	
		employeeDTO.setPlatFormDtos(platFormDtos);
//		log.info(employeeDTO.toString());
		return employeeDTO;
	}


	
}
