package com.media2359.euphoria.view.client.project;

import java.util.List;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.media2359.euphoria.view.message.project.Project;
import com.sencha.gxt.core.client.Style.LayoutRegion;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CardLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.form.ComboBox;

public class ProjectContainer extends BorderLayoutContainer{
	
	private CardLayoutContainer northCardCon;
	private CardLayoutContainer southCardCon;
	private CardLayoutContainer westCardCon;
	private CardLayoutContainer eastCardCon;
	private CardLayoutContainer centerCardCon;
	
	private BorderLayoutData northData;
	private BorderLayoutData southData;
	private BorderLayoutData westData;
	private BorderLayoutData eastData;
	private MarginData centerData;
	
	private ProjectGrid projectGrid;
	private ContentPanel mainGridPnl;
	private ContentPanel subGridPnl;
	
	
	private HorizontalPanel projSearchPanel;
	private HTML projectSearchLbl;
	private ComboBox projectSearchCmb;
	
	public ProjectContainer(){
		super();
		
		projectGrid = new ProjectGrid();
		
		mainGridPnl = new ContentPanel();
		mainGridPnl.setHeadingText(" Projects" );
		mainGridPnl.add(projectGrid);
		
		projectSearchLbl = new HTML( "<b><span style=\"color:#9C8C8C\">Find Project: </b>");
		projectSearchLbl.setPixelSize(130, 30);
//		projectSearchCmb = new ComboBox<Project>(null);

		projSearchPanel = new HorizontalPanel();
		projSearchPanel.add(projectSearchLbl);
//		projSearchPanel.add(projectSearchCmb);
		
		northCardCon = new CardLayoutContainer();
		southCardCon = new CardLayoutContainer();
		westCardCon = new CardLayoutContainer();
		eastCardCon = new CardLayoutContainer();
		centerCardCon = new CardLayoutContainer();
		
		centerCardCon.add(mainGridPnl);
		centerCardCon.setActiveWidget(mainGridPnl);
		
		northCardCon.add(projSearchPanel);
		northCardCon.setActiveWidget(projSearchPanel);
		
		northData = new BorderLayoutData(40);		    
	    southData = new BorderLayoutData(100);		    
	    westData = new BorderLayoutData(150);		    
	    eastData = new BorderLayoutData(150);		    
	    centerData = new MarginData();
	    
	    setBorders(true);
	    
	    setNorthWidget(northCardCon, northData);
	    setSouthWidget(southCardCon, southData);
	    setWestWidget(westCardCon, westData);
	    setEastWidget(eastCardCon, eastData);
	    setCenterWidget(centerCardCon,centerData);
	    
	    hide(LayoutRegion.EAST);
	    hide(LayoutRegion.WEST);
	    hide(LayoutRegion.SOUTH);
		
	}
	
	public void populateMainGrid(List<Project>  projects){
		
		if((projects != null) && (!projects.isEmpty())) {
			projectGrid.populateData(projects);
		} else {
			projectGrid.clear();
		}
		
	}

}
