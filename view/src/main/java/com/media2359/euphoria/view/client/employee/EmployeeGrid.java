/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.employee;

/**
 * EmployeeGrid
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.media2359.euphoria.view.client.core.DeleteCell;
import com.media2359.euphoria.view.client.core.EditCell;
import com.media2359.euphoria.view.client.core.ViewCell;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.event.CellClickEvent;
import com.sencha.gxt.widget.core.client.event.CellClickEvent.CellClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.grid.filters.GridFilters;
import com.sencha.gxt.widget.core.client.grid.filters.StringFilter;
import com.sencha.gxt.widget.core.client.info.Info;

public class EmployeeGrid extends Composite {
	private GridView<EmployeeDTO> gridView;
	private Grid<EmployeeDTO> grid;
	private ListStore<EmployeeDTO> listStore;
	private EmployeePresenter employeePresenter;

	Logger log = Logger.getLogger("EuphoriaLogger");
	
	// Property access definitions for the values in the Project object
	public interface GridProperties extends PropertyAccess<EmployeeDTO> {
		@Path("employeeKey")
		ModelKeyProvider<EmployeeDTO> employeeKey();
		
		ValueProvider<EmployeeDTO, String> name();
		ValueProvider<EmployeeDTO, String> mobile();		
		ValueProvider<EmployeeDTO, String> personalEmail();		
		ValueProvider<EmployeeDTO, String> companyEmail();		
		ValueProvider<EmployeeDTO, String> designation();		
		ValueProvider<EmployeeDTO, String> platforms();		
		ValueProvider<EmployeeDTO, String> employmentType();
	}

	// Setup the property access definitions for the values for the grid columns
	public static GridProperties gridProperties = GWT
			.create(GridProperties.class);

	public EmployeeGrid() {
		
		listStore = new ListStore<EmployeeDTO>(gridProperties.employeeKey());

		ColumnConfig<EmployeeDTO, String> nameCol = new ColumnConfig<EmployeeDTO, String>(
				gridProperties.name(), 150, "Name");
		ColumnConfig<EmployeeDTO, String> mobileCol = new ColumnConfig<EmployeeDTO, String>(
				gridProperties.mobile(), 150, "Mobile");
		ColumnConfig<EmployeeDTO, String> emailCol = new ColumnConfig<EmployeeDTO, String>(
				gridProperties.companyEmail(), 300, "Email Address");
		ColumnConfig<EmployeeDTO, String> platformsCol = new ColumnConfig<EmployeeDTO, String>(
				gridProperties.platforms(), 300, "Platforrm");
		ColumnConfig designationCol = new ColumnConfig<EmployeeDTO, String>(
				gridProperties.designation(), 150, "Designation");
		ColumnConfig<EmployeeDTO, String> editCol = new ColumnConfig<EmployeeDTO, String>(
				gridProperties.name(),100, "Edit");
		ColumnConfig<EmployeeDTO, String> delCol = new ColumnConfig<EmployeeDTO, String>(
				gridProperties.name(),100, "Delete");
		
		
		editCol.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		delCol.setAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		populateEditButton(editCol);
		populateDeleteButton(delCol);
		  
		List<ColumnConfig<EmployeeDTO, ?>> columns = new ArrayList<ColumnConfig<EmployeeDTO, ?>>();
		columns.add(nameCol);
		columns.add(mobileCol);
		columns.add(emailCol);
		columns.add(platformsCol);
		columns.add(designationCol);
		columns.add(editCol);
		columns.add(delCol);
		ColumnModel<EmployeeDTO> columnModel = new ColumnModel<EmployeeDTO>(columns);
		
		gridView = new GridView<EmployeeDTO>();
		gridView.setAutoFill(true);

		grid = new Grid<EmployeeDTO>(listStore, columnModel, gridView);
		grid.setWidth("100%");
		grid.getView().setStripeRows(true);
//		grid.setHeight(600);
		grid.addCellClickHandler(new GridCellClickHandler());
		initWidget(grid);
		addFilters();
	}
	
	
	private void populateEditButton(ColumnConfig editCol){		

		editCol.setColumnTextClassName(CommonStyles.get().inlineBlock());
		editCol.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 1px 3px;"));
		EditCell image = new EditCell();

		image.addSelectHandler(new SelectHandler() {
			
			public void onSelect(SelectEvent event) {
				
				employeePresenter.editEmployeeDetailsButtonClicked(event,listStore);
				
			}
		});
		editCol.setCell(image);
		
	}

	private void populateDeleteButton(ColumnConfig delCol){		

		delCol.setColumnTextClassName(CommonStyles.get().inlineBlock());
		delCol.setColumnTextStyle(SafeStylesUtils.fromTrustedString("padding: 1px 3px;"));
		DeleteCell image = new DeleteCell();

		image.addSelectHandler(new SelectHandler() {
			
			public void onSelect(SelectEvent event) {
				
				employeePresenter.deleteEmployeeDetailsButtonClicked(event,listStore);
				
			}
		});
		delCol.setCell(image);
		
	}

	
	private void addFilters(){

		StringFilter<EmployeeDTO> nameFilter = new StringFilter<EmployeeDTO>(gridProperties.name());
		StringFilter<EmployeeDTO> platformFilter = new StringFilter<EmployeeDTO>(gridProperties.platforms());
		StringFilter<EmployeeDTO> designationFilter = new StringFilter<EmployeeDTO>(gridProperties.designation());
		GridFilters<EmployeeDTO> filters = new GridFilters<EmployeeDTO>();
		filters.removeAll();
		filters.initPlugin(grid);
		filters.setLocal(true);
		filters.addFilter(nameFilter);
		filters.addFilter(platformFilter);
		filters.addFilter(designationFilter);
	}

	public void populateData(List<EmployeeDTO> employees) {
		
			listStore.replaceAll(employees);
			

	}
	
	
	public EmployeePresenter getEmployeePresenter() {
		return employeePresenter;
	}


	public void setEmployeePresenter(EmployeePresenter employeePresenter) {
		this.employeePresenter = employeePresenter;
	}

	
	public void clear() {
		listStore.clear();
	}
	
	class GridCellClickHandler implements CellClickHandler{
		

		/* (non-Javadoc)
		 * @see com.sencha.gxt.widget.core.client.event.CellClickEvent.CellClickHandler#onCellClick(com.sencha.gxt.widget.core.client.event.CellClickEvent)
		 */
		@Override
		public void onCellClick(CellClickEvent event) {

			employeePresenter.gridCellClicked(event, listStore);
		}
		
	}
}
