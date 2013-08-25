///**************************************************************************
// * Copyright (c) 2013 2359 Media Pvt Ltd
// *
// * NOTICE:  All information contained herein is, and remains the 
// * property of 2359 Media Pvt Ltd and its suppliers, if any. 
// * Dissemination of this information or reproduction of this material
// * is strictly forbidden unless prior written permission is obtained
// * from 2359 Media Pvt Ltd
// ***************************************************************************/
//package com.media2359.euphoria.view.client.employee;
//
//import com.google.gwt.uibinder.client.UiBinder;
//import com.google.gwt.uibinder.client.UiField;
//import com.google.gwt.uibinder.client.UiHandler;
//import com.google.gwt.user.client.ui.IsWidget;
//import com.google.gwt.user.client.ui.Widget;
//import com.sencha.gxt.widget.core.client.Window;
//import com.sencha.gxt.widget.core.client.button.TextButton;
//import com.sencha.gxt.widget.core.client.event.HideEvent;
//import com.sencha.gxt.widget.core.client.event.SelectEvent;
//import com.sencha.gxt.widget.core.client.form.NumberField;
//import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;
//import com.sencha.gxt.widget.core.client.info.Info;
//import com.google.gwt.core.client.GWT;
//
///**
// * NewEmployeeWindow
// *
// * TODO Write something about this class
// * 
// * @author Praveen
// * @version 1.0 2013
// **/
//
//public class NewEmployeeWindow {
//
//	/* (non-Javadoc)
//	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
//	 */
//	
//	 interface NewEmployeeWindowUIBinder extends UiBinder<Widget, NewEmployeeWindow> {
//	  }
//	 
//	  private static NewEmployeeWindowUIBinder uiBinder = GWT.create(NewEmployeeWindowUIBinder.class);
//	 
//	  @UiField
//	  Window window;
//	  
//	  @UiField(provided = true)
//	  NumberField<Integer> mobile;
//	  
//	  public NewEmployeeWindow(){		    
//			uiBinder.createAndBindUi(this);
//		}
//	
//	  @UiHandler("cancelButton")
//	  public void onCloseButtonClicked(SelectEvent event) {
//	    window.hide();
//	    Info.display("Click", "Creation of new employee cancelled!");
//	  }
//	  
//	  @UiHandler("saveButton")
//	  public void onSaveButtonClicked(SelectEvent event) {
//	    window.hide();
//	    Info.display("Click", "New Employee to be created!");
//	  }
//	  
//	  
//	  public void show(){
//		  
//		  window.show();
//	  }
//
//}
