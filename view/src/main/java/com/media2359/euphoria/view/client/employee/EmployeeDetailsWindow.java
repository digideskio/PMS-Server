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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
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

public class EmployeeDetailsWindow {

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	

	 public static final int ADD=0,VIEW=1,EDIT=2;
	 public static final String SUBMIT_BUTTON_TEXT = "Submit",CANCEL_BUTTON_TEXT = "Cancel",CREATE_ACC_BUTTON_TEXT = "Create Account",CLOSE_BUTTON_TEXT = "Close",EDIT_BUTTON_TEXT = "Edit";
	 	
	 Logger log = Logger.getLogger("EuphoriaLogger");
	 
	  private Window window;

	  private Component nameField,mobileField,personalEmail,companyEmail,designationCombo,employmentCombo; 
	  private CheckBox [] platformChecks;
	  
	  private TextButton firstButton,secondButton,thirdButton;
	  private FormPanel formPanel;
	  
	  private EmployeeDetailsCreator employeeDetailsCreator;
	  private EmployeeDetailsPresenter employeeDetailsPresenter;
	  
	  private EmployeeDTO employeeDTO;

	  public EmployeeDetailsWindow(int createType, EmployeeDTO employeeDTO){
		  this.employeeDTO=employeeDTO;
		  switch (createType){
			  case ADD: employeeDetailsCreator = new NewEmployeeDetailsCreator();break;
			  case VIEW: employeeDetailsCreator = new ViewEmployeeDetailsCreator(employeeDTO);break;
			  case EDIT: employeeDetailsCreator = new EditEmployeeDetailsCreator(employeeDTO);break;
			  default: employeeDetailsCreator = new ViewEmployeeDetailsCreator(employeeDTO);break;
		  }
		  createNewWindow();
		  employeeDetailsPresenter = new EmployeeDetailsPresenter();
	  }  
	  
	  @SuppressWarnings("unchecked")
	private void createNewWindow(){  
		  
		  
		  nameField = employeeDetailsCreator.createNameField();
		  mobileField = employeeDetailsCreator.createMobileField();
		  personalEmail = employeeDetailsCreator.createPersonalEmail();
		  companyEmail = employeeDetailsCreator.createCompanyEmail();
		  designationCombo = employeeDetailsCreator.createDesignationCombo();
		  employmentCombo = employeeDetailsCreator.createEmploymentCombo();
		  platformChecks = employeeDetailsCreator.createPlatforms();
		  log.info("Number of check boxes returned are "+platformChecks.length);

		  List<HorizontalPanel> platformPanels=new ArrayList<HorizontalPanel>();
		  if(platformChecks !=null && platformChecks.length > 1){
				  
			  for(int i=0;i<(int) Math.ceil((double)platformChecks.length/4.0); i++){
				  HorizontalPanel hPanel = new HorizontalPanel();
				  for(int j=(i*4); j<=(i*4)+3; j++){
					  if(j>=platformChecks.length)
						  break;
					   hPanel.add(platformChecks[j]); 	
				  }
				  platformPanels.add(hPanel) ;
			  }
		  }
		  
		  
		  VerticalLayoutContainer p = new VerticalLayoutContainer();
		  p.add(new FieldLabel(nameField, "Full Name"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(mobileField, "Mobile Number"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(personalEmail, "Personal Email"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(companyEmail, "Company Email"), new VerticalLayoutData(1, 50));
		  p.add(new FieldLabel(designationCombo, "Designation"), new VerticalLayoutData(1, 50));

		  if(platformPanels.size()>0){
			  for(int i=0; i<platformPanels.size(); i++)
			  {
				  if(i != 0 )
					  p.add(new FieldLabel(platformPanels.get(i)), new VerticalLayoutData(1, 50));	
				  else
					  p.add(new FieldLabel(platformPanels.get(i), "Platform"), new VerticalLayoutData(1, 50));	
			  }
		  }
		  p.add(new FieldLabel(employmentCombo, "Employment Type"), new VerticalLayoutData(1, 50));
		  
		  formPanel = new FormPanel();
		  formPanel.add(p);
		  
          
		  
		  FramedPanel fPanel = new FramedPanel();
		  fPanel.setWidth(450);
		  fPanel.setHeaderVisible(false);
		  fPanel.setBodyStyle("background: none; padding: 5px");
		  fPanel.add(formPanel);	 
		  
		  TextButton[] buttons = employeeDetailsCreator.createAndAddButtons();
		  secondButton = buttons[0];
		  
		  if(buttons.length>0){
			  firstButton=buttons[0];
			  firstButton.addSelectHandler(new ButtonSelectHandler(this));
			  fPanel.addButton(firstButton);
		  }
		  
		  if(buttons.length>1){
			  secondButton=buttons[1];
			  secondButton.addSelectHandler(new ButtonSelectHandler(this));
			  fPanel.addButton(secondButton);
		  }
		  
		  if(buttons.length>2){
			  thirdButton=buttons[2];
			  thirdButton.addSelectHandler(new ButtonSelectHandler(this));
			  fPanel.addButton(thirdButton);
		  }
		  		  
		   fPanel.setButtonAlign(BoxLayoutPack.CENTER);
		  
		  
		  window = new Window();		  
		  window.setPixelSize(500, 540);
		  window.setModal(true);
		  window.setBlinkModal(true);
		  window.setHeadingText(employeeDetailsCreator.getWindowHeader());
		  window.add(fPanel);
		  window.setFocusWidget(secondButton);
		}
	  

	    protected void show(){		  
		  window.show();
	  }

		/**
		 * @return the window
		 */
	    protected Window getWindow() {
			return window;
		}

		/**
		 * @return the nameField
		 */
		protected Component getNameField() {
			return nameField;
		}

		/**
		 * @return the mobileField
		 */
		protected Component getMobileField() {
			return mobileField;
		}

		/**
		 * @return the personalEmail
		 */
		protected Component getPersonalEmail() {
			return personalEmail;
		}

		/**
		 * @return the companyEmail
		 */
		protected Component getCompanyEmail() {
			return companyEmail;
		}

		/**
		 * @return the designationCombo
		 */
		protected Component getDesignationCombo() {
			return designationCombo;
		}

		/**
		 * @return the employmentCombo
		 */
		protected Component getEmploymentCombo() {
			return employmentCombo;
		}

		/**
		 * @return the formPanel
		 */
		protected FormPanel getFormPanel() {
			return formPanel;
		}

		/**
		 * @return the employeeDetailsPresenter
		 */
		protected EmployeeDetailsPresenter getEmployeeDetailsPresenter() {
			return employeeDetailsPresenter;
		}

		/**
		 * @return the employeeDTO
		 */
		protected EmployeeDTO getEmployeeDTO() {
			return employeeDTO;
		}

		/**
		 * @return the platformChecks
		 */
		public CheckBox[] getPlatformChecks() {
			return platformChecks;
		}
	  
		
    

}
