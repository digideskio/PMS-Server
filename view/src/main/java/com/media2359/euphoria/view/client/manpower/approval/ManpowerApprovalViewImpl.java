/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.approval;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

/**
 * ManpowerApprovalView
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 **/

public class ManpowerApprovalViewImpl extends Composite implements ManpowerApprovalView {
	@UiTemplate("ManpowerApprovalView.ui.xml")
	interface ManpowerApprovalViewUiBinder extends UiBinder<VerticalLayoutContainer, ManpowerApprovalViewImpl> {}
	private static ManpowerApprovalViewUiBinder uiBinder = GWT.create(ManpowerApprovalViewUiBinder.class);
	
	/**
	 * 
	 */
	public ManpowerApprovalViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
