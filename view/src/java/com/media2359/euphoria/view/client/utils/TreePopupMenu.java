package com.media2359.euphoria.view.client.utils;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import com.media2359.euphoria.view.client.Euphoria;
import com.media2359.euphoria.view.client.TreeNode;

public class TreePopupMenu extends DecoratedPopupPanel{	
	
	public TreePopupMenu( int level, final ClientCallBack cb) {
		super(true,false);
		String addBtnLabel="",delBtnLabel="Delete";
		switch(level){
			case Euphoria.ROOT_LEVEL:addBtnLabel="Add Project";break;
			case Euphoria.PROJECT_LEVEL:addBtnLabel="Add Phase";break;
			case Euphoria.PHASE_LEVEL:addBtnLabel="Add Task";break;
			case Euphoria.TASK_LEVEL:delBtnLabel="Delete";break;
		}
		
		if(level==Euphoria.ROOT_LEVEL)
			setSize("89px", "71px");
		else if(level==Euphoria.TASK_LEVEL)
			setSize("89px", "51px");
		else
			setSize("89px", "101px");
		setAnimationEnabled(true);
		
		Grid gridPanel = new Grid(2, 1);
		setWidget(gridPanel);
		if(level==Euphoria.ROOT_LEVEL)
			gridPanel.setSize("71px", "54px");
		else if(level==Euphoria.TASK_LEVEL)
			gridPanel.setSize("71px", "34px");
		else
			gridPanel.setSize("71px", "84px");
		
		if(!(level==Euphoria.TASK_LEVEL)){
			Button btnAdd = new Button(addBtnLabel);
			btnAdd.setSize("70px", "50px");
			gridPanel.setWidget(0, 0, btnAdd);
			btnAdd.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					hide();		
					cb.addOrDeleteCallBackFromTree(ClientCallBack.ADD);
				}
			});
		}
		
		if(!(level==Euphoria.ROOT_LEVEL)){
			Button btnDelete = new Button(delBtnLabel);					
			btnDelete.setSize("70px", "30px");
			gridPanel.setWidget(1, 0, btnDelete);	
			btnDelete.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					hide();					
					cb.addOrDeleteCallBackFromTree(ClientCallBack.DELETE);
				}
			});
		}
	}


}
