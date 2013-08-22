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

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.gwtmockito.GwtMock;
import com.google.gwtmockito.GwtMockitoTestRunner;

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
	@GwtMock WeeklyResourceRequestProperties mockProperties;

	public ManpowerRequestAllocationPanelTest() {
		allocationPanel = new ManpowerRequestAllocationPanel();
	}
	
	@Test
	public void testInitialRows() {
		assertEquals(allocationPanel.grid, null);
	}

}
