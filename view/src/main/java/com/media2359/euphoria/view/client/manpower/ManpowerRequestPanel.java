package com.media2359.euphoria.view.client.manpower;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.menu.Item;

public class ManpowerRequestPanel extends Composite {

	interface ManpowerUiBinder extends UiBinder<Widget, ManpowerRequestPanel> {
	}

	private static ManpowerUiBinder uiBinder = GWT.create(ManpowerUiBinder.class);

	public ManpowerRequestPanel() {
		// sets listBox
		initWidget(uiBinder.createAndBindUi(this));

	}

	// @UiHandler("newFile")
	public void onNewFile(SelectionEvent<Item> event) {
		Info.display("New File", "You have clicked on the New File MenuItem");
	}
}
