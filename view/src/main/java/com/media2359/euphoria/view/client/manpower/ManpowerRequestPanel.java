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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.manpower.request.ManpowerRequestAllocationPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class ManpowerRequestPanel  implements IsWidget {
	interface ManpowerUiBinder extends UiBinder<VerticalLayoutContainer, ManpowerRequestPanel> {
	}

	private static ManpowerUiBinder uiBinder = GWT
			.create(ManpowerUiBinder.class);
	@UiField
	MyProjectsPanel selector;
	@UiField
	ManpowerRequestAllocationPanel allocator;
	@UiField
	ContentPanel header;
	
	VerticalLayoutContainer vp;

	@Override
	public Widget asWidget() {
		if(vp == null) {
			vp = uiBinder.createAndBindUi(this);
			selector.setParent(this);
		}
		return vp;
	}

	public void setAllocationPanelTitle(String title) {
		header.setHeadingText(title);
	}
	
	@UiHandler("addResource")
	public void addResource(SelectEvent ce) {
		//allocator.addNewRow();
	}
}
