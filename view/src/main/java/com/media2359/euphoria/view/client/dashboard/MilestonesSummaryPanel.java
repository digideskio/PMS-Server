package com.media2359.euphoria.view.client.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.media2359.euphoria.view.dto.milestone.MilestoneDTO;
import com.media2359.euphoria.view.dto.milestone.MilestoneListResponse;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class MilestonesSummaryPanel implements IsWidget, AsyncCallback<MilestoneListResponse> {
	DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
	Date weekStartDate;

	// Property access definitions for the values in the Project object
	public interface GridProperties extends PropertyAccess<MilestoneData> {
		@Path("id")
		ModelKeyProvider<MilestoneData> key();		
		ValueProvider<MilestoneData, String> day1();
		ValueProvider<MilestoneData, String> day2();		
		ValueProvider<MilestoneData, String> day3();		
		ValueProvider<MilestoneData, String> day4();
		ValueProvider<MilestoneData, String> day5();
		
	}
	
	private static final GridProperties gridProperties = GWT
													.create(GridProperties.class);

	private ColumnModel<MilestoneData> cm;
	private ListStore<MilestoneData> store;
	Grid<MilestoneData> grid;
	
	
	@Override
	public Widget asWidget() {
		DateWrapper wrapper = new DateWrapper();
		weekStartDate = wrapper.addDays(-1 * (wrapper.getDayInWeek()-1)).asDate();
		store = new ListStore<MilestoneData>(gridProperties.key());
		
		/**
		 * Now fetch milestones from server
		 */
		Date weekEndDate = (new DateWrapper(weekStartDate)).addDays(4).asDate();
		MilestoneRpcHelper.getAllMilestones(weekStartDate, weekEndDate, this);
		
		ColumnConfig<MilestoneData, String> day1Col = new ColumnConfig<MilestoneData, String>(
				gridProperties.day1(), 150, fmt.format(weekStartDate));
		ColumnConfig<MilestoneData, String> day2Col = new ColumnConfig<MilestoneData, String>(
				gridProperties.day2(), 150, fmt.format((new DateWrapper(weekStartDate)).addDays(1).asDate()));
		ColumnConfig<MilestoneData, String> day3Col = new ColumnConfig<MilestoneData, String>(
				gridProperties.day3(), 150, fmt.format((new DateWrapper(weekStartDate)).addDays(2).asDate()));
		ColumnConfig<MilestoneData, String> day4Col = new ColumnConfig<MilestoneData, String>(
				gridProperties.day4(), 150, fmt.format((new DateWrapper(weekStartDate)).addDays(3).asDate()));
		ColumnConfig<MilestoneData, String> day5Col = new ColumnConfig<MilestoneData, String>(
				gridProperties.day5(), 90, fmt.format(weekEndDate));
		
		List<ColumnConfig<MilestoneData, ?>> columns = new ArrayList<ColumnConfig<MilestoneData, ?>>();
		columns.add(day1Col);
		columns.add(day2Col);
		columns.add(day3Col);
		columns.add(day4Col);
		columns.add(day5Col);
		cm = new ColumnModel<MilestoneData>(columns);
		
		grid = new Grid<MilestoneData>(store, cm);
		grid.setWidth("100%");
		grid.getView().setStripeRows(true);
		
		return grid;
	}

	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(MilestoneListResponse result) {
		if((result != null) && (result.getMilestones() != null)) {
			ArrayList<MilestoneDTO> milestones = result.getMilestones();
			String day1="";
			String day2="";
			String day3="";
			String day4="";
			String day5="";
			
			for(MilestoneDTO milestone:milestones) {
				int diff = (new DateWrapper(milestone.getDueDate()).getDayInWeek()) - 1;
				switch(diff) {
				case 0:
					day1 = day1 + milestone.getProjectName() + " "+ milestone.getMilestoneName() + "\n";
					break;
				case 1:
					day2 = day2 + milestone.getProjectName() + " "+ milestone.getMilestoneName() + "\n";
					break;
				case 2:
					day3 = day3 + milestone.getProjectName() + " "+ milestone.getMilestoneName() + "\n";
					break;
				case 3:
					day4 = day4 + milestone.getProjectName() + " "+ milestone.getMilestoneName() + "\n";
					break;	
				case 4:
					day5 = day5 + milestone.getProjectName() + " "+ milestone.getMilestoneName() + "\n";
					break;	
				} 
			}
			
			MilestoneData data = new MilestoneData();
			data.setDay1(day1);
			data.setDay2(day2);
			data.setDay3(day3);
			data.setDay4(day4);
			data.setDay5(day5);
			store.add(data);
		}
	}
}
