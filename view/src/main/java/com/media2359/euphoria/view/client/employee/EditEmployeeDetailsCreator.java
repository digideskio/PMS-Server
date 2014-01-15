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

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.media2359.euphoria.view.client.core.EmailValidator;
import com.media2359.euphoria.view.client.core.Platforms;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.LongPropertyEditor;
import com.sencha.gxt.widget.core.client.form.validator.AbstractValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxLengthValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxNumberValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;
import com.media2359.euphoria.view.client.core.*;
/**
 * NewEmployeeDetailsCreator
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public class EditEmployeeDetailsCreator implements EmployeeDetailsCreator{

	private EmployeeDTO employeeDTO;
	private static final int NAME=0,MOBILE=1,P_EMAIL=2,C_EMIAL=3,DESIGNATION=4,PLATFORMS=5,EMPLOYMENT=6,MANDAY=7,OFFICE=8,S_DATE=9,E_DATE=10,STATUS=11;
	
	Logger log = Logger.getLogger("EuphoriaLogger");
	 
	
	public EditEmployeeDetailsCreator(EmployeeDTO employeeDTO){
		this.employeeDTO = employeeDTO;
	}
	
	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createNameField()
	 */
	@Override
	public Component createName() {
		  return createTextField(NAME, 30, 1,null);		
	}


	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPersonalEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createPersonalEmail() {
		  return createTextField(P_EMAIL, 30, 1,new EmailValidator());	
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createCompanyEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createCompanyEmail() {
		  return createTextField(C_EMIAL, 30, 1,new EmailValidator());
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createManDayRate()
	 */
	@Override
	public Component createManDayRate() {
		return createTextField(MANDAY, 30, 1,null);	
	}


	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createStartDate()
	 */
	@Override
	public Component createStartDate() {
		  DateField field = new DateField();
		  field.setAllowBlank(false);
		  if(getDTOValue(S_DATE) == null)
			  return field;
		  if(!(getDTOValue(S_DATE) == null && ((String)getDTOValue(S_DATE)).isEmpty()))
			  field.setOriginalValue((Date) getDTOValue(S_DATE));
		  return field;
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEndDate()
	 */
	@Override
	public Component createEndDate() {
		  DateField field = new DateField();
		  if(getDTOValue(E_DATE) == null)
			  return field;
		  if(getDTOValue(E_DATE) != null && !getDTOValue(E_DATE).toString().contains("null")){
			  field.setOriginalValue((Date) getDTOValue(E_DATE));
			  field.setValue((Date) getDTOValue(E_DATE));
		  }
		  return field;
	}


	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createMobileField(com.sencha.gxt.widget.core.client.form.NumberField)
	 */
	@Override
	public Component createMobile() {
		  NumberField field= new NumberField<Long>(new LongPropertyEditor());
		  field.setAllowBlank(false);
		  field.setText((String) getDTOValue(MOBILE));
		  field.addValidator(new MaxNumberValidator<Long>((long)99999999));
		  return field;
		
	}
	
	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createDesignationCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createDesignation() {
		SimpleComboBox combo = new SimpleComboBox<Designations>(
				new StringLabelProvider<Designations>());
	  combo.setPropertyEditor(new PropertyEditor<Designations>() {

			@Override
			public Designations parse(CharSequence text) throws ParseException {
				return Designations.parseString(text.toString());
			}

			@Override
			public String render(Designations object) {
				return object == null ? Designations.DESIGNATION1.toString() : object
						.toString();
			}
		});
	  combo.setAllowBlank(false);
	  combo.setText((String) getDTOValue(DESIGNATION));
	  combo.setForceSelection(true);
	  combo.setTriggerAction(TriggerAction.ALL);
	  combo.add(Designations.getDesignations());
      return combo;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEmploymentCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createEmployment() {
		SimpleComboBox combo = new SimpleComboBox<EmploymentType>(
					new StringLabelProvider<EmploymentType>());
		  combo.setPropertyEditor(new PropertyEditor<EmploymentType>() {

				@Override
				public EmploymentType parse(CharSequence text) throws ParseException {
					return EmploymentType.parseString(text.toString());
				}

				@Override
				public String render(EmploymentType object) {
					return object == null ? EmploymentType.EMPL1.toString() : object
							.toString();
				}
			});
		  combo.setAllowBlank(false);
		  combo.setText((String) getDTOValue(EMPLOYMENT));
		  combo.setForceSelection(true);
		  combo.setTriggerAction(TriggerAction.ALL);
		  combo.add(EmploymentType.getEmploymentTypes());
		  return combo;
		
	}
	
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createAssignedOffice()
	 */
	@Override
	public Component createAssignedOffice() {
		SimpleComboBox combo = new SimpleComboBox<AssignedOffices>(
				new StringLabelProvider<AssignedOffices>());
	  combo.setPropertyEditor(new PropertyEditor<AssignedOffices>() {

			@Override
			public AssignedOffices parse(CharSequence text) throws ParseException {
				return AssignedOffices.parseString(text.toString());
			}

			@Override
			public String render(AssignedOffices object) {
				return object == null ? AssignedOffices.OFFICE1.toString() : object
						.toString();
			}
		});
	  combo.setAllowBlank(false);
	  combo.setText((String) getDTOValue(OFFICE));
	  combo.setForceSelection(true);
	  combo.setTriggerAction(TriggerAction.ALL);
	  combo.add(AssignedOffices.getOffices());
	  return combo;
	}

	
	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createStatus()
	 */
	@Override
	public Component createStatus() {
		SimpleComboBox combo = new SimpleComboBox<JobStatus>(
				new StringLabelProvider<JobStatus>());
	  combo.setPropertyEditor(new PropertyEditor<JobStatus>() {

			@Override
			public JobStatus parse(CharSequence text) throws ParseException {
				return JobStatus.parseString(text.toString());
			}

			@Override
			public String render(JobStatus object) {
				return object == null ? JobStatus.STATUS1.toString() : object
						.toString();
			}
		});
	  combo.setAllowBlank(false);
	  combo.setText((String) getDTOValue(STATUS));
	  combo.setForceSelection(true);
	  combo.setTriggerAction(TriggerAction.ALL);
	  combo.add(JobStatus.getAllStatus());
	  return combo;
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPlatforms(com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox)
	 */
	@Override
	public CheckBox[] createPlatforms() {
		
		String platforms=null;
		  platforms = (String) getDTOValue(PLATFORMS);
		  
		  
		  List<Platforms> allPlatforms =Platforms.getAllPlatforms();
		   
		   if(allPlatforms == null)
			   return null;
		   
		   CheckBox[] returnCheckBoxes = new CheckBox[allPlatforms.size()];
		   
		  for(int i=0; i<returnCheckBoxes.length; i++){
			  
			  returnCheckBoxes[i] = new CheckBox();
			  returnCheckBoxes[i].setBoxLabel(allPlatforms.get(i).toString());
			  returnCheckBoxes[i].setValue(platforms!=null&&platforms.contains(allPlatforms.get(i).toString()));
			  
		  }
		  
		  return returnCheckBoxes;
		
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createAndAddButtons(com.sencha.gxt.widget.core.client.button.TextButton, com.sencha.gxt.widget.core.client.button.TextButton, com.sencha.gxt.widget.core.client.FramedPanel)
	 */
	@Override
	public TextButton[] createAndAddButtons() {

		  TextButton submitButton = new TextButton(EmployeeDetailsWindow.SUBMIT_BUTTON_TEXT);
		  TextButton createAccountButton = new TextButton(EmployeeDetailsWindow.CREATE_ACC_BUTTON_TEXT);
		  TextButton cancelButton = new TextButton(EmployeeDetailsWindow.CANCEL_BUTTON_TEXT);
		  return new TextButton[]{submitButton,createAccountButton,cancelButton};
		
	}
	
	public String getWindowHeader() {
		return  "Edit Employee Details";
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

	private TextField createTextField(int valueID,int maxLength,int minLength, AbstractValidator additionalValidator){
		  TextField field = new TextField();
		  field.setAllowBlank(false);
		  field.setText((String) getDTOValue(valueID));
		  field.addValidator(new MaxLengthValidator(maxLength));
		  field.addValidator(new MinLengthValidator(minLength));
		  if(additionalValidator != null)
			  field.addValidator(additionalValidator);
		  return field;
	}
}
