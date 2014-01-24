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

/**
 * EmployeePanel
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **
 **/

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.media2359.euphoria.view.client.common.Resources;
import com.sencha.gxt.cell.core.client.ButtonCell.IconAlign;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class EmployeePanel extends Composite {
	interface EmployeePanelUiBinder extends
			UiBinder<VerticalLayoutContainer, EmployeePanel> {
	}
	
	
	private EmployeePresenter employeePresenter;
	
	EmployeePanelUiBinder uiBinder = GWT.create(EmployeePanelUiBinder.class);

	
	@UiField
	EmployeeGrid employeeGrid;
	
	@UiField
	TextButton addButton;
	
	private Logger log = Logger.getLogger("EuphoriaLogger");

	/**
	 * This is the entry point method.
	 */
	public EmployeePanel() {
		initWidget(uiBinder.createAndBindUi(this));
		Resources resources = GWT.create(Resources.class);
		addButton.setIcon(resources.adduser());
		addButton.setIconAlign(IconAlign.LEFT);
		
		employeePresenter = new EmployeePresenter(employeeGrid);
		/**
		 * Fetch the data when this panel is shown
		 */
		employeePresenter.loadData();
	}
	
	@UiHandler({"addButton"})
	  public void onButtonClick(SelectEvent event) {

		employeePresenter.addButtonClicked(event);
	  }
	
	
}
