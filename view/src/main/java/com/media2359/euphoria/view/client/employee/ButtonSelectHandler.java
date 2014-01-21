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
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

/**
 * ButtonSelectHandler
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public class ButtonSelectHandler implements SelectHandler{

	private EmployeeDetailsWindow sourceWindow;
	
	public ButtonSelectHandler(EmployeeDetailsWindow sourceWindow){
		this.sourceWindow=sourceWindow;
	}
	/* (non-Javadoc)
	 * @see com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler#onSelect(com.sencha.gxt.widget.core.client.event.SelectEvent)
	 */
	@Override
	public void onSelect(SelectEvent event) {

  	  TextButton btn = (TextButton)event.getSource();
  	  if(btn.getText().equals(EmployeeDetailsWindow.SUBMIT_BUTTON_TEXT))
  		sourceWindow.getEmployeeDetailsPresenter().submitButtonClicked(sourceWindow);
  	  else if(btn.getText().equals(EmployeeDetailsWindow.CANCEL_BUTTON_TEXT))
  		sourceWindow.getEmployeeDetailsPresenter().cancelButtonClicked(sourceWindow);
  	  else if(btn.getText().equals(EmployeeDetailsWindow.CREATE_ACC_BUTTON_TEXT))
  		sourceWindow.getEmployeeDetailsPresenter().createAccountButtonClicked(sourceWindow);
  	  else if(btn.getText().equals(EmployeeDetailsWindow.CLOSE_BUTTON_TEXT))
  		sourceWindow.getEmployeeDetailsPresenter().closeButtonClicked(sourceWindow);
  	 else if(btn.getText().equals(EmployeeDetailsWindow.EDIT_BUTTON_TEXT))
   		sourceWindow.getEmployeeDetailsPresenter().editButtonClicked(sourceWindow);
		
	}

}
