/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.core.AllocationGridColorCell;
import com.media2359.euphoria.view.client.core.AllocationStatus;
import com.media2359.euphoria.view.client.core.Platforms;
import com.media2359.euphoria.view.client.employee.EmployeePresenter;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.event.CellClickEvent;
import com.sencha.gxt.widget.core.client.event.CellSelectionEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.HeaderGroupConfig;

/**
 * View class for allocating Weekly Manpower requests
 * 
 * @author AJ
 * @version 1.0
 * 
 */

interface Templates extends SafeHtmlTemplates {
    /**
     * The template for this Cell, which includes styles and a value.
     * 
     * @param styles the styles to include in the style attribute of the div
     * @param value the safe value. Since the value type is {@link SafeHtml},
     *          it will not be escaped before including it in the template.
     *          Alternatively, you could make the value type String, in which
     *          case the value would be escaped.
     * @return a {@link SafeHtml} instance
     */
    @SafeHtmlTemplates.Template("<div style=\"{0}\">{1}</div>")
    SafeHtml cell(SafeStyles styles, SafeHtml value);
  }


public class ManpowerAllocationProjectPanel implements IsWidget {
	Grid<WeeklyResourcePlan> grid;
	ComboBoxCell<EmployeeDTO> developerCombo;
	ComboBoxCell<String> platformCombo;
	 // A custom date format
    DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
    private ListStore<EmployeeDTO> employeeListStore = null;
    private ListStore<WeeklyResourcePlan> store = null;
    private Logger log = Logger.getLogger("EuphoriaLogger");
    
    private WeeklyResourcePlanProperties props;
    private EmployeeDTOProperties employeeProps;
    
    private List<WeeklyResourcePlan> orgWeeklyResourcePlanList;
    
    ProjectAllocationDTO projectAllocationDTO;
 	/**
	 * Main method to create this widget. Called by the GWT Framework
	 */
    
    private static Templates templates = GWT.create(Templates.class);
	public Widget asWidget() {
		
		props = GWT.create(WeeklyResourcePlanProperties.class);
		employeeProps = GWT.create(EmployeeDTOProperties.class);
		
	    ArrayList<ColumnConfig<WeeklyResourcePlan, ?>> configs = new ArrayList<ColumnConfig<WeeklyResourcePlan, ?>>();
	    
	    ColumnModel<WeeklyResourcePlan> cm = new ColumnModel<WeeklyResourcePlan>(configs);
	    
	    ColumnConfig<WeeklyResourcePlan, String> platformColumn = new ColumnConfig<WeeklyResourcePlan, String>(props.platform(), 130, "Platform");
	    platformColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 2px 3px;"));
	    
	    createPlatformCombo();
	    platformColumn.setCell(platformCombo);

        
	    ColumnConfig<WeeklyResourcePlan, EmployeeDTO> developerColumn = new ColumnConfig<WeeklyResourcePlan, EmployeeDTO>(props.developer(), 130, "Developer");
	    createDeveloperCombo();
	    developerColumn.setCell(developerCombo);
	    
	    configs.add(platformColumn);
	    configs.add(developerColumn);
	    cm.addHeaderGroup(0, 0, new HeaderGroupConfig("Platform/Developer", 1, 2));
	      
	    
	    ColumnConfig<WeeklyResourcePlan, AllocationStatus> amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day1Am(), 100, "AM");
		ColumnConfig<WeeklyResourcePlan, AllocationStatus> pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day1Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		amColumn.setCell(new AllocationGridColorCell());
		pmColumn.setCell(new AllocationGridColorCell());
		amColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		pmColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		cm.addHeaderGroup(0, 2, new HeaderGroupConfig("", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day2Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day2Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		amColumn.setCell(new AllocationGridColorCell());
		pmColumn.setCell(new AllocationGridColorCell());
		amColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		pmColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		cm.addHeaderGroup(0, 4, new HeaderGroupConfig("", 1, 2));

	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day3Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day3Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		amColumn.setCell(new AllocationGridColorCell());
		pmColumn.setCell(new AllocationGridColorCell());
		amColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		pmColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		cm.addHeaderGroup(0, 6, new HeaderGroupConfig("", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day4Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day4Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		amColumn.setCell(new AllocationGridColorCell());
		pmColumn.setCell(new AllocationGridColorCell());
		amColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		pmColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		cm.addHeaderGroup(0, 8, new HeaderGroupConfig("", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day5Am(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day5Pm(), 100, "PM");
		configs.add(amColumn);
		configs.add(pmColumn);
		amColumn.setCell(new AllocationGridColorCell());
		pmColumn.setCell(new AllocationGridColorCell());
		amColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		pmColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		cm.addHeaderGroup(0, 10, new HeaderGroupConfig("", 1, 2));
		
		
		
		
		store = new ListStore<WeeklyResourcePlan>(props.key());
 
	    
	    grid = new Grid<WeeklyResourcePlan>(store, cm);
	    grid.setBorders(true);
	    grid.getView().setStripeRows(true);
	    grid.getView().setColumnLines(true);
	    
	    grid.addCellClickHandler(new CellClickEvent.CellClickHandler() {
            @Override
            public void onCellClick(CellClickEvent evt) {
            	gridCellClicked(evt,grid.getStore());
            }
        });
   
	    return grid;
	}

	private WeeklyResourcePlanResponse getDummyWeeklyResourcePlan() {
		WeeklyResourcePlanResponse response = new WeeklyResourcePlanResponse();
		response.setWeekStartDate(new Date());
		
		List<WeeklyResourcePlan> weeklyResourcePlanList = new ArrayList<WeeklyResourcePlan>();
		employeeListStore.replaceAll(EmployeePresenter.getEmployees());
		WeeklyResourcePlan resourcePlan = new WeeklyResourcePlan();
		resourcePlan.setId("1");
		resourcePlan.setDay1Am(AllocationStatus.EXCEEDED);
		resourcePlan.setDay3Am(AllocationStatus.EXCEEDED);
		resourcePlan.setDay5Pm(AllocationStatus.EXCEEDED);
		resourcePlan.setDay1Pm(AllocationStatus.LEAVE);
		resourcePlan.setDay2Pm(AllocationStatus.HOLIDAY);
		weeklyResourcePlanList.add(resourcePlan);
				
		response.setWeeklyResourcePlanList(weeklyResourcePlanList);
		
		return response;
	}
	
	public void setProject(ProjectDTO project) {
		//TODO: Add logic to fetch allocation data from server as List<projectAllocationDTO> for projectDTO and startDate
		projectAllocationDTO = new ProjectAllocationDTO();

		WeeklyResourcePlanResponse response = getDummyWeeklyResourcePlan();
		orgWeeklyResourcePlanList = response.getWeeklyResourcePlanList();
		grid.getStore().replaceAll(response.getWeeklyResourcePlanList());
	}
	
	public void addRequest(){
		WeeklyResourcePlan weeklyPlan = new WeeklyResourcePlan();
		grid.getStore().add(weeklyPlan);
	}
	
	public void setWeekStartDate(Date startDate) {
		DateWrapper wrapper = new DateWrapper(startDate);
		ColumnModel<WeeklyResourcePlan> cm = grid.getColumnModel();
		List<HeaderGroupConfig> headerGroups = cm.getHeaderGroups();
		int i = 0;
		for(HeaderGroupConfig config:headerGroups) {
			    if(i == 0){
			    	++i;
			    	continue;
			    }
				config.setHtml(SafeHtmlUtils.fromString(fmt.format(wrapper.asDate())));
				wrapper = wrapper.addDays(1);
		}
	}
	
	public void reload() {
		grid.getView().refresh(true);
	}
	
	public void resetAllocation() {
		grid.getStore().clear();
		grid.getStore().replaceAll(orgWeeklyResourcePlanList);
	}
	

	public void setAllocationData(ProjectAllocationDTO allocationData) {
		orgWeeklyResourcePlanList = allocationData.getWeeklyResourcePlan();
		grid.getStore().replaceAll(allocationData.getWeeklyResourcePlan());
	}
	

	public ProjectAllocationDTO getAllocationData() {
		List<WeeklyResourcePlan> gridStore = grid.getStore().getAll();		
		projectAllocationDTO.setWeeklyResourcePlan(grid.getStore().getAll());
		return projectAllocationDTO;
	}

	private void createDeveloperCombo(){
		
		employeeListStore = new ListStore<EmployeeDTO>(employeeProps.key());
		 developerCombo = new ComboBoxCell<EmployeeDTO>(employeeListStore, new LabelProvider<EmployeeDTO>() {
		        @Override
		        public String getLabel(EmployeeDTO item) {
		          return item.getName();
		        }
		      });
		    
		    developerCombo.addSelectionHandler(new SelectionHandler<EmployeeDTO>() {
		   
		        @Override
		        public void onSelection(SelectionEvent<EmployeeDTO> event) {
		          CellSelectionEvent<EmployeeDTO> sel = (CellSelectionEvent<EmployeeDTO>) event;
		          WeeklyResourcePlan p = store.get(sel.getContext().getIndex());
		          p.setDeveloper(event.getSelectedItem());
		          log.info("Developer Selected"+ p.getId() + " selected " + event.getSelectedItem());
		        }
		      });
		    developerCombo.setTriggerAction(TriggerAction.ALL);
		    developerCombo.setForceSelection(true);
		    developerCombo.setWidth(110);
	}
	
	private void createPlatformCombo(){
		
				
		platformCombo = new ComboBoxCell<String>(Platforms.getAllPlatformsAsListStore(), new LabelProvider<String>() {
	        @Override
	        public String getLabel(String item) {
	          return item;
	        }
	      });
	    
	    platformCombo.addSelectionHandler(new SelectionHandler<String>() {
	   
	        @Override
	        public void onSelection(SelectionEvent<String> event) {
	          CellSelectionEvent<String> sel = (CellSelectionEvent<String>) event;
	          WeeklyResourcePlan p = store.get(sel.getContext().getIndex());
	          p.setPlatform(event.getSelectedItem());
	          log.info("Platform Selected"+ p.getId() + " selected " + event.getSelectedItem());
	        }
	      });
	    platformCombo.setTriggerAction(TriggerAction.ALL);
	    platformCombo.setForceSelection(true);
	    platformCombo.setWidth(110);
	}
	
	
	  
	   void gridCellClicked(CellClickEvent event, ListStore<WeeklyResourcePlan> listStore){ 
	     if(event.getCellIndex()<2)
	    	 return;
	     WeeklyResourcePlan p = listStore.get(event.getRowIndex());
	     
	     switch(event.getCellIndex()){
		     case 2: if(p.getDay1Am().equals(AllocationStatus.HOLIDAY)||p.getDay1Am().equals(AllocationStatus.LEAVE))
		    	     	return;
		          	 p.setDay1Am(getNewAllocationStatus(p.getDay1Am()));break;
		     case 3: if(p.getDay1Pm().equals(AllocationStatus.HOLIDAY)||p.getDay1Pm().equals(AllocationStatus.LEAVE))
	    	     	  return;
		     		 p.setDay1Pm(getNewAllocationStatus(p.getDay1Pm()));break;
		     case 4: if(p.getDay2Am().equals(AllocationStatus.HOLIDAY)||p.getDay2Am().equals(AllocationStatus.LEAVE))
   	     	  			return;
		     		 p.setDay2Am(getNewAllocationStatus(p.getDay2Am()));break;
		     case 5: if(p.getDay2Pm().equals(AllocationStatus.HOLIDAY)||p.getDay2Pm().equals(AllocationStatus.LEAVE))
		    	 		return;
		     		 p.setDay2Pm(getNewAllocationStatus(p.getDay2Pm()));break;
		     case 6: if(p.getDay3Am().equals(AllocationStatus.HOLIDAY)||p.getDay3Am().equals(AllocationStatus.LEAVE))
   	     	  			return;
		     	   	 p.setDay3Am(getNewAllocationStatus(p.getDay3Am()));break;
		     case 7: if(p.getDay3Pm().equals(AllocationStatus.HOLIDAY)||p.getDay3Pm().equals(AllocationStatus.LEAVE))
   	     	  			return;
		     		 p.setDay3Pm(getNewAllocationStatus(p.getDay3Pm()));break;
		     case 8: if(p.getDay4Am().equals(AllocationStatus.HOLIDAY)||p.getDay4Am().equals(AllocationStatus.LEAVE))
   	     	  			return;
		     		 p.setDay4Am(getNewAllocationStatus(p.getDay4Am()));break;
		     case 9: if(p.getDay4Pm().equals(AllocationStatus.HOLIDAY)||p.getDay4Pm().equals(AllocationStatus.LEAVE))
   	     	  			return;
		     		 p.setDay4Pm(getNewAllocationStatus(p.getDay4Pm()));break;
		     case 10: if(p.getDay5Am().equals(AllocationStatus.HOLIDAY)||p.getDay5Am().equals(AllocationStatus.LEAVE))
   	     	  			return;
		     		 p.setDay5Am(getNewAllocationStatus(p.getDay5Am()));break;
		     case 11: if(p.getDay5Pm().equals(AllocationStatus.HOLIDAY)||p.getDay5Pm().equals(AllocationStatus.LEAVE))
		    	 		return;
		     		 p.setDay5Pm(getNewAllocationStatus(p.getDay5Pm()));break;
		     default: break;
	     }
	     reload();
	  }
	  
	   private AllocationStatus getNewAllocationStatus(AllocationStatus previousStatus){
		   switch(previousStatus){
			   	case FREE: return AllocationStatus.SELECTED;
			   	case SELECTED: return AllocationStatus.FREE;
			   	case EXCEEDED: return AllocationStatus.SELECTED_EXCEEDED;
			   	case SELECTED_EXCEEDED: return AllocationStatus.EXCEEDED;
			   	default:   return previousStatus;
		   }
		   
	   }
	  
}
