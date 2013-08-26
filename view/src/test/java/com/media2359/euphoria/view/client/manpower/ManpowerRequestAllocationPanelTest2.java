/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * 
 * ManpowerRequestAllocationPanelTest
 *
 * Class to test the Manpower Allocation View
 * 
 * @author AJ
 * @version 1.0 2013
 *
 */
public class ManpowerRequestAllocationPanelTest2 extends GWTTestCase {
	ManpowerRequestAllocationPanel allocationPanel;

	public ManpowerRequestAllocationPanelTest2() {
		allocationPanel = new ManpowerRequestAllocationPanel();
	}
	
	public void testInitialRows() {
		allocationPanel.asWidget();
		System.out.println(allocationPanel);
		assertNotNull(allocationPanel.grid);
		assertNotNull(allocationPanel.grid.getStore());
	}
	
	public void testNullData() {
		try {
			allocationPanel.update(null);
			//fail("Exception not thrown.");
		} catch(Exception e) {};
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
	 */
	@Override
	public String getModuleName() {
		return "com.media2359.euphoria.view.Euphoria";
	}

}
