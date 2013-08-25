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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.MaxLengthValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxNumberValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;
import com.sencha.gxt.widget.core.client.info.Info;
import com.media2359.euphoria.view.client.core.Alert;
import com.media2359.euphoria.view.client.core.EmailValidator;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.LongPropertyEditor;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FormPanel;

/**
 * NewEmployeeWindow
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class NewEmployeeWindow {

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	

	  
	  private Window window;
	  
	  private TextField nameField, personalEmail, companyEmail; 
	  private NumberField<Long> mobileField; 
	  private SimpleComboBox<Designation> designationCombo; 
	  private SimpleComboBox<EmploymentType> employmentCombo;
	  private CheckBox railsCheck,iOSCheck,htmlCheck,androidCheck;
	  private TextButton saveButton,cancelButton;
	  private FormPanel formPanel;
	  
	  enum Designation{
		  DESIGNATION1("Developer"), DESIGNATION2("System Analyst"), DESIGNATION3("PM");
			static Designation parseString(String object) {
				if (Designation.DESIGNATION1.toString().equals(object)) {
					return Designation.DESIGNATION1;
				} else if (Designation.DESIGNATION2.toString().equals(object)) {
					return Designation.DESIGNATION2;
				} else if (Designation.DESIGNATION3.toString().equals(object)) {
					return Designation.DESIGNATION3;
				} else {
					return Designation.DESIGNATION1;
				} 
			}
			private String text;

			Designation(String text) {
				this.text = text;
			}

			@Override
			public String toString() {
				return text;
			}
	  };


	  enum EmploymentType{
		  EMPL1("Permenant"), EMPL2("Contract"), EMPL3("Hourly");
			static EmploymentType parseString(String object) {
				if (EmploymentType.EMPL1.toString().equals(object)) {
					return EmploymentType.EMPL1;
				} else if (EmploymentType.EMPL2.toString().equals(object)) {
					return EmploymentType.EMPL2;
				} else if (EmploymentType.EMPL3.toString().equals(object)) {
					return EmploymentType.EMPL3;
				} else{
					return EmploymentType.EMPL1;
				} 
			}
			private String text;

			EmploymentType(String text) {
				this.text = text;
			}

			@Override
			public String toString() {
				return text;
			}
	  };
	  private void createNewWindow(){  
		  
		  nameField = new TextField();
		  nameField.setAllowBlank(false);
		  nameField.setEmptyText("Enter full name...");
		  nameField.addValidator(new MaxLengthValidator(30));
		  nameField.addValidator(new MinLengthValidator(1));
		  
		  mobileField= new NumberField<Long>(new LongPropertyEditor());
		  mobileField.setAllowBlank(false);
		  mobileField.setEmptyText("Enter mobile number...");
		  mobileField.addValidator(new MaxNumberValidator<Long>((long)99999999));
		  
		  personalEmail = new TextField();
		  personalEmail.setAllowBlank(false);
		  personalEmail.setEmptyText("Enter personal email...");
		  personalEmail.addValidator(new MaxLengthValidator(30));
		  personalEmail.addValidator(new EmailValidator());
		  
		  companyEmail = new TextField();
		  companyEmail.setAllowBlank(false);
		  companyEmail.setEmptyText("Enter company email...");
		  companyEmail.addValidator(new MaxLengthValidator(30));
		  companyEmail.addValidator(new EmailValidator());
		  
		  designationCombo = new SimpleComboBox<Designation>(
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
		  designationCombo.setEmptyText("Select Designation");
		  designationCombo.setForceSelection(true);
		  designationCombo.setTriggerAction(TriggerAction.ALL);
	      designationCombo.add(Designation.DESIGNATION1);
	      designationCombo.add(Designation.DESIGNATION2);
	      designationCombo.add(Designation.DESIGNATION3);
	      
		  employmentCombo = new SimpleComboBox<EmploymentType>(
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
		  employmentCombo.setEmptyText("Select Designation");
		  employmentCombo.setForceSelection(true);
		  employmentCombo.setTriggerAction(TriggerAction.ALL);
		  employmentCombo.add(EmploymentType.EMPL1);
		  employmentCombo.add(EmploymentType.EMPL2);
		  employmentCombo.add(EmploymentType.EMPL3);
	      
		  railsCheck = new CheckBox();
		  railsCheck.setBoxLabel("Rails");
		  
		  htmlCheck = new CheckBox();
		  htmlCheck.setBoxLabel("HTML");
		  
		  iOSCheck = new CheckBox();
		  iOSCheck.setBoxLabel("iOS");
		  
		  androidCheck = new CheckBox();
		  androidCheck.setBoxLabel("Android");
		  
		  VerticalPanel platformPanel = new VerticalPanel();
		  platformPanel.add(railsCheck);
		  platformPanel.add(htmlCheck);
		  platformPanel.add(iOSCheck);
		  platformPanel.add(androidCheck);
		  
		  VerticalLayoutContainer p = new VerticalLayoutContainer();
		  p.add(new FieldLabel(nameField, "Full Name"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(mobileField, "Mobile Number"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(personalEmail, "Personal Email"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(companyEmail, "Company Email"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(designationCombo, "Designation"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(platformPanel, "Platform"), new VerticalLayoutData(1, 100));		  
		  p.add(new FieldLabel(employmentCombo, "Employment Type"), new VerticalLayoutData(1, 50));
		  
		  formPanel = new FormPanel();
		  formPanel.add(p);
		  
		  cancelButton = new TextButton("Cancel");
		  cancelButton.addSelectHandler(cancelButtonClicked);
		  
		  saveButton = new TextButton("Save");
		  saveButton.addSelectHandler(saveButtonClicked);
		  
		  FramedPanel fPanel = new FramedPanel();
		  fPanel.setWidth(450);
		  fPanel.setHeaderVisible(false);
		  fPanel.setBodyStyle("background: none; padding: 5px");
		  fPanel.add(formPanel);
		  fPanel.addButton(cancelButton);
		  fPanel.addButton(saveButton);
		  
		  window = new Window();		  
		  window.setPixelSize(500, 540);
		  window.setModal(true);
		  window.setBlinkModal(true);
		  window.setHeadingText(" Add New Employee");
		  window.add(fPanel);
		  window.setFocusWidget(cancelButton);
		}
	  
	  public NewEmployeeWindow(){			  
		  createNewWindow();		  
	  }
	
	  
	  SelectHandler cancelButtonClicked = new SelectHandler() {		  
	      @Override
	      public void onSelect(SelectEvent event) {	    	  
	    	window.hide();
	  	    Info.display("Cancel", "Creation of new employee cancelled!");
	      }
	    };
	    
	    
	  SelectHandler saveButtonClicked = new SelectHandler() {		  
	      @Override
	      public void onSelect(SelectEvent event) {
		    if(formPanel.isValid(false)){
		    	if(railsCheck.getValue() || htmlCheck.getValue() || iOSCheck.getValue() || androidCheck.getValue()){
			    	window.hide();
			  	    Info.display("Save", "New employee saved!");
		    	}else{
		    		new Alert("Save", "Please select atleast one platform before you can save!");
		    	}
		    }else{
		    	new Alert("Save", "Please correct highlighted errors before you can save!");
		    }
	      }
	    };
	 	  
	  
	  public void show(){		  
		  window.show();
	  }

}
