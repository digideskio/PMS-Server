package com.media2359.euphoria.view.client.core;

import java.util.ArrayList;
import java.util.List;

import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;

public enum EmployeesTest {
	

	
	Employee1("Employee 1"), Employee2("Employee 2"), Employee3("Employee 3"), Employee4(
			"Employee 4"), Employee5("Employee 5"), Employee6("Employee 6"), Employee7("Employee 7"), Employee8("Employee 8");
	
	
	private static ListStore<String> employeeListStore;
	private String text;
	
	
	EmployeesTest(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
	

	
	
	public static ListStore<String> getAllEmployeesAsListStore(){
		if(employeeListStore != null)
			return employeeListStore;
		
		employeeListStore = new ListStore<String>(new ModelKeyProvider<String>() {
		      @Override
		      public String getKey(String item) {
		        return item.toString();
		      }
		    });
		
		employeeListStore.add(Employee1.toString());
		employeeListStore.add(Employee2.toString());
		employeeListStore.add(Employee3.toString());
		employeeListStore.add(Employee4.toString());
		employeeListStore.add(Employee5.toString());
		employeeListStore.add(Employee6.toString());
		employeeListStore.add(Employee7.toString());
		employeeListStore.add(Employee8.toString());
		
		return employeeListStore;
	}
	

}