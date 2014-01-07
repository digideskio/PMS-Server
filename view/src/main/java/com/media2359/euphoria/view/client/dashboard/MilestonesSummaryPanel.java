package com.media2359.euphoria.view.client.dashboard;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class MilestonesSummaryPanel implements IsWidget {

	// Property access definitions for the values in the Project object
	public interface GridProperties extends PropertyAccess<MilestoneDTO> {
		@Path("id")
		ModelKeyProvider<MilestoneDTO> key();		
		ValueProvider<MilestoneDTO, String> day1();
		ValueProvider<MilestoneDTO, String> day2();		
		ValueProvider<MilestoneDTO, String> day3();		
		ValueProvider<MilestoneDTO, String> day4();
		ValueProvider<MilestoneDTO, String> day5();
		
	}
	
	private static final GridProperties gridProperties = GWT
													.create(GridProperties.class);

	private ColumnModel<MilestoneDTO> cm;
	private ListStore<MilestoneDTO> store;
	Grid<MilestoneDTO> grid;
	
	
	@Override
	public Widget asWidget() {
		store = new ListStore<MilestoneDTO>(gridProperties.key());

		ColumnConfig<MilestoneDTO, String> day1Col = new ColumnConfig<MilestoneDTO, String>(
				gridProperties.day1(), 150, "06/01/2013");
		ColumnConfig<MilestoneDTO, String> day2Col = new ColumnConfig<MilestoneDTO, String>(
				gridProperties.day2(), 150, "07/01/2013");
		ColumnConfig<MilestoneDTO, String> day3Col = new ColumnConfig<MilestoneDTO, String>(
				gridProperties.day3(), 150, "08/01/2013");
		ColumnConfig<MilestoneDTO, String> day4Col = new ColumnConfig<MilestoneDTO, String>(
				gridProperties.day4(), 150, "09/01/2013");
		ColumnConfig<MilestoneDTO, String> day5Col = new ColumnConfig<MilestoneDTO, String>(
				gridProperties.day5(), 90, "10/01/2013");
		
		List<ColumnConfig<MilestoneDTO, ?>> columns = new ArrayList<ColumnConfig<MilestoneDTO, ?>>();
		columns.add(day1Col);
		columns.add(day2Col);
		columns.add(day3Col);
		columns.add(day4Col);
		columns.add(day5Col);
		cm = new ColumnModel<MilestoneDTO>(columns);
		
		grid = new Grid<MilestoneDTO>(store, cm);
		grid.setWidth("100%");
		grid.getView().setStripeRows(true);
		
		ArrayList<MilestoneDTO> milestones = getDummyMilestones();
		if(milestones != null) {
			store.addAll(milestones);
		}
		return grid;
	}
	
	public ArrayList<MilestoneDTO> getDummyMilestones() {
		ArrayList<MilestoneDTO> milestones = new ArrayList<MilestoneDTO>(1);
		MilestoneDTO dto = new MilestoneDTO();
		dto.setDay1("Milestone1");
		dto.setDay3("Milestone2<BR>Milestone 3");
		dto.setDay5("Milestone5");
		milestones.add(dto);
		return milestones;
	}
}
