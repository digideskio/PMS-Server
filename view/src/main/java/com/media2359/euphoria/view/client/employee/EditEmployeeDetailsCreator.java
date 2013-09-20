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

import com.media2359.euphoria.view.client.core.EmailValidator;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.LongPropertyEditor;
import com.sencha.gxt.widget.core.client.form.validator.MaxLengthValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxNumberValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;

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
	public EditEmployeeDetailsCreator(EmployeeDTO employeeDTO){
		this.employeeDTO = employeeDTO;
	}
	
	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createNameField()
	 */
	@Override
	public Component createNameField() {
		  TextField nameField = new TextField();
		  nameField.setAllowBlank(false);
		  if(employeeDTO !=null)
			  nameField.setText(employeeDTO.getName());
		  nameField.addValidator(new MaxLengthValidator(30));
		  nameField.addValidator(new MinLengthValidator(1));
		  return nameField;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createMobileField(com.sencha.gxt.widget.core.client.form.NumberField)
	 */
	@Override
	public Component createMobileField() {
		  NumberField mobileField= new NumberField<Long>(new LongPropertyEditor());
		  mobileField.setAllowBlank(false);
		  if(employeeDTO !=null)
			  mobileField.setText(employeeDTO.getMobile());
		  mobileField.addValidator(new MaxNumberValidator<Long>((long)99999999));
		  return mobileField;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPersonalEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createPersonalEmail() {
		  TextField personalEmail = new TextField();
		  personalEmail.setAllowBlank(false);
		  if(employeeDTO !=null)
			  personalEmail.setText(employeeDTO.getPersonalEmail());
		  personalEmail.addValidator(new MaxLengthValidator(30));
		  personalEmail.addValidator(new EmailValidator());
		  return personalEmail;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createCompanyEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createCompanyEmail() {
		  TextField companyEmail = new TextField();
		  companyEmail.setAllowBlank(false);
		  if(employeeDTO !=null)
			  companyEmail.setText(employeeDTO.getCompanyEmail());
		  companyEmail.addValidator(new MaxLengthValidator(30));
		  companyEmail.addValidator(new EmailValidator());
		  return companyEmail;
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createDesignationCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createDesignationCombo() {
		SimpleComboBox designationCombo = new SimpleComboBox<Designation>(
				new StringLabelProvider<Designation>());
	  designationCombo.setPropertyEditor(new PropertyEditor<Designation>() {

			@Override
			public Designation parse(CharSequence text) throws ParseException {
				return Designation.parseString(text.toString());
			}

			@Override
			public String render(Designation object) {
				return object == null ? Designation.DESIGNATION1.toString() : object
						.toString();
			}
		});
	  designationCombo.setAllowBlank(false);
	  if(employeeDTO !=null)
		  designationCombo.setText(employeeDTO.getDesignation());
	  designationCombo.setForceSelection(true);
	  designationCombo.setTriggerAction(TriggerAction.ALL);
      designationCombo.add(Designation.DESIGNATION1);
      designationCombo.add(Designation.DESIGNATION2);
      designationCombo.add(Designation.DESIGNATION3);
      return designationCombo;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEmploymentCombo(com.sencha.gxt.widget.core.client.form.SimpleComboBox)
	 */
	@Override
	public Component createEmploymentCombo() {
		SimpleComboBox employmentCombo = new SimpleComboBox<EmploymentType>(
					new StringLabelProvider<EmploymentType>());
		  employmentCombo.setPropertyEditor(new PropertyEditor<EmploymentType>() {

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
		  employmentCombo.setAllowBlank(false);
		  if(employeeDTO !=null)
			  employmentCombo.setText(employeeDTO.getEmploymentType());
		  employmentCombo.setForceSelection(true);
		  employmentCombo.setTriggerAction(TriggerAction.ALL);
		  employmentCombo.add(EmploymentType.EMPL1);
		  employmentCombo.add(EmploymentType.EMPL2);
		  employmentCombo.add(EmploymentType.EMPL3);
		  return employmentCombo;
		
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPlatforms(com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox, com.sencha.gxt.widget.core.client.form.CheckBox)
	 */
	@Override
	public CheckBox[] createPlatforms() {
		
		String platforms = "";
		  if(employeeDTO !=null)
			  platforms = employeeDTO.getPlatForms();
		  
		  CheckBox railsCheck = new CheckBox();
		  railsCheck.setBoxLabel("Rails");
		  railsCheck.setValue(platforms!=null&&platforms.contains("Rails"));
		  
		  CheckBox htmlCheck = new CheckBox();
		  htmlCheck.setBoxLabel("HTML");
		  railsCheck.setValue(platforms!=null&&platforms.contains("HTML"));
		  
		  CheckBox iOSCheck = new CheckBox();
		  iOSCheck.setBoxLabel("iOS");
		  railsCheck.setValue(platforms!=null&&platforms.contains("iOS"));
		  
		  CheckBox androidCheck = new CheckBox();
		  androidCheck.setBoxLabel("Android");
		  railsCheck.setValue(platforms!=null&&platforms.contains("Android"));
		  
		  return new CheckBox[]{railsCheck,htmlCheck,iOSCheck,androidCheck};
		
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
		// TODO Auto-generated method stub
		return  "Edit Employee Details";
	}

}
