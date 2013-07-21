package com.media2359.euphoria.view.client.utils;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class InputPopUp extends DecoratedPopupPanel {
	public InputPopUp(String title, final ClientCallBack cb) {
		
		super(true, false);
		
		setSize("417px", "136px");
		
		Grid grid = new Grid(3, 1);
		setWidget(grid);
		grid.setSize("399px", "126px");
		
		Label lblTitle = new Label(title);
		lblTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		grid.setWidget(0, 0, lblTitle);
		
		final TextBox textValue = new TextBox();
		grid.setWidget(1, 0, textValue);
		textValue.setWidth("390px");
		
		HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
		grid.setWidget(2, 0, horizontalSplitPanel);
		horizontalSplitPanel.setHeight("32px");
		
		Button btnCancel = new Button("Cancel");
		btnCancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		horizontalSplitPanel.setLeftWidget(btnCancel);
		btnCancel.setSize("100%", "100%");
		
		Button btnOk = new Button("OK");
		btnOk.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				cb.nameCallBackForAdding(ClientCallBack.OK, textValue.getValue());
			}
		});
		horizontalSplitPanel.setRightWidget(btnOk);
		btnOk.setSize("100%", "100%");
		grid.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_CENTER);
	
	}


}
