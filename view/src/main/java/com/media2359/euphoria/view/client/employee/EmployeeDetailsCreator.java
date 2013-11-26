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

import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.CheckBox;


/**
 * EmployeeDetailsCreator
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public interface EmployeeDetailsCreator {
	
	public Component createName();
	public Component createMobile();
	public Component createPersonalEmail();
	public Component createCompanyEmail();
	public Component createDesignation();
	public Component createEmployment();
	public CheckBox[] createPlatforms();
	public Component createManDayRate();
	public Component createAssignedOffice();
	public Component createStartDate();
	public Component createEndDate();
	public Component createStatus();
	public TextButton[] createAndAddButtons();
	public String getWindowHeader();
}
