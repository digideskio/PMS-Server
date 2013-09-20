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

import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;
import com.sencha.gxt.widget.core.client.form.TextField;


/**
 * NewEmployeeDetailsCreator
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public class ViewEmployeeDetailsCreator implements EmployeeDetailsCreator{
	
	private EmployeeDTO employeeDTO;
	public ViewEmployeeDetailsCreator(EmployeeDTO employeeDTO){
		this.employeeDTO = employeeDTO;
	}
	@Override
	public Component createNameField() {
		TextField nameField = new TextField();
		  if(employeeDTO !=null)
			  nameField.setValue(employeeDTO.getName());
		  nameField.setAllowTextSelection(false);
		  nameField.setBorders(false);
		  nameField.setReadOnly(true);
		  
		  return nameField;
		  

		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createMobileField(com.sencha.gxt.widget.core.client.form.NumberField)
	 */
	@Override
	public Component createMobileField() {
		TextField mobileField= new TextField();
		  if(employeeDTO !=null)
			  mobileField.setValue(employeeDTO.getMobile());
		  mobileField.setAllowTextSelection(false);
		  mobileField.setBorders(false);
		  mobileField.setReadOnly(true);
		  return mobileField;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPersonalEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createPersonalEmail() {
		TextField personalEmail = new TextField();
		  if(employeeDTO !=null)
			  personalEmail.setValue(employeeDTO.getPersonalEmail());
		  personalEmail.setAllowTextSelection(false);
		  personalEmail.setBorders(false);
		  personalEmail.setReadOnly(true);
		  return personalEmail;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createCompanyEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createCompanyEmail() {
		TextField companyEmail = new TextField();
		  if(employeeDTO !=null)
			  companyEmail.setValue(employeeDTO.getCompanyEmail());
		  companyEmail.setAllowTextSelection(false);
		  companyEmail.setBorders(false);
		  companyEmail.setReadOnly(true);
		  return companyEmail;
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createDesignationCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createDesignationCombo() {
		
		TextField designationLabel = new TextField();
		  if(employeeDTO !=null)
			  designationLabel.setValue(employeeDTO.getDesignation());
		  designationLabel.setAllowTextSelection(false);
		  designationLabel.setBorders(false);
		  designationLabel.setReadOnly(true);
		  return designationLabel;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEmploymentCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createEmploymentCombo() {
		
		TextField employmentLabel = new TextField();
		  if(employeeDTO !=null)
			  employmentLabel.setValue(employeeDTO.getDesignation());
		  employmentLabel.setAllowTextSelection(false);
		  employmentLabel.setBorders(false);
		  employmentLabel.setReadOnly(true);
		  return employmentLabel;
	
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPlatforms(com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox)
	 */
	@Override
	public CheckBox[] createPlatforms() {
		
		String platforms=null;
		  if(employeeDTO !=null)
			  platforms = employeeDTO.getPlatForms();

		  CheckBox railsCheck = new CheckBox();
		  railsCheck.setBoxLabel("Rails");
		  railsCheck.setValue(platforms!=null&&platforms.contains("Rails"));
		  railsCheck.setReadOnly(true);
		  
		  CheckBox htmlCheck = new CheckBox();
		  htmlCheck.setBoxLabel("HTML");
		  htmlCheck.setValue(platforms!=null&&platforms.contains("HTML"));
		  htmlCheck.setReadOnly(true);
		  
		  CheckBox iOSCheck = new CheckBox();
		  iOSCheck.setBoxLabel("iOS");
		  iOSCheck.setValue(platforms!=null&&platforms.contains("iOS"));
		  iOSCheck.setReadOnly(true);
		  
		  CheckBox androidCheck = new CheckBox();
		  androidCheck.setBoxLabel("Android");
		  androidCheck.setValue(platforms!=null&&platforms.contains("Android"));
		  androidCheck.setReadOnly(true);
		  
		  return new CheckBox[]{railsCheck,htmlCheck,iOSCheck,androidCheck};
	}
	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createAndAddButtons(com.sencha.gxt.widget.core.client.button.TextButton, com.sencha.gxt.widget.core.client.button.TextButton, com.sencha.gxt.widget.core.client.FramedPanel)
	 */
	@Override
	public TextButton[] createAndAddButtons() {
		
		  TextButton editButton = new TextButton(EmployeeDetailsWindow.EDIT_BUTTON_TEXT);
		  TextButton closeButton = new TextButton(EmployeeDetailsWindow.CLOSE_BUTTON_TEXT);
		  return new TextButton[]{editButton,closeButton};
		
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#getWindowHeader()
	 */
	@Override
	public String getWindowHeader() {
		// TODO Auto-generated method stub
		return  "Employee Details";
	}

}
