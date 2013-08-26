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

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.ParseErrorEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.validator.MinDateValidator;
import com.sencha.gxt.widget.core.client.info.Info;

public class ManpowerApprovalPanel  implements IsWidget {
	interface ManpowerUiBinder extends UiBinder<VerticalLayoutContainer, ManpowerApprovalPanel> {
	}

	private static ManpowerUiBinder uiBinder = GWT
			.create(ManpowerUiBinder.class);
	@UiField
	MyProjectsPanel selector;
	@UiField
	ManpowerApprovalAllocationPanel allocator;
	@UiField
	ContentPanel header;
	@UiField
	DateField datepicker;
	
	VerticalLayoutContainer vp;

	@Override
	public Widget asWidget() {
		if(vp == null) {
			vp = uiBinder.createAndBindUi(this);
			datepicker.addValidator(new MinDateValidator(new Date()));
			datepicker.setAutoValidate(true);
			//selector.setParent(this);
		}
		return vp;
	}

	public void setAllocationPanelTitle(String title) {
		header.setHeadingText(title);
	}
	
	@UiHandler("datepicker")
	public void onDateParseError(ParseErrorEvent event) {
		Info.display("Parse Error", event.getErrorValue()
				+ " could not be parsed as a date");
	}
}
