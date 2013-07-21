package com.media2359.euphoria.view.client.utils;

import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class ConfirmPopUp extends DecoratedPopupPanel {
	@SuppressWarnings("deprecation")
	public ConfirmPopUp(String title, final ClientCallBack cb) {
		super(true, false);
		Grid grid = new Grid(2, 1);
		setWidget(grid);
		grid.setSize("529px", "90px");
		
		Label lblTitle = new Label(title);
		lblTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		grid.setWidget(0, 0, lblTitle);
		
		HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
		grid.setWidget(1, 0, horizontalSplitPanel);
		horizontalSplitPanel.setHeight("32px");
		
		Button btnCancel = new Button("Cancel");
		btnCancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		horizontalSplitPanel.setLeftWidget(btnCancel);
		btnCancel.setSize("100%", "100%");
		
		Button btnConfirm = new Button("CONFIRM");
		btnConfirm.setText("Confirm");
		btnConfirm.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				cb.confirmCallBackForDelete(ClientCallBack.CONFIRM);
			}
		});
		horizontalSplitPanel.setRightWidget(btnConfirm);
		btnConfirm.setSize("100%", "100%");
		grid.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
		grid.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_MIDDLE);
	}

}
