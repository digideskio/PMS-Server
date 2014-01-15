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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.client.core.*;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;
import com.media2359.euphoria.view.server.employee.EmployeeServiceAsync;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
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


/**
 * NewEmployeeDetailsCreator
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public class NewEmployeeDetailsCreator implements EmployeeDetailsCreator{

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createNameField()
	 */
	@Override
	public Component createName() {
		  return createTextField("Enter Full Name", 30, 1,null);		
	}


	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createPersonalEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createPersonalEmail() {
		  return createTextField("Enter Personal Email", 30, 1,new EmailValidator());	
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createCompanyEmail(com.sencha.gxt.widget.core.client.form.TextField)
	 */
	@Override
	public Component createCompanyEmail() {
		  return createTextField("Enter Company Email", 30, 1,new EmailValidator());
	}
	

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createManDayRate()
	 */
	@Override
	public Component createManDayRate() {
		return createTextField("Enter Manday Rate", 30, 1,null);	
	}


	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createStartDate()
	 */
	@Override
	public Component createStartDate() {
		  DateField field = new DateField();
		  field.setEmptyText("Select Start Date");
		  field.setAllowBlank(false);
		  return field;
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createEndDate()
	 */
	@Override
	public Component createEndDate() {
		  DateField field = new DateField();
		  field.setEmptyText("Select End Date");
		  return field;
	}



	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#createMobileField(com.sencha.gxt.widget.core.client.form.NumberField)
	 */
	@Override
	public Component createMobile() {
		  NumberField field= new NumberField<Long>(new LongPropertyEditor());
		  field.setAllowBlank(false);
		  field.setEmptyText("Enter Mobile Number");
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
	  combo.setEmptyText("Select Designation");
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
		  combo.setEmptyText("Select Employment Type");
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
	  combo.setEmptyText("Select Assigned Office");
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
	  combo.setEmptyText("Select Status");
	  combo.setForceSelection(true);
	  combo.setTriggerAction(TriggerAction.ALL);
	  combo.add(JobStatus.getAllStatus());
	  return combo;
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

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.employee.EmployeeDetailsCreator#getWindowHeader()
	 */
	@Override
	public String getWindowHeader() {
		return " Add New Employee";
	}

	private TextField createTextField(String emptyText,int maxLength,int minLength, AbstractValidator additionalValidator){
		  TextField field = new TextField();
		  field.setAllowBlank(false);
		  field.setEmptyText(emptyText);
		  field.addValidator(new MaxLengthValidator(maxLength));
		  field.addValidator(new MinLengthValidator(minLength));
		  if(additionalValidator != null)
			  field.addValidator(additionalValidator);
		  return field;
	}
}
