package com.media2359.euphoria.view.client.project;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import com.sencha.gxt.widget.core.client.button.TextButton;
import com.media2359.euphoria.view.client.core.Alert;
import com.media2359.euphoria.view.client.core.ProjectStatus;
import com.media2359.euphoria.view.client.employee.ButtonSelectHandler;
import com.media2359.euphoria.view.client.employee.EmployeeDetailsWindow;
import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.ListView;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.LongPropertyEditor;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.AbstractValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxLengthValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxNumberValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;

public class ProjectDetailsWindow {
	
	private  ProjectPresenter projectPresenter;

	private   static final String SAVE_BUTTON_TEXT = "Save",CLOSE_BUTTON_TEXT = "Close";
	private Window window;

    private ProjectDTO projectDTO;
    private TabPanel tabbedPanel;
    private ProjectDetailsTab projectDetailsTab;
    
	public ProjectDetailsWindow(ProjectPresenter projectPresenter,ProjectDTO projectDTO){
		this.projectDTO=projectDTO;
		this.projectPresenter=projectPresenter;
		createNewWindow();
	}


	private void createNewWindow() {
		
		tabbedPanel = new TabPanel();
		tabbedPanel.setPixelSize(600, 250);
		tabbedPanel.setAnimScroll(true);
		tabbedPanel.setTabScroll(true);
		tabbedPanel.setCloseContextMenu(true);
	      
		VerticalLayoutContainer p1 = new VerticalLayoutContainer();
		VerticalLayoutContainer p2 = new VerticalLayoutContainer();
		projectDetailsTab = new ProjectDetailsTab(projectDTO);
		tabbedPanel.add(projectDetailsTab.getFormPanel(),"Project Details");
		tabbedPanel.add(p1,"Project Team");
		
		FramedPanel fPanel = new FramedPanel();
		fPanel.setWidth(450);
		fPanel.setHeaderVisible(false);
		fPanel.setBodyStyle("background: none; padding: 5px");
		fPanel.add(tabbedPanel);
		
		TextButton saveButton = new TextButton(SAVE_BUTTON_TEXT);
		TextButton closeButton = new TextButton(CLOSE_BUTTON_TEXT);
		
		fPanel.addButton(saveButton);
		fPanel.addButton(closeButton);
		fPanel.setButtonAlign(BoxLayoutPack.CENTER);

		window = new Window();
		window.setPixelSize(500,650);
		window.setModal(true);
		window.setBlinkModal(true);
		window.setBorders(false);
		window.add(fPanel);
		window.setFocusWidget(closeButton);
		window.setBodyStyle("background: none; padding: 0px");
		
		window.addHideHandler(new HideHandler() {
			
			@Override
			public void onHide(HideEvent event) {
				projectPresenter.loadProjectsFromDB(false);
				
			}
		});

		
		saveButton.addSelectHandler(new ButtonSelectHandler(this));
		closeButton.addSelectHandler(new ButtonSelectHandler(this));

	}
	
	
	public Window getWindow() {
		return window;
	}


	public void setWindow(Window window) {
		this.window = window;
	}


	public TabPanel getTabbedPanel() {
		return tabbedPanel;
	}


	public void setTabbedPanel(TabPanel tabbedPanel) {
		this.tabbedPanel = tabbedPanel;
	}


	protected void show(){		  
	
	  window.show();
	}
	public ProjectPresenter getProjectPresenter() {
		return projectPresenter;
	}


	public void setProjectPresenter(ProjectPresenter projectPresenter) {
		this.projectPresenter = projectPresenter;
	}
	
	

	class ButtonSelectHandler implements SelectHandler{

		private ProjectDetailsWindow sourceWindow;
		public ButtonSelectHandler(ProjectDetailsWindow addProjectWindow){
			this.sourceWindow=addProjectWindow;
		}
		/* (non-Javadoc)
		 * @see com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler#onSelect(com.sencha.gxt.widget.core.client.event.SelectEvent)
		 */
		@Override
		public void onSelect(SelectEvent event) {

	  	  TextButton btn = (TextButton)event.getSource();
	  	  if(btn.getText().equals(ProjectDetailsWindow.CLOSE_BUTTON_TEXT))
	  		sourceWindow.getProjectPresenter().hideWindow(sourceWindow.getWindow());
	  	  else if(btn.getText().equals(ProjectDetailsWindow.SAVE_BUTTON_TEXT)){
		      if(sourceWindow.getTabbedPanel().getActiveWidget().equals(projectDetailsTab.getFormPanel())){
		    	  sourceWindow.getProjectPresenter().modifyProject(projectDetailsTab.getProjectDTO());
		      }
	  	  }
		}

	}
	
}



