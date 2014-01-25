package com.media2359.euphoria.view.client.project;

import java.text.ParseException;
import java.util.Date;

import com.media2359.euphoria.view.client.core.ProjectStatus;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.LongPropertyEditor;
import com.sencha.gxt.widget.core.client.form.validator.AbstractValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxLengthValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxNumberValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinLengthValidator;

public class ProjectDetailsTab {
	
	private Component projectName,description,company,billingAddress,contactPerson,startDate,endDate,manDaysLeft,status;
	private FormPanel formPanel;
	private MilestoneGridEditor mileStones;
	private ProjectDTO projectDTO;
	
	public ProjectDetailsTab(ProjectDTO projectDTO){
		this.projectDTO = projectDTO;
		createNewTab();
	}

	private void createNewTab(){
		projectName=createTextField(projectDTO.getName(),30, 1, null);
		description = createTextArea(projectDTO.getDescription(), 100, 1, null);
		company = createTextField(projectDTO.getCompany(), 50, 1, null);
		billingAddress = createTextArea(projectDTO.getBillingAddr(), 200, 1, null);
		contactPerson = createTextField(projectDTO.getContactPerson(), 40, 1, null);
		startDate = createStartDate(projectDTO.getStartDate());
		endDate = createEndDate(projectDTO.getEndDate());
		manDaysLeft=createManDays(projectDTO.getManDaysLeft());
		status=createStatus(projectDTO.getStatus());
		mileStones = new MilestoneGridEditor(projectDTO.getProjectMilestone());
			
		VerticalLayoutContainer p = new VerticalLayoutContainer();
		p.add(new FieldLabel(projectName, "Project Name"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(description, "Project Description"), new VerticalLayoutData(1, 70));
		p.add(new FieldLabel(company, "Company"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(billingAddress, "Billing Address"), new VerticalLayoutData(1, 70));
		p.add(new FieldLabel(contactPerson, "Contact Person"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(startDate, "Start Date"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(endDate, "End Date"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(manDaysLeft, "Mandays Left"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(status, "Project Status"), new VerticalLayoutData(1, 35));
		p.add(new FieldLabel(mileStones, "Milestones"), new VerticalLayoutData(1, 100));
		formPanel = new FormPanel();
		formPanel.add(p);

	}
	
	private Component createTextField(String text,int maxLength,int minLength, AbstractValidator additionalValidator){
		  TextField field = new TextField();
		  field.setAllowBlank(false);
		  field.setText(text);
//		  field.addValidator(new MaxLengthValidator(maxLength));
//		  field.addValidator(new MinLengthValidator(minLength));
//		  if(additionalValidator != null)
//			  field.addValidator(additionalValidator);
		  return field;
	}
	

	
	private Component createTextArea(String emptyText,int maxLength,int minLength, AbstractValidator additionalValidator){
		  TextArea field = new TextArea();
		  field.setAllowBlank(false);
		  field.setText(emptyText);
//		  field.addValidator(new MaxLengthValidator(maxLength));
//		  field.addValidator(new MinLengthValidator(minLength));
//		  if(additionalValidator != null)
//			  field.addValidator(additionalValidator);
		  return field;
	}
	

	private Component createStartDate(Date startDate) {
		  DateField field = new DateField();
		  field.setEmptyText("Start Start Date");
		  field.setAllowBlank(false);
		  field.setValue(startDate);
		  return field;
	}

	private Component createEndDate(Date endDate) {
		  DateField field = new DateField();
		  field.setEmptyText("Select End Date");
		  if(endDate != null)
			  field.setValue(endDate);
		  return field;
	}
	
	public Component createStatus(String status) {
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
      combo.setValue(ProjectStatus.parseString(status));
      return combo;
		
	}
	
	public Component createManDays(Double mandays) {
		  NumberField field= new NumberField<Long>(new LongPropertyEditor());
		  field.setAllowBlank(false);
		  field.setEmptyText("Projected ManDays");
		  field.addValidator(new MaxNumberValidator<Long>((long)99999999));
		  field.setValue(mandays);
		  field.setEditable(false);
//		  field.setEnabled(false);
		  return field;
		
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
		return manDaysLeft;
	}


	public void setMandaysRequired(Component mandaysRequired) {
		this.manDaysLeft = mandaysRequired;
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
	
	public  ProjectDTO getProjectDTO(){
		projectDTO.setName(((TextField)getProjectName()).getText());
		projectDTO.setDescription(((TextArea)getDescription()).getText());
		projectDTO.setManDaysLeft(Double.parseDouble(((NumberField)getMandaysRequired()).getText()));
		projectDTO.setCompany(((TextField)getCompany()).getText());
		projectDTO.setBillingAddr(((TextArea)getBillingAddress()).getText());
		projectDTO.setContactPerson(((TextField)getContactPerson()).getText());
		projectDTO.setStartDate(((DateField)getStartDate()).getValue());
		projectDTO.setEndDate(((DateField)getEndDate()).getValue());
		projectDTO.setStatus(((SimpleComboBox)getStatus()).getText());
		projectDTO.setProjectMilestone(mileStones.getMileStoneDTOs());
		return projectDTO;
	}
}