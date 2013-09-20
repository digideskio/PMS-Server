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
	
	public Component createNameField();
	public Component createMobileField();
	public Component createPersonalEmail();
	public Component createCompanyEmail();
	public Component createDesignationCombo();
	public Component createEmploymentCombo();
	public CheckBox[] createPlatforms();
	public TextButton[] createAndAddButtons();
	public String getWindowHeader();
}
