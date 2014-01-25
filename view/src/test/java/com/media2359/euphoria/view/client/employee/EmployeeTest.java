package com.media2359.euphoria.view.client.employee;


import java.util.List;
import java.util.logging.Logger;

import org.apache.bcel.verifier.statics.Pass1Verifier;

/**
 * 
 * ManpowerRequestAllocationPanelTest
 *
 * Class to test the Manpower Allocation View
 * 
 * @author PJ
 * @version 1.0 2013
 *
 */
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
public class EmployeeTest extends GWTTestCase {
	private List<EmployeeDTO> employees;
	private EmployeePresenter employeePresenter;
	private Logger log = Logger.getLogger("EuphoriaLogger");
	
	private final String testEmployeeID = "TestEmployee999";
	private final String testEmployeeEmail = "TestEmployee999@somemail.com";
	private EmployeeDTO testEmployee;
	

	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		employeePresenter = new EmployeePresenter();
		testEmployee = createTestEmployee();
	}

	protected void gwrTearDown() throws Exception {
		super.gwtTearDown();
	}
		
	public  void testEmployeeActions(){
		
		log.info("#!#!#!#! testEmployeePresenterNotNull");		
		assertNotNull(employeePresenter);
		
	}
	
	
	public void /*test*/RPCActions() {
		  // Setup an asynchronous event handler.
//		  Timer timer = new Timer() {
//		    public void run() {
//
//
//		    	finishTest();
//		    }
//		  };

		  // Set a delay period significantly longer than the
		  // event is expected to take.

		
    	log.info("#!#!#!#! createEmployee");
		
		final AsyncCallback<String> callback = new AsyncCallback<String>() {
	  
			
			
			public void onFailure(Throwable caught) {
//				fail("#!#!#!#!createEmployee RPC Call  Failed");
				caught.printStackTrace();
			}

			public void onSuccess(String result) {
				
				assertEquals("SUCCESS", result.trim());
//				loadEmployee();

			}

		};
			
		employeePresenter.getEmployeeService().addEmployee(testEmployee, callback);
		delayTestFinish(5000);

		  // Schedule the event and return control to the test system.
//		  timer.schedule(100);
		}
	
	
	private  void createEmployee(){
		log.info("#!#!#!#! createEmployee");
		
		final AsyncCallback<String> callback = new AsyncCallback<String>() {
	  
			
			
			public void onFailure(Throwable caught) {
//				fail("#!#!#!#!createEmployee RPC Call  Failed");
				caught.printStackTrace();
			}

			public void onSuccess(String result) {
				
				assertEquals("SUCCESS", result.trim());
//				loadEmployee();

			}

		};
			
		employeePresenter.getEmployeeService().addEmployee(testEmployee, callback);
		
	}

	private  void loadEmployee(){
		log.info("#!#!#!#! loadEmployee");
		
		final AsyncCallback<EmployeeListResponse> callback = new AsyncCallback<EmployeeListResponse>() {
	  
			
			
			public void onFailure(Throwable caught) {
				fail("#!#!#!#!loadEmployee RPC Call  Filed");
				caught.printStackTrace();
			}

			public void onSuccess(EmployeeListResponse result) {
				
				employees = result.getEmployees();
				assertNotNull(employees);
				assertTrue(employeesContainTestEmployee());
			}

		};
			
		employeePresenter.getEmployeeService().getAllEmployees(new EmployeeListRequest(), callback);
		
	}

	private boolean employeesContainTestEmployee(){
		for(EmployeeDTO employee:employees){
			if(employee.getName().equals(testEmployeeID)){
				testEmployee = employee;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String getModuleName() {
		return "com.media2359.euphoria.view.Euphoria";
	}
	
	
	private EmployeeDTO createTestEmployee(){
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName(testEmployeeID);
		return employeeDTO;
	}

}
