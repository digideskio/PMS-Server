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

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
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

	  private Component name,mobile,personalEmail,companyEmail,designation,employment,mandayRate,assignedOffice,startDate,endDate,status; 
	  private CheckBox [] platformChecks;
	  
	  private TextButton firstButton,secondButton,thirdButton;
	  private FormPanel formPanel;
	  
	  private EmployeeDetailsCreator employeeDetailsCreator;
	  private EmployeeDetailsPresenter employeeDetailsPresenter;
	  
	  private EmployeeDTO employeeDTO;
	  private EmployeePresenter empPresenter;
	  
	  private List<PlatformDTO> allPlatformDTOs;


	public EmployeeDetailsWindow(int createType, EmployeeDTO employeeDTO, EmployeePresenter empPresenter){
		  this.employeeDTO=employeeDTO;
		  this.empPresenter = empPresenter;
		  switch (createType){
			  case ADD: employeeDetailsCreator = new NewEmployeeDetailsCreator();break;
			  case VIEW: employeeDetailsCreator = new ViewEmployeeDetailsCreator(employeeDTO);break;
			  case EDIT: employeeDetailsCreator = new EditEmployeeDetailsCreator(employeeDTO);break;
			  default: employeeDetailsCreator = new ViewEmployeeDetailsCreator(employeeDTO);break;
		  }
		  createNewWindow(createType,employeeDTO);
		  employeeDetailsPresenter = new EmployeeDetailsPresenter(createType, empPresenter);
	  }  
	  
	  @SuppressWarnings("unchecked")
	private void createNewWindow(final int createType,final EmployeeDTO employeeDTO){  
		  
		  
		  name = employeeDetailsCreator.createName();
		  mobile = employeeDetailsCreator.createMobile();
		  personalEmail = employeeDetailsCreator.createPersonalEmail();
		  companyEmail = employeeDetailsCreator.createCompanyEmail();
		  designation = employeeDetailsCreator.createDesignation();
		  employment = employeeDetailsCreator.createEmployment();
		  mandayRate = employeeDetailsCreator.createManDayRate();
		  assignedOffice = employeeDetailsCreator.createAssignedOffice();
		  startDate = employeeDetailsCreator.createStartDate();
		  endDate = employeeDetailsCreator.createEndDate();
		  status = employeeDetailsCreator.createStatus();
		  
			final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
					"Progress", "Loading data. Please wait...");
			final AsyncCallback<List<PlatformDTO>> callback = new AsyncCallback<List<PlatformDTO>>() {

				public void onFailure(Throwable caught) {
					messageBox.hide();
					AlertMessageBox alert = new AlertMessageBox("Error",
							caught.getMessage());
					alert.show();
				}

				public void onSuccess(List<PlatformDTO> result) {
					messageBox.hide();
					
					allPlatformDTOs = result;
					platformChecks = new CheckBox[allPlatformDTOs.size()];
					
					for(int i=0; i<allPlatformDTOs.size();i++){
						platformChecks[i]= new CheckBox();
						platformChecks[i].setBoxLabel(allPlatformDTOs.get(i).getPlatformId());
						if(createType == VIEW){
							platformChecks[i].setValue(employeeDTO.getPlatforms().contains(allPlatformDTOs.get(i).getPlatformId()));
							platformChecks[i].setReadOnly(true);
						}else if (createType == EDIT){
							platformChecks[i].setValue(employeeDTO.getPlatforms().contains(allPlatformDTOs.get(i).getPlatformId()));
						}
					}
					
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
					  p.add(new FieldLabel(name, "Full Name"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(mobile, "Mobile Number"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(personalEmail, "Personal Email"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(companyEmail, "Company Email"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(designation, "Designation"), new VerticalLayoutData(1, 35));

					  if(platformPanels.size()>0){
						  for(int i=0; i<platformPanels.size(); i++)
						  {
							  if(i != 0 )
								  p.add(new FieldLabel(platformPanels.get(i)), new VerticalLayoutData(1, 35));	
							  else
								  p.add(new FieldLabel(platformPanels.get(i), "Platform"), new VerticalLayoutData(1, 35));	
						  }
					  }
					  p.add(new FieldLabel(employment, "Employment Type"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(mandayRate, "Manday Rate"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(assignedOffice, "Assigned Office"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(startDate, "Start Date"), new VerticalLayoutData(1, 35));
					  p.add(new FieldLabel(endDate, "End Date"), new VerticalLayoutData(1, 35));		  
					  p.add(new FieldLabel(status, "Status"), new VerticalLayoutData(1, 35));
					  
					  
					  formPanel.remove(0);
					  formPanel.add(p);
					  
					  window.setPixelSize(500, p.getWidgetCount()*50);

				}

			};
			empPresenter.getEmployeeService().findAllPlatforms(callback);
			messageBox.auto();
			messageBox.show();
			
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
		  p.add(new FieldLabel(name, "Full Name"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(mobile, "Mobile Number"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(personalEmail, "Personal Email"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(companyEmail, "Company Email"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(designation, "Designation"), new VerticalLayoutData(1, 35));

		  if(platformPanels.size()>0){
			  for(int i=0; i<platformPanels.size(); i++)
			  {
				  if(i != 0 )
					  p.add(new FieldLabel(platformPanels.get(i)), new VerticalLayoutData(1, 35));	
				  else
					  p.add(new FieldLabel(platformPanels.get(i), "Platform"), new VerticalLayoutData(1, 35));	
			  }
		  }
		  p.add(new FieldLabel(employment, "Employment Type"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(mandayRate, "Manday Rate"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(assignedOffice, "Assigned Office"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(startDate, "Start Date"), new VerticalLayoutData(1, 35));
		  p.add(new FieldLabel(endDate, "End Date"), new VerticalLayoutData(1, 35));		  
		  p.add(new FieldLabel(status, "Status"), new VerticalLayoutData(1, 35));
		  
		  
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
		  window.setPixelSize(500, p.getWidgetCount()*50);
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

		/**
		 * @return the mandayRate
		 */
		public Component getMandayRate() {
			return mandayRate;
		}

		/**
		 * @return the assignedOffice
		 */
		public Component getAssignedOffice() {
			return assignedOffice;
		}


		/**
		 * @return the name
		 */
		public Component getName() {
			return name;
		}

		/**
		 * @return the mobile
		 */
		public Component getMobile() {
			return mobile;
		}


		/**
		 * @return the designation
		 */
		public Component getDesignation() {
			return designation;
		}


		/**
		 * @return the employment
		 */
		public Component getEmployment() {
			return employment;
		}
		/**
		 * @return the startDate
		 */
		public Component getStartDate() {
			return startDate;
		}


		/**
		 * @return the endDate
		 */
		public Component getEndDate() {
			return endDate;
		}

		/**
		 * @return the status
		 */
		public Component getStatus() {
			return status;
		}

	  	  
	    public List<PlatformDTO> getAllPlatformDTOs() {
			return allPlatformDTOs;
		}
		
		public void setAllPlatformDTOs(List<PlatformDTO> allPlatformDTOs) {
			this.allPlatformDTOs = allPlatformDTOs;
		}
    

}
