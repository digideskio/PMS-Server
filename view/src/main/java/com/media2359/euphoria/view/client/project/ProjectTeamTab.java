package com.media2359.euphoria.view.client.project;
  import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.media2359.euphoria.view.client.core.AddCell;
import com.media2359.euphoria.view.client.core.Alert;
import com.media2359.euphoria.view.client.core.DeleteCell;
import com.media2359.euphoria.view.client.core.EmployeeDTOProperties;
import com.media2359.euphoria.view.client.core.PlatformDTOProperties;
import com.media2359.euphoria.view.client.core.ProjStatus;
import com.media2359.euphoria.view.client.core.ProjectStatus;
import com.media2359.euphoria.view.client.core.ProjectTeamRole;
import com.media2359.euphoria.view.client.core.ProjectTeamRoles;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.manpower.WeeklyResourcePlan;
import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.data.client.editor.ListStoreEditor;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.CellSelectionEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.LongPropertyEditor;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridInlineEditing;
import com.sencha.gxt.widget.core.client.info.Info;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;	
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;
import com.media2359.euphoria.view.server.employee.EmployeeServiceAsync;
import com.media2359.euphoria.view.server.project.ProjectTeamService;
import com.media2359.euphoria.view.server.project.ProjectTeamServiceAsync;
  public class ProjectTeamTab  {
    interface ProjectTeamProperties extends PropertyAccess<ProjectTeamItem> {
      ModelKeyProvider<ProjectTeamItem> projectTeamKey();
      
      ValueProvider<ProjectTeamItem, PlatformDTO> platformDto();
      ValueProvider<ProjectTeamItem, EmployeeDTO> projectTeamMember();
      ValueProvider<ProjectTeamItem, ProjectTeamRole> role();
      ValueProvider<ProjectTeamItem, Integer> manDayRate();
      ValueProvider<ProjectTeamItem, ProjectStatus> status();
    }
    
    interface ProjectTeamRoleProperties extends PropertyAccess<ProjectTeamRole> {
        ModelKeyProvider<ProjectTeamRole> id();
        ValueProvider<ProjectTeamRole, ProjectTeamRoles> projectTeamRoles();
    }
    
    interface ProjectStatusProperties extends PropertyAccess<ProjStatus> {
        ModelKeyProvider<ProjStatus> id();
        ValueProvider<ProjStatus, ProjectStatus> status();
    }
    
    private static final ProjectTeamProperties props = GWT.create(ProjectTeamProperties.class);
    private static final PlatformDTOProperties platformProps = GWT.create(PlatformDTOProperties.class);
    private static final EmployeeDTOProperties teamMemberProps = GWT.create(EmployeeDTOProperties.class);
    private static final ProjectTeamRoleProperties roleProps = GWT.create(ProjectTeamRoleProperties.class);
    private static final ProjectStatusProperties statusProps = GWT.create(ProjectStatusProperties.class);
    
    private static final EmployeeServiceAsync employeeService = GWT.create(EmployeeService.class);
    private static final ProjectTeamServiceAsync projectTeamService = GWT.create(ProjectTeamService.class);
    
    private ListStore<ProjectTeamItem> teamListStore = null;
    private ListStore<PlatformDTO> platformListStore = null;
    private ListStore<EmployeeDTO>teamMemberListStore = null;
    private ListStore<ProjectTeamRole> roleListStore = null;
    private ListStore<ProjStatus> statusListStore = null;
    
	private VerticalLayoutContainer projectTeamPanel;
    
	private ComboBoxCell<PlatformDTO> platformCombo;
	private ComboBoxCell<EmployeeDTO> teamMemberCombo;
	private ComboBoxCell<ProjectTeamRole> roleCombo;
	private ComboBoxCell<ProjStatus> statusCombo;
	
	
	private ProjectDTO projectDTO;
	private ProjectPresenter projectPresenter;

	Logger log = Logger.getLogger("EuphoriaLogger");
	
    public ProjectTeamTab(ProjectDTO projectDTO,ProjectPresenter projectPresenter) {
      this.projectDTO = projectDTO;
      this.projectPresenter=projectPresenter;
      initUI();
    }
    
    private void initUI(){
    	teamListStore = new ListStore<ProjectTeamItem>(props.projectTeamKey());
        createPlatformCombo();
        createTeamMemberCombo();
        createRoleCombo();
        createStatusCombo();
        ColumnConfig<ProjectTeamItem, PlatformDTO> colPlatform = new ColumnConfig<ProjectTeamItem, PlatformDTO>(props.platformDto(), 110, "Platfrom");
        ColumnConfig<ProjectTeamItem, EmployeeDTO> collTeamMember = new ColumnConfig<ProjectTeamItem, EmployeeDTO>(props.projectTeamMember(), 110, "Member");
        ColumnConfig<ProjectTeamItem, ProjectTeamRole> colRole = new ColumnConfig<ProjectTeamItem, ProjectTeamRole>(props.role(),140, "Role");
//        ColumnConfig<ProjectTeamItem, Integer> colManDayRate = new ColumnConfig<ProjectTeamItem, Integer>(props.manDayRate(), 60, "Man Day Rate");
//        ColumnConfig<ProjectTeamItem, ProjectStatus> colStatus = new ColumnConfig<ProjectTeamItem, ProjectStatus>(props.status(), 150, "Status");
        ColumnConfig<ProjectTeamItem, Integer> colAdd= new ColumnConfig<ProjectTeamItem, Integer>(props.manDayRate(), 50, "Add");
        ColumnConfig<ProjectTeamItem, Integer> colDelete= new ColumnConfig<ProjectTeamItem, Integer>(props.manDayRate(), 50, "Delete");
        
        colAdd.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        colDelete.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
  	  	populateAddButton(colAdd);
  	  	populateDeleteButton(colDelete);
  	  	colPlatform.setCell(platformCombo);
  	  	collTeamMember.setCell(teamMemberCombo);
  	  	colRole.setCell(roleCombo);

      
        List<ColumnConfig<ProjectTeamItem, ?>> columns = new ArrayList<ColumnConfig<ProjectTeamItem, ?>>();
        columns.add(colPlatform);
        columns.add(collTeamMember);
        columns.add(colRole);
//        columns.add(colManDayRate);
//        columns.add(colStatus);
        columns.add(colAdd);
        columns.add(colDelete);
        ColumnModel<ProjectTeamItem> cm = new ColumnModel<ProjectTeamItem>(columns);
        
        Grid<ProjectTeamItem> grid = new Grid<ProjectTeamItem>(teamListStore, cm);
        grid.getView().setStripeRows(true);
  	    
        grid.setHeight(600);
        grid.getView().setAutoExpandColumn(colRole);

  	  	
//  	  	GridEditing<ProjectTeamItem> editing = new GridInlineEditing<ProjectTeamItem>(grid);
//  	  	NumberField field= new NumberField<Long>(new LongPropertyEditor());
//  	  	editing.addEditor(colManDayRate,field );
  	  	
  	  	projectTeamPanel = new VerticalLayoutContainer();	  
  	  	projectTeamPanel.add(grid);
  	  	addEmptyRow();
  	  
//        GridEditing<ProjectMilestoneDTO> editing = new GridInlineEditing<ProjectMilestoneDTO>(grid);
//        TextField textField = new TextField();
//        editing.addEditor(colDescription,textField );
//        
//        DateField dateField = new DateField(new DateTimePropertyEditor(
//      	        DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
//        dateField.setClearValueOnParseError(false);
//        editing.addEditor(colDate, dateField);
  //	
//        initWidget(grid);
  	    

    }
//	
//    public ProjectTeamTab(Set<ProjectMilestoneDTO> projectMilestone) {
//		this();
//		if(projectMilestone == null || projectMilestone.size()<1){
//			addEmptyRow();
//			return;
//		}
//		List<ProjectMilestoneDTO> milestones = new ArrayList<ProjectMilestoneDTO>();
//		milestones.addAll(projectMilestone);
//		
//		listStore.replaceAll(milestones);
//		
//	}
//
//	@Override
//    public Editor<List<ProjectMilestoneDTO>> asEditor() {
//      return new ListStoreEditor<ProjectMilestoneDTO>(listStore);
//    }
//    
//    public void addMilestone(ProjectMilestoneDTO milestone){
//    	listStore.add(milestone);
//    }
//    
    

	public void removeProjectTeamItem(ProjectTeamItem p){
    	teamListStore.remove(p);
    }
    
    public void addEmptyRow(){
    	 ProjectTeamItem p = new ProjectTeamItem();
	     teamListStore.add(p);
    }
    
//    public Set<ProjectMilestoneDTO> getMileStoneDTOs(){
//    	listStore.commitChanges();
//    	return new HashSet<ProjectMilestoneDTO>(listStore.getAll());
//    }


	private void populateAddButton(ColumnConfig addCol){		

		addCol.setColumnTextClassName(CommonStyles.get().inlineBlock());
		addCol.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 1px 3px;"));
		AddCell image = new AddCell();

		image.addSelectHandler(new SelectHandler() {
			
			public void onSelect(SelectEvent event) {
				Context c = event.getContext();
		        int row = c.getIndex();
		        
	
		        ProjectTeamItem p = new ProjectTeamItem();
		        teamListStore.add(row+1,p);
		        
			}
		});
		addCol.setCell(image);
		
	}

	private void populateDeleteButton(ColumnConfig delCol){		

		delCol.setColumnTextClassName(CommonStyles.get().inlineBlock());
		delCol.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 1px 3px;"));
		DeleteCell image = new DeleteCell();

		image.addSelectHandler(new SelectHandler() {
			
			public void onSelect(SelectEvent event) {
				Context c = event.getContext();
		        int row = c.getIndex();
		        if(row < 1){
		        	new Alert("Warning!", "Atleast 1 Team Member required");
		        	return;
		        }
		        ProjectTeamItem p = teamListStore.get(row);
				removeProjectTeamItem(p);
			}
		});
		delCol.setCell(image);
		
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
	          ProjectTeamItem p = teamListStore.get(sel.getContext().getIndex());
	          p.setPlatformDto(event.getSelectedItem());
	          populateTeamMemberCombo(event.getSelectedItem());
	        }
	      });
	    platformCombo.setTriggerAction(TriggerAction.ALL);
	    platformCombo.setForceSelection(true);
	    platformCombo.setWidth(90);
	    
	    populatePlatfromCombo();
	}

	
	private void createTeamMemberCombo(){
		
		teamMemberListStore = new ListStore<EmployeeDTO>(teamMemberProps.employeeKey());
		 teamMemberCombo = new ComboBoxCell<EmployeeDTO>(teamMemberListStore, new LabelProvider<EmployeeDTO>() {
		        @Override
		        public String getLabel(EmployeeDTO item) {
		          return item.getName();
		        }
		      });
		    
		 teamMemberCombo.addSelectionHandler(new SelectionHandler<EmployeeDTO>() {
		   
		        @Override
		        public void onSelection(SelectionEvent<EmployeeDTO> event) {
		          CellSelectionEvent<EmployeeDTO> sel = (CellSelectionEvent<EmployeeDTO>) event;
		          ProjectTeamItem p = teamListStore.get(sel.getContext().getIndex());
		          p.setProjectTeamMember(event.getSelectedItem());
		        }
		      });
		 teamMemberCombo.setTriggerAction(TriggerAction.ALL);
		 teamMemberCombo.setForceSelection(true);
		 teamMemberCombo.setWidth(90);
		
	}
	
	private void createRoleCombo(){
		

		 roleListStore= new ListStore<ProjectTeamRole>(roleProps.id());
		 roleListStore.replaceAll(ProjectTeamRoles.getAllRole());
		 roleCombo = new ComboBoxCell<ProjectTeamRole>(roleListStore, new LabelProvider<ProjectTeamRole>() {
		        @Override
		        public String getLabel(ProjectTeamRole item) {
		          return item.getProjectTeamRoles().toString();
		        }
		      });
		    
		 roleCombo.addSelectionHandler(new SelectionHandler<ProjectTeamRole>() {
		   
		        @Override
		        public void onSelection(SelectionEvent<ProjectTeamRole> event) {
		          CellSelectionEvent<ProjectTeamRole> sel = (CellSelectionEvent<ProjectTeamRole>) event;
		          ProjectTeamItem p = teamListStore.get(sel.getContext().getIndex());
		          p.setRole(event.getSelectedItem());
		        }
		      });
		 roleCombo.setTriggerAction(TriggerAction.ALL);
		 roleCombo.setForceSelection(true);
		 roleCombo.setWidth(120);
		
	}
	
	private void createStatusCombo(){
		
		 statusListStore= new ListStore<ProjStatus>(statusProps.id());
		 statusListStore.replaceAll(ProjectStatus.getAllStat());
		 statusCombo = new ComboBoxCell<ProjStatus>(statusListStore, new LabelProvider<ProjStatus>() {
		        @Override
		        public String getLabel(ProjStatus item) {
		          return item.getStatus().toString();
		        }
		      });
		    
		 statusCombo.addSelectionHandler(new SelectionHandler<ProjStatus>() {
		   
		        @Override
		        public void onSelection(SelectionEvent<ProjStatus> event) {
		          CellSelectionEvent<ProjStatus> sel = (CellSelectionEvent<ProjStatus>) event;
		          ProjectTeamItem p = teamListStore.get(sel.getContext().getIndex());
		          p.setStatus(event.getSelectedItem().getStatus());
		        }
		      });
		 roleCombo.setTriggerAction(TriggerAction.ALL);
		 roleCombo.setForceSelection(true);
		 roleCombo.setWidth(90);
				
	}
	
	private void populatePlatfromCombo(){
		   
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
	
   private void populateTeamMemberCombo(PlatformDTO platformDTO){

	   final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Loading data. Please wait...");
		final AsyncCallback<List<EmployeeDTO>> callback = new AsyncCallback<List<EmployeeDTO>>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert = new AlertMessageBox("Error",
						caught.getMessage());
			
				caught.printStackTrace();
				alert.show();
			}

			public void onSuccess(List<EmployeeDTO> result) {
				messageBox.hide();
				teamMemberCombo.getStore().replaceAll(result);
				log.info("#!#!#!#!#!# EmployeeListReturned is "+result);
			}
		};
//		final AsyncCallback<EmployeeListResponse> callback = new AsyncCallback<EmployeeListResponse>>() {
//
//			public void onFailure(Throwable caught) {
//				messageBox.hide();
//				AlertMessageBox alert = new AlertMessageBox("Error",
//						caught.getMessage());
//			
//				caught.printStackTrace();
//				alert.show();
//			}
//
//			public void onSuccess(EmployeeListResponse result) {
//				messageBox.hide();
//				teamMemberCombo.getStore().replaceAll(result.getEmployees());
//				log.info("#!#!#!#!#!# EmployeeListReturned is "+result.getEmployees());
//			}
//		};
		log.info("#!#!#!#!#!# Requesting Employees with: "+platformDTO);
	    employeeService.getEmployeesByPlatform(platformDTO, callback);
//		employeeService.getAllEmployees(new EmployeeListRequest(), callback);
	    messageBox.auto();
		messageBox.show();

   }
   
   private void populateInitialData(){
	  
	   final AutoProgressMessageBox messageBox = new AutoProgressMessageBox(
				"Progress", "Loading data. Please wait...");
		final AsyncCallback<List<ProjectTeamDTO>> callback = new AsyncCallback<List<ProjectTeamDTO>>() {

			public void onFailure(Throwable caught) {
				messageBox.hide();
				AlertMessageBox alert = new AlertMessageBox("Error",
						caught.getMessage());
			
				caught.printStackTrace();
				alert.show();
			}

			public void onSuccess(List<ProjectTeamDTO> result) {
				messageBox.hide();
				if(result==null || result.size()<1){
					log.info("Empty Project Team Received. Hence adding empty row");
					addEmptyRow();
					return;
				}
//				for()
				log.info("#!#!#!#!#!# EmployeeListReturned is "+result);
			}
		};
		
//		projectTeamService.getProjectTeam(projectDTO, callback);
   }
   public VerticalLayoutContainer getProjectTeamPanel() {
		return projectTeamPanel;
	}

	public void setProjectTeamPanel(VerticalLayoutContainer projectTeamPanel) {
		this.projectTeamPanel = projectTeamPanel;
	}


   
  }