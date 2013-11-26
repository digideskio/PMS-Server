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

import java.util.logging.Logger;

import com.media2359.euphoria.view.client.core.Alert;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.widget.core.client.Window;
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
	public static final int ADD=0,VIEW=1,EDIT=2;
		
	protected void submitButtonClicked(EmployeeDetailsWindow sourceWindow){
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
		    	saveEmployee(createEmployeeDTO(sourceWindow));
	    	}else{
	    		new Alert("Save", "Please select atleast one platform before you can save!");
	    	}
	    }else{
	    	new Alert("Save", "Please correct highlighted errors before you can save!");
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
		new EmployeeDetailsWindow(EmployeeDetailsWindow.EDIT,sourceWindow.getEmployeeDTO()).show();
		
	}
	
	private void saveEmployee(EmployeeDTO employeeDTO){
		Info.display("Save", "Employee saved!");
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
		
		StringBuffer platform = new StringBuffer();
		for(CheckBox checkBox : sourceWindow.getPlatformChecks())
		{
			if(checkBox.getValue())
				platform.append(checkBox.getBoxLabel()).append(",");
		}
		
		if(platform.length()>0)
			platform.deleteCharAt(platform.length());
		
		employeeDTO.setPlatForms(platform.toString());
		log.info(employeeDTO.toString());
		return employeeDTO;
	}


	
}
