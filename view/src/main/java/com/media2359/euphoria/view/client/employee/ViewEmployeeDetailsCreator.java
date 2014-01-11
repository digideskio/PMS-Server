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

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;



import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.media2359.euphoria.view.client.core.*;

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
	Logger log = Logger.getLogger("EuphoriaLogger");
	private static final int NAME=0,MOBILE=1,P_EMAIL=2,C_EMIAL=3,DESIGNATION=4,PLATFORMS=5,EMPLOYMENT=6,MANDAY=7,OFFICE=8,S_DATE=9,E_DATE=10,STATUS=11;
	public ViewEmployeeDetailsCreator(EmployeeDTO employeeDTO){
		this.employeeDTO = employeeDTO;
	}
	
	
	
	@Override
	public Component createName() {
		  return createLabel(getDTOValue(NAME));
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createMobileField(com.sencha.gxt.widget.core.client.form.NumberField)
	 */
	@Override
	public Component createMobile() {
			  return createLabel(getDTOValue(MOBILE));		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPersonalEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createPersonalEmail() {
		  return createLabel(getDTOValue(P_EMAIL));		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createCompanyEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createCompanyEmail() {
		  return createLabel(getDTOValue(C_EMIAL));
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createDesignationCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createDesignation() {		
		  return createLabel(getDTOValue(DESIGNATION));		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEmploymentCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createEmployment() {
		  return createLabel(getDTOValue(EMPLOYMENT));	
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createManDayRate()
	 */
	@Override
	public Component createManDayRate() {
		return createLabel(getDTOValue(MANDAY));		
	}



	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createAssignedOffice()
	 */
	@Override
	public Component createAssignedOffice() {
		return createLabel(getDTOValue(OFFICE));		
	}



	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createStartDate()
	 */
	@Override
	public Component createStartDate() {
		return createLabel(getDTOValue(S_DATE));		
	}



	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEndDate()
	 */
	@Override
	public Component createEndDate() {
		return createLabel(getDTOValue(E_DATE));		
	}



	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createStatus()
	 */
	@Override
	public Component createStatus() {
		return createLabel(getDTOValue(STATUS));		
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPlatforms(com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox)
	 */
	@Override
	public CheckBox[] createPlatforms() {
		
		String platforms= (String) getDTOValue(PLATFORMS);
		  
		  
		  List<Platforms> allPlatforms =Platforms.getAllPlatforms();
		   
		   if(allPlatforms == null)
			   return null;
		   
		   CheckBox[] returnCheckBoxes = new CheckBox[allPlatforms.size()];
		   
		  for(int i=0; i<returnCheckBoxes.length; i++){
			  
			  returnCheckBoxes[i] = new CheckBox();
			  returnCheckBoxes[i].setBoxLabel(allPlatforms.get(i).toString());
			  returnCheckBoxes[i].setValue(platforms!=null&&platforms.contains(allPlatforms.get(i).toString()));
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
		return  "Employee Details";
	}
	
	private FieldLabel createLabel(Object value){
		FieldLabel label = new FieldLabel();
	    if(value!=null && !value.getClass().toString().contains("null"))
	    {
	    		label.setHTML("<b><span style=\"color:#2F4F4F\">"+value.toString()+"</b>");
	    }
	    else
	    	label.setText("");
	    	
		 label.setBorders(false);
		 label.setLabelSeparator("");
		 label.setLabelAlign(LabelAlign.TOP);
		 return label;
	}

	private Object getDTOValue(int valueID){

		if(employeeDTO == null)
			return "";

		switch(valueID){
			case NAME:return (employeeDTO.getName()!=null?employeeDTO.getName():"");
			case MOBILE:return (employeeDTO.getMobile()!=null?employeeDTO.getMobile():"");
			case P_EMAIL:return (employeeDTO.getPersonalEmail()!=null?employeeDTO.getPersonalEmail():"");
			case C_EMIAL:return (employeeDTO.getCompanyEmail()!=null?employeeDTO.getCompanyEmail():"");
			case DESIGNATION:return (employeeDTO.getDesignation()!=null?employeeDTO.getDesignation():"");
			//case PLATFORMS:return (employeeDTO.getPlatForms()!=null?employeeDTO.getPlatForms():"");
			case PLATFORMS:return (employeeDTO.getPlatFormDtos()!=null?employeeDTO.getPlatFormDtos():"");
			case EMPLOYMENT:return (employeeDTO.getEmploymentType()!=null?employeeDTO.getEmploymentType():"");
			case MANDAY:return (employeeDTO.getMandayRate()!=null?employeeDTO.getMandayRate():"");
			case OFFICE:return (employeeDTO.getAssignedOffice()!=null?employeeDTO.getAssignedOffice():"");
			case S_DATE:return employeeDTO.getStartDate();
			case E_DATE:return employeeDTO.getEndDate();
			case STATUS:return (employeeDTO.getStatus()!=null?employeeDTO.getStatus():"");
			default: return "";
		}
	}

}
