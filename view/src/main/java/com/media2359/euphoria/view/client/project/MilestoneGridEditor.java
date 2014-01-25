package com.media2359.euphoria.view.client.project;
  import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.media2359.euphoria.view.client.core.AddCell;
import com.media2359.euphoria.view.client.core.Alert;
import com.media2359.euphoria.view.client.core.DeleteCell;
import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.data.client.editor.ListStoreEditor;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridInlineEditing;
import com.sencha.gxt.widget.core.client.info.Info;
	
  public class MilestoneGridEditor extends Composite implements IsEditor<Editor<List<ProjectMilestoneDTO>>> {
    interface MilestoneProperties extends PropertyAccess<ProjectMilestoneDTO> {
      ModelKeyProvider<ProjectMilestoneDTO> milestoneKey();
      ValueProvider<ProjectMilestoneDTO, String> milestoneDesc();
      ValueProvider<ProjectMilestoneDTO, Date> milestoneDate();
    }
    private static final MilestoneProperties milestoneProperties = GWT.create(MilestoneProperties.class);
	  
    private ListStore<ProjectMilestoneDTO> listStore;
	
    public MilestoneGridEditor() {
      listStore = new ListStore<ProjectMilestoneDTO>(milestoneProperties.milestoneKey());
	
      ColumnConfig<ProjectMilestoneDTO, String> colDescription = new ColumnConfig<ProjectMilestoneDTO, String>(milestoneProperties.milestoneDesc(), 150, "Description");
      DateCell dateCell = new DateCell(DateTimeFormat.getFormat("yyyy-MM-dd"));
      
      ColumnConfig<ProjectMilestoneDTO, Date> colDate = new ColumnConfig<ProjectMilestoneDTO, Date>(milestoneProperties.milestoneDate(), 90, "Date");
      colDate.setCell(dateCell);
      
      ColumnConfig<ProjectMilestoneDTO, String> colAdd= new ColumnConfig<ProjectMilestoneDTO, String>(milestoneProperties.milestoneDesc(), 50, "Add");
      ColumnConfig<ProjectMilestoneDTO, String> colDelete= new ColumnConfig<ProjectMilestoneDTO, String>(milestoneProperties.milestoneDesc(), 50, "Delete");
      
      colAdd.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      colDelete.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	  populateAddButton(colAdd);
	  populateDeleteButton(colDelete);
		
      List<ColumnConfig<ProjectMilestoneDTO, ?>> columns = new ArrayList<ColumnConfig<ProjectMilestoneDTO, ?>>();
      columns.add(colDescription);
      columns.add(colDate);
      columns.add(colAdd);
      columns.add(colDelete);
      ColumnModel<ProjectMilestoneDTO> cm = new ColumnModel<ProjectMilestoneDTO>(columns);
	
      Grid<ProjectMilestoneDTO> grid = new Grid<ProjectMilestoneDTO>(listStore, cm);
      grid.setPixelSize(200, 200);
	
      GridEditing<ProjectMilestoneDTO> editing = new GridInlineEditing<ProjectMilestoneDTO>(grid);
      TextField textField = new TextField();
      editing.addEditor(colDescription,textField );
      
      DateField dateField = new DateField(new DateTimePropertyEditor(
    	        DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
      dateField.setClearValueOnParseError(false);
      editing.addEditor(colDate, dateField);
	
      initWidget(grid);
	    
      grid.getView().setAutoExpandColumn(colDescription);
    }
	
    public MilestoneGridEditor(Set<ProjectMilestoneDTO> projectMilestone) {
		this();
		if(projectMilestone == null || projectMilestone.size()<1){
			addEmptyRow();
			return;
		}
		List<ProjectMilestoneDTO> milestones = new ArrayList<ProjectMilestoneDTO>();
		milestones.addAll(projectMilestone);
		
		listStore.replaceAll(milestones);
		
	}

	@Override
    public Editor<List<ProjectMilestoneDTO>> asEditor() {
      return new ListStoreEditor<ProjectMilestoneDTO>(listStore);
    }
    
    public void addMilestone(ProjectMilestoneDTO milestone){
    	listStore.add(milestone);
    }
    
    
    public void removeMilestone(ProjectMilestoneDTO milestone){
    	listStore.remove(milestone);
    }
    
    public void addEmptyRow(){
    	ProjectMilestoneDTO milestone = new ProjectMilestoneDTO();
    	milestone.setMilestoneDate(new Date());
    	listStore.add(milestone);
    }
    
    public Set<ProjectMilestoneDTO> getMileStoneDTOs(){
    	listStore.commitChanges();
    	return new HashSet<ProjectMilestoneDTO>(listStore.getAll());
    }


	private void populateAddButton(ColumnConfig addCol){		

		addCol.setColumnTextClassName(CommonStyles.get().inlineBlock());
		addCol.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 1px 3px;"));
		AddCell image = new AddCell();

		image.addSelectHandler(new SelectHandler() {
			
			public void onSelect(SelectEvent event) {
				Context c = event.getContext();
		        int row = c.getIndex();
		        
	
		        ProjectMilestoneDTO milestone = new ProjectMilestoneDTO();
		    	milestone.setMilestoneDate(new Date());
				listStore.add(row+1,milestone);
		        
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
		        	new Alert("Warning!", "Atleast 1 milestone required");
		        	return;
		        }
				ProjectMilestoneDTO p = listStore.get(row);
				removeMilestone(p);
			}
		});
		delCol.setCell(image);
		
	}
    
  }