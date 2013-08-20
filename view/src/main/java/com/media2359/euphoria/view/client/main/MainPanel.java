package com.media2359.euphoria.view.client.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;

public class MainPanel extends Composite {
	interface MainUiBinder extends UiBinder<Widget, MainPanel> {
	}

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);

	public MainPanel() {
		// sets listBox
		initWidget(uiBinder.createAndBindUi(this));

	}
}
