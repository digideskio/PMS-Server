package com.media2359.euphoria.view.client.project;

import java.text.ParseException;

import com.sencha.gxt.widget.core.client.button.TextButton;
import com.media2359.euphoria.view.client.core.ProjectStatus;
import com.media2359.euphoria.view.client.employee.ButtonSelectHandler;
import com.media2359.euphoria.view.client.employee.EmployeeDetailsWindow;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
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

public class AddProjectWindow {
	
	private Component projectName,description,company,billingAddress,contactPerson,startDate,endDate,mandaysRequired,status;
	private  ProjectPresenter projectPresenter;
	private   static final String SAVE_BUTTON_TEXT = "Submit",CANCEL_BUTTON_TEXT = "Cancel";
	private Window window;
	private FormPanel formPanel;


	public AddProjectWindow(ProjectPresenter projectPresenter){
		this.projectPresenter=projectPresenter;
		createNewWindow();
	}


	private void createNewWindow() {

		projectName=createTextField("Project Name",30, 1, null);
		description = createTextArea("Project Description", 100, 1, null);
		company = createTextField("Company", 50, 1, null);
		billingAddress = createTextArea("Billing Address", 200, 1, null);
		contactPerson = createTextField("Contact Person", 40, 1, null);
		startDate = createStartDate();
		endDate = createEndDate();
		mandaysRequired=createManDays();
		status=createStatus();
		
			
		VerticalLayoutContainer p = new VerticalLayoutContainer();
		p.add(new FieldLabel(projectName, "Project Name"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(description, "Project Description"), new VerticalLayoutData(1, 70));
		p.add(new FieldLabel(company, "Company"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(billingAddress, "Billing Address"), new VerticalLayoutData(1, 70));
		p.add(new FieldLabel(contactPerson, "Contact Person"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(startDate, "Start Date"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(endDate, "End Date"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(mandaysRequired, "Project Man-days"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(status, "Project Status"), new VerticalLayoutData(1, 35));
		
		formPanel = new FormPanel();
		formPanel.add(p);
		
     	FramedPanel fPanel = new FramedPanel();
		fPanel.setWidth(450);
		fPanel.setHeaderVisible(false);
		fPanel.setBodyStyle("background: none; padding: 5px");
		fPanel.add(formPanel);
		
		TextButton saveButton = new TextButton(SAVE_BUTTON_TEXT);
		TextButton cancelButton = new TextButton(CANCEL_BUTTON_TEXT);
		
		fPanel.addButton(saveButton);
		fPanel.addButton(cancelButton);
		fPanel.setButtonAlign(BoxLayoutPack.CENTER);

		window = new Window();
		window.setPixelSize(500, 650);
		window.setModal(true);
		window.setBlinkModal(true);
		window.setHeadingText("Add New Project");
		window.add(fPanel);
		window.setFocusWidget(cancelButton);
		
		saveButton.addSelectHandler(new ButtonSelectHandler(this));
	}
	
	
	protected void show(){		  
	  window.show();
	}
	
	
	private Component createTextField(String emptyText,int maxLength,int minLength, AbstractValidator additionalValidator){
		  TextField field = new TextField();
		  field.setAllowBlank(false);
		  field.setEmptyText(emptyText);
		  field.addValidator(new MaxLengthValidator(maxLength));
		  field.addValidator(new MinLengthValidator(minLength));
		  if(additionalValidator != null)
			  field.addValidator(additionalValidator);
		  return field;
	}
	
	
	private Component createTextArea(String emptyText,int maxLength,int minLength, AbstractValidator additionalValidator){
		  TextArea field = new TextArea();
		  field.setAllowBlank(false);
		  field.setEmptyText(emptyText);
		  field.addValidator(new MaxLengthValidator(maxLength));
		  field.addValidator(new MinLengthValidator(minLength));
		  if(additionalValidator != null)
			  field.addValidator(additionalValidator);
		  return field;
	}
	

	private Component createStartDate() {
		  DateField field = new DateField();
		  field.setEmptyText("Select Start Date");
		  field.setAllowBlank(false);
		  return field;
	}

	private Component createEndDate() {
		  DateField field = new DateField();
		  field.setEmptyText("Select End Date");
		  return field;
	}
	
	public Component createStatus() {
		SimpleComboBox combo = new SimpleComboBox<ProjectStatus>(
				new StringLabelProvider<ProjectStatus>());
	  combo.setPropertyEditor(new PropertyEditor<ProjectStatus>() {

			@Override
			public ProjectStatus parse(CharSequence text) throws ParseException {
				return ProjectStatus.parseString(text.toString());
			}

			@Override
			public String render(ProjectStatus object) {
				return object == null ? ProjectStatus.ACTIVE.toString() : object
						.toString();
			}
		});
	  combo.setAllowBlank(false);
	  combo.setEmptyText("Select Project Status");
	  combo.setForceSelection(true);
	  combo.setTriggerAction(TriggerAction.ALL);
      combo.add(ProjectStatus.getAllStatus());
      return combo;
		
	}
	
	public Component createManDays() {
		  NumberField field= new NumberField<Long>(new LongPropertyEditor());
		  field.setAllowBlank(false);
		  field.setEmptyText("Projected ManDays");
		  field.addValidator(new MaxNumberValidator<Long>((long)99999999));
		  return field;
		
	}


	
	public ProjectPresenter getProjectPresenter() {
		return projectPresenter;
	}


	public void setProjectPresenter(ProjectPresenter projectPresenter) {
		this.projectPresenter = projectPresenter;
	}

	
	public Window getWindow() {
		return window;
	}


	public void setWindow(Window window) {
		this.window = window;
	}
	
	public Component getProjectName() {
		return projectName;
	}


	public void setProjectName(Component projectName) {
		this.projectName = projectName;
	}


	public Component getDescription() {
		return description;
	}


	public void setDescription(Component description) {
		this.description = description;
	}


	public Component getCompany() {
		return company;
	}


	public void setCompany(Component company) {
		this.company = company;
	}


	public Component getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(Component billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Component getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(Component contactPerson) {
		this.contactPerson = contactPerson;
	}


	public Component getStartDate() {
		return startDate;
	}


	public void setStartDate(Component startDate) {
		this.startDate = startDate;
	}


	public Component getEndDate() {
		return endDate;
	}


	public void setEndDate(Component endDate) {
		this.endDate = endDate;
	}


	public Component getMandaysRequired() {
		return mandaysRequired;
	}


	public void setMandaysRequired(Component mandaysRequired) {
		this.mandaysRequired = mandaysRequired;
	}


	public Component getStatus() {
		return status;
	}


	public void setStatus(Component status) {
		this.status = status;
	}


	public FormPanel getFormPanel() {
		return formPanel;
	}


	public void setFormPanel(FormPanel formPanel) {
		this.formPanel = formPanel;
	}

	class ButtonSelectHandler implements SelectHandler{

		private AddProjectWindow sourceWindow;
		
		public ButtonSelectHandler(AddProjectWindow addProjectWindow){
			this.sourceWindow=addProjectWindow;
		}
		/* (non-Javadoc)
		 * @see com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler#onSelect(com.sencha.gxt.widget.core.client.event.SelectEvent)
		 */
		@Override
		public void onSelect(SelectEvent event) {

	  	  TextButton btn = (TextButton)event.getSource();
	  	  if(btn.getText().equals(AddProjectWindow.CANCEL_BUTTON_TEXT))
	  		sourceWindow.getProjectPresenter().cancelButtonClicked(sourceWindow);
	  	  else if(btn.getText().equals(AddProjectWindow.SAVE_BUTTON_TEXT))
	  		sourceWindow.getProjectPresenter().saveButtonClicked(sourceWindow);			
		}

	}
	
}



