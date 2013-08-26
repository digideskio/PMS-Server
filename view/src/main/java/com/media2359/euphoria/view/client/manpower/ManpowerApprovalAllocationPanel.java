/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.Converter;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridInlineEditing;

/**
 * View class for allocating Weekly Manpower requests
 * 
 * @author AJ
 * @version 1.0
 * 
 */
public class ManpowerApprovalAllocationPanel implements IsWidget {

	private WeeklyResourceRequestProperties props = null;

	private ColumnModel<WeeklyResourceRequest> cm;
	private ListStore<WeeklyResourceRequest> store;

	Grid<WeeklyResourceRequest> grid;

	/**
	 * Main method to create this widget. Called by the
	 * GWT Framework
	 */
	@Override
	public Widget asWidget() {
		props = GWT.create(WeeklyResourceRequestProperties.class);

		ColumnConfig<WeeklyResourceRequest, String> platformCol = new ColumnConfig<WeeklyResourceRequest, String>(
				props.platform(), 150, "Platform");
		ColumnConfig<WeeklyResourceRequest, String> startDateCol = new ColumnConfig<WeeklyResourceRequest, String>(
				props.startDate(), 150, "Start Day");
		ColumnConfig<WeeklyResourceRequest, String> durationCol = new ColumnConfig<WeeklyResourceRequest, String>(
				props.duration(), 200, "Duration");
		ColumnConfig<WeeklyResourceRequest, String> resourceCol = new ColumnConfig<WeeklyResourceRequest, String>(
				props.resource(), 150, "Developer");
		ColumnConfig<WeeklyResourceRequest, String> commentCol = new ColumnConfig<WeeklyResourceRequest, String>(
				props.comment(), 200, "Comments");

		List<ColumnConfig<WeeklyResourceRequest, ?>> l = new ArrayList<ColumnConfig<WeeklyResourceRequest, ?>>();
		l.add(platformCol);
		l.add(startDateCol);
		l.add(durationCol);
		l.add(resourceCol);
		l.add(commentCol);

		cm = new ColumnModel<WeeklyResourceRequest>(l);

		store = new ListStore<WeeklyResourceRequest>(props.key());
		store.addAll(getWeeklyResourceRequests());

		grid = new Grid<WeeklyResourceRequest>(store, cm);
		grid.setWidth("100%");

		grid.getView().setAutoExpandColumn(resourceCol);
		grid.getView().setStripeRows(true);

		GridEditing<WeeklyResourceRequest> editableGrid = createEditableGrid(grid);

		/**
		 * Make Resource Col editable
		 */
		SimpleComboBox<Resource> combo = new SimpleComboBox<Resource>(
				new StringLabelProvider<Resource>());
		combo.setPropertyEditor(new PropertyEditor<Resource>() {

			@Override
			public Resource parse(CharSequence text) throws ParseException {
				return Resource.parseString(text.toString());
			}

			@Override
			public String render(Resource object) {
				return object == null ? Resource.DEVELOPER1.toString() : object
						.toString();
			}
		});
		combo.setTriggerAction(TriggerAction.ALL);
		combo.add(Resource.DEVELOPER1);
		combo.add(Resource.DEVELOPER2);
		combo.add(Resource.DEVELOPER3);
		combo.add(Resource.DEVELOPER4);
		combo.add(Resource.DEVELOPER5);
		combo.setForceSelection(true);
		editableGrid.addEditor(resourceCol, new Converter<String, Resource>() {

			@Override
			public String convertFieldValue(Resource object) {
				return object == null ? Resource.DEVELOPER1.toString() : object
						.toString();
			}

			@Override
			public Resource convertModelValue(String object) {
				return Resource.parseString(object);
			}

		}, combo);

		/**
		 * Make Platform Col editable
		 */
		SimpleComboBox<Platform> combo1 = new SimpleComboBox<Platform>(
				new StringLabelProvider<Platform>());
		combo1.setPropertyEditor(new PropertyEditor<Platform>() {

			@Override
			public Platform parse(CharSequence text) throws ParseException {
				return Platform.parseString(text.toString());
			}

			@Override
			public String render(Platform object) {
				return object == null ? Resource.DEVELOPER1.toString() : object
						.toString();
			}
		});
		combo1.setTriggerAction(TriggerAction.ALL);
		combo1.add(Platform.ANDROID);
		combo1.add(Platform.IOS);
		combo1.add(Platform.RUBY);
		combo1.add(Platform.GRAILS);
		combo1.add(Platform.SERVER);
		combo1.add(Platform.UI);
		combo1.setForceSelection(true);
		editableGrid.addEditor(platformCol, new Converter<String, Platform>() {

			@Override
			public String convertFieldValue(Platform object) {
				return object == null ? Platform.IOS.toString() : object
						.toString();
			}

			@Override
			public Platform convertModelValue(String object) {
				return Platform.parseString(object);
			}

		}, combo1);

		/**
		 * Make Resource Col editable
		 */
		SimpleComboBox<DayOfWeek> combo2 = new SimpleComboBox<DayOfWeek>(
				new StringLabelProvider<DayOfWeek>());
		combo2.setPropertyEditor(new PropertyEditor<DayOfWeek>() {

			@Override
			public DayOfWeek parse(CharSequence text) throws ParseException {
				return DayOfWeek.parseString(text.toString());
			}

			@Override
			public String render(DayOfWeek object) {
				return object == null ? DayOfWeek.MONDAY.toString() : object
						.toString();
			}
		});
		combo2.setTriggerAction(TriggerAction.ALL);
		combo2.add(DayOfWeek.MONDAY);
		combo2.add(DayOfWeek.TUESDAY);
		combo2.add(DayOfWeek.WEDNESDAY);
		combo2.add(DayOfWeek.THURSDAY);
		combo2.add(DayOfWeek.FRIDAY);
		combo2.add(DayOfWeek.SATURDAY);
		combo2.add(DayOfWeek.SUNDAY);
		combo2.setForceSelection(true);
		editableGrid.addEditor(startDateCol,
				new Converter<String, DayOfWeek>() {

					@Override
					public String convertFieldValue(DayOfWeek object) {
						return object == null ? DayOfWeek.MONDAY.toString()
								: object.toString();
					}

					@Override
					public DayOfWeek convertModelValue(String object) {
						return DayOfWeek.parseString(object);
					}

				}, combo2);

		editableGrid.addEditor(commentCol, new TextField());
		return grid;
	}
	
	/**
	 * Helper method to add a new row
	 * 
	 */
	public void addNewRow() {
		
	}
	
	/**
	 * Update the view with supplied data
	 * 
	 * @param weeklyResourceRequests
	 */
	public void update(ArrayList<WeeklyResourceRequest> weeklyResourceRequests) {

	}

	/**
	 * Test method to supply data
	 * 
	 * @return
	 */
	protected ArrayList<WeeklyResourceRequest> getWeeklyResourceRequests() {
		ArrayList<WeeklyResourceRequest> requestList = new ArrayList<WeeklyResourceRequest>();

		WeeklyResourceRequest request;

		request = new WeeklyResourceRequest();
		request.setId("1");
		request.setResource(Resource.DEVELOPER1.toString());
		request.setDuration("1.0");
		request.setPlatform(Platform.IOS.toString());
		request.setStartDate(DayOfWeek.MONDAY.toString());
		request.setComment("This is comment");
		requestList.add(request);

		request = new WeeklyResourceRequest();
		request.setId("2");
		request.setResource(Resource.DEVELOPER2.toString());
		request.setDuration("2.0");
		request.setPlatform(Platform.ANDROID.toString());
		request.setStartDate(DayOfWeek.MONDAY.toString());
		request.setComment("This is comment");
		requestList.add(request);

		request = new WeeklyResourceRequest();
		request.setId("3");
		request.setResource(Resource.DEVELOPER3.toString());
		request.setDuration("0.5");
		request.setPlatform(Platform.ANDROID.toString());
		request.setStartDate(DayOfWeek.WEDNESDAY.toString());
		request.setComment("This is comment");
		requestList.add(request);

		request = new WeeklyResourceRequest();
		request.setId("4");
		request.setResource(Resource.DEVELOPER4.toString());
		request.setDuration("2.0");
		request.setPlatform(Platform.SERVER.toString());
		request.setStartDate(DayOfWeek.THURSDAY.toString());
		request.setComment("This is comment");
		requestList.add(request);

		return requestList;
	}

	/**
	 * Helper method to create an editable grid
	 * 
	 * @param grid
	 * @return
	 */
	GridEditing<WeeklyResourceRequest> createEditableGrid(
			Grid<WeeklyResourceRequest> grid) {
		return new GridInlineEditing<WeeklyResourceRequest>(grid);
	}
}
