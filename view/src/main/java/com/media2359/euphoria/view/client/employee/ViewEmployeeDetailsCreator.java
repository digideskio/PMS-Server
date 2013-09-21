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
import com.sencha.gxt.widget.core.client.form.Field;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;


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
		  return createLabel(employeeDTO.getName());
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createMobileField(com.sencha.gxt.widget.core.client.form.NumberField)
	 */
	@Override
	public Component createMobileField() {
			  return createLabel(employeeDTO.getMobile());		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPersonalEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createPersonalEmail() {
		  return createLabel(employeeDTO.getPersonalEmail());		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createCompanyEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createCompanyEmail() {
		  return createLabel(employeeDTO.getCompanyEmail());
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createDesignationCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createDesignationCombo() {		
		  return createLabel(employeeDTO.getDesignation());		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEmploymentCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createEmploymentCombo() {
		  return createLabel(employeeDTO.getEmploymentType());	
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPlatforms(com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox)
	 */
	@Override
	public CheckBox[] createPlatforms() {
		
		String platforms=null;
		  if(employeeDTO !=null)
			  platforms = employeeDTO.getPlatForms();
		  
		  
		   String[] allPlatforms =new Platforms().getPlatforms();
		   
		   if(allPlatforms == null)
			   return null;
		   
		   CheckBox[] returnCheckBoxes = new CheckBox[allPlatforms.length];
		   
		  for(int i=0; i<returnCheckBoxes.length; i++){
			  
			  returnCheckBoxes[i] = new CheckBox();
			  returnCheckBoxes[i].setBoxLabel(allPlatforms[i]);
			  returnCheckBoxes[i].setValue(platforms!=null&&platforms.contains(allPlatforms[i]));
			  returnCheckBoxes[i].setReadOnly(true);
			  
		  }
		  
		  return returnCheckBoxes;
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
	
	private FieldLabel createLabel(String value){
		FieldLabel label = new FieldLabel();
		  if(employeeDTO !=null)
			  label.setText(value);

		  label.setBorders(false);
		  label.setLabelSeparator("");		
		  label.setLabelAlign(LabelAlign.TOP);
		  return label;
	}
	 
}
