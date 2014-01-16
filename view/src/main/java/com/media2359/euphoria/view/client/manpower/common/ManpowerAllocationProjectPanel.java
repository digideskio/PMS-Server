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
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.client.core.AllocationGridColorCell;
import com.media2359.euphoria.view.client.employee.EmployeePresenter;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.util.AllocationStatus;
import com.media2359.euphoria.view.server.employee.EmployeeService;
import com.media2359.euphoria.view.server.employee.EmployeeServiceAsync;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.event.CellSelectionEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.HeaderGroupConfig;

/**
 * View class for allocating Weekly Manpower requests
 * 
 * @author Praveen,AJ
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
	ComboBoxCell<PlatformDTO> platformCombo;
	 // A custom date format
    DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
    private ListStore<EmployeeDTO> employeeListStore = null;
    private ListStore<PlatformDTO> platformListStore = null;
    private ListStore<WeeklyResourcePlan> store = null;
    private Logger log = Logger.getLogger("EuphoriaLogger");
    
    private WeeklyResourcePlanProperties props;
    private EmployeeDTOProperties employeeProps;
    private PlatformDTOProperties platformProps;
    
    private List<WeeklyResourcePlan> orgWeeklyResourcePlanList;
    private  ArrayList<ColumnConfig<WeeklyResourcePlan, ?>> configs;
    
    ProjectAllocationDTO projectAllocationDTO;
 	/**
	 * Main method to create this widget. Called by the GWT Framework
	 */

	public Widget asWidget() {
		
		props = GWT.create(WeeklyResourcePlanProperties.class);
		employeeProps = GWT.create(EmployeeDTOProperties.class);
		platformProps = GWT.create(PlatformDTOProperties.class);
		
	    configs = new ArrayList<ColumnConfig<WeeklyResourcePlan, ?>>();
	    
	    ColumnModel<WeeklyResourcePlan> cm = new ColumnModel<WeeklyResourcePlan>(configs);
	    
	    ColumnConfig<WeeklyResourcePlan, PlatformDTO> platformColumn = new ColumnConfig<WeeklyResourcePlan, PlatformDTO>(props.platform(), 130, "Platform");
	    platformColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 2px 3px;"));
	    
	    createPlatformCombo();
	    //platformColumn.setCell(platformCombo);

        
	    ColumnConfig<WeeklyResourcePlan, EmployeeDTO> developerColumn = new ColumnConfig<WeeklyResourcePlan, EmployeeDTO>(props.developer(), 130, "Developer");
	    createDeveloperCombo();
	    developerColumn.setCell(developerCombo);
	    
	    configs.add(platformColumn);
	    configs.add(developerColumn);
	    cm.addHeaderGroup(0, 0, new HeaderGroupConfig("Platform/Developer", 1, 2));
	      
	    
	    ColumnConfig<WeeklyResourcePlan, AllocationStatus> amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day1AmEnm(), 100, "AM");
		ColumnConfig<WeeklyResourcePlan, AllocationStatus> pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day1PmEnm(), 100, "PM");
		prepareGrid(amColumn, pmColumn);
		cm.addHeaderGroup(0, 2, new HeaderGroupConfig("", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day2AmEnm(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day2PmEnm(), 100, "PM");
		prepareGrid(amColumn, pmColumn);
		cm.addHeaderGroup(0, 4, new HeaderGroupConfig("", 1, 2));

	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day3AmEnm(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day3PmEnm(), 100, "PM");
		prepareGrid(amColumn, pmColumn);
		cm.addHeaderGroup(0, 6, new HeaderGroupConfig("", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day4AmEnm(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day4PmEnm(), 100, "PM");
		prepareGrid(amColumn, pmColumn);
		cm.addHeaderGroup(0, 8, new HeaderGroupConfig("", 1, 2));
		
	    amColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day5AmEnm(), 100, "AM");
		pmColumn = new ColumnConfig<WeeklyResourcePlan, AllocationStatus>(props.day5PmEnm(), 100, "PM");
		prepareGrid(amColumn, pmColumn);
		cm.addHeaderGroup(0, 10, new HeaderGroupConfig("", 1, 2));
		
		store = new ListStore<WeeklyResourcePlan>(props.key());
 
		grid = new Grid<WeeklyResourcePlan>(store, cm);
	    grid.setBorders(true);
	    grid.getView().setStripeRows(true);
	    grid.getView().setColumnLines(true);
	    return grid;
	}

	private void prepareGrid(ColumnConfig<WeeklyResourcePlan, AllocationStatus> amColumn, ColumnConfig<WeeklyResourcePlan, AllocationStatus> pmColumn){
		configs.add(amColumn);
		configs.add(pmColumn);
		amColumn.setCell(new AllocationGridColorCell());
		pmColumn.setCell(new AllocationGridColorCell());
		amColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		pmColumn.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 0px 0px;"));
		amColumn.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		pmColumn.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
	}
	private WeeklyResourcePlanResponse getDummyWeeklyResourcePlan() {
		WeeklyResourcePlanResponse response = new WeeklyResourcePlanResponse();
		response.setWeekStartDate(new Date());
		
		List<WeeklyResourcePlan> weeklyResourcePlanList = new ArrayList<WeeklyResourcePlan>();
		employeeListStore.replaceAll(EmployeePresenter.getEmployees());
		WeeklyResourcePlan resourcePlan = new WeeklyResourcePlan();
		resourcePlan.setId("1");
		resourcePlan.setDay1AmEnm(AllocationStatus.SELECTED);
		resourcePlan.setDay1PmEnm(AllocationStatus.LEAVE);
		resourcePlan.setDay2AmEnm(AllocationStatus.EXCEEDED);
		resourcePlan.setDay2PmEnm(AllocationStatus.HOLIDAY);
		resourcePlan.setDay3AmEnm(AllocationStatus.SELECTED_EXCEEDED);
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
		projectAllocationDTO.setWeeklyResourcePlan(grid.getStore().getAll());
		return projectAllocationDTO;
	}
	
	public ProjectAllocationDTO save(){
		return getAllocationData();
	}

	public ProjectAllocationDTO approve(){
		return getAllocationData();
	}
	
	public ProjectAllocationDTO delete(){
		return getAllocationData();
	}

	
	public void setClickEnabled(boolean clickEnabled){
		AllocationGridColorCell.CLICK_ENABLED = clickEnabled;
	}
	
	private void createDeveloperCombo(){
		
		employeeListStore = new ListStore<EmployeeDTO>(employeeProps.employeeKey());
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
		
	platformListStore = new ListStore<PlatformDTO>(platformProps.platformKey());
	platformCombo = new ComboBoxCell<PlatformDTO>(platformListStore, new LabelProvider<PlatformDTO>() {
	        @Override
	        public String getLabel(PlatformDTO item) {
	          return item.getPlatformId();
	        }
	      });

	
	    platformCombo.addSelectionHandler(new SelectionHandler<PlatformDTO>() {
	   
	        @Override
	        public void onSelection(SelectionEvent<PlatformDTO> event) {
	          CellSelectionEvent<PlatformDTO> sel = (CellSelectionEvent<PlatformDTO>) event;
	          WeeklyResourcePlan p = store.get(sel.getContext().getIndex());
	          p.setPlatform(event.getSelectedItem());
	          log.info("Platform Selected"+ p.getId() + " selected " + event.getSelectedItem());
	        }
	      });
	    platformCombo.setTriggerAction(TriggerAction.ALL);
	    platformCombo.setForceSelection(true);
	    platformCombo.setWidth(110);
	    
	    EmployeeServiceAsync employeeService = GWT.create(EmployeeService.class);
		final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Loading data. Please wait...");
		final AsyncCallback<List<PlatformDTO>> callback = new AsyncCallback<List<PlatformDTO>>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert = new AlertMessageBox("Error",
						caught.getMessage());
				alert.show();
			}

			public void onSuccess(List<PlatformDTO> result) {
				messageBox.hide();
				platformCombo.getStore().replaceAll(result);
			}
		};
	    employeeService.findAllPlatforms(callback);
	    messageBox.auto();
		messageBox.show();
	}
		  
}
