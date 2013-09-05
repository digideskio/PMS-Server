/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.request;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.gwtmockito.GwtMock;
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.media2359.euphoria.view.dto.project.ProjectDTO;


/**
 * ManpowerRequestPresenterTest
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 **/
@RunWith(GwtMockitoTestRunner.class)
public class ManpowerRequestPresenterTest {
	ManpowerRequestPresenter presenter;
	@GwtMock ManpowerRequestView view;
	
	@Before
	public void setUp() {
		presenter = new ManpowerRequestPresenter(view);
	}
	
	@Test
	public void testOnProjectSelected() {
		ProjectDTO project = new ProjectDTO();
		String projectName = "Test Project";
		project.setName(projectName);
		presenter.onProjectSelected(project);
		verify(view).setProjectTitle(projectName);
	}

}
