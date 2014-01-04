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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.gwt.junit.GWTMockUtilities;
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.media2359.euphoria.view.client.manpower.request.ManpowerRequestAllocationPanel;

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
@RunWith(GwtMockitoTestRunner.class)
public class ManpowerRequestAllocationPanelTest {
	ManpowerRequestAllocationPanel allocationPanel;
	//@GwtMock WeeklyResourceRequestProperties props;

	public ManpowerRequestAllocationPanelTest() {
		allocationPanel = new ManpowerRequestAllocationPanel();
	}
	
	@BeforeClass
	public static void setUp() {
		GWTMockUtilities.disarm();
	}
	
	@Test
	public void testInitialRows() {
		//allocationPanel.asWidget();
		//assertNotNull(allocationPanel.grid);
	}
	
	@AfterClass
	public static void teardown() {
		GWTMockUtilities.restore();
	}

}
