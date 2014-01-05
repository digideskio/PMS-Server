/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.service.employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.employee.EmployeeDAO;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Employee employee ; 
	
	
	@Before
	public void setUp(){
		employee.setName("Shiv Ranjan Kole");
		employee.setPersonalEmail("shiv.kole@gmail.com");
		employee.setMobile("83222489");
		employee.setDesignation("Project Manager");
		employee.setCompanyEmail("shiv.kole@media2359.com");
		employee.setEmploymentType("Permanent");
		employee.setCreated_by_id("shiv.kole@gmail.com");
		
		
		
	}
	
	
	@Test
	public void test1GetAllEmployees() {
		EmployeeListResponse response = 
				employeeService.getAllEmployees(new EmployeeListRequest());
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getEmployees());
	}
	
	/*
	@Test
	public void test2AddEmployee(){
		
		String result = employeeService.addEmployee(employee);
		Assert.assertEquals("SUCCESS", result);
		
	
	}
	
	@Test
	public void test3GetEmployeeDetails(){
		Employee emp1 = new Employee();
		emp1.setEmployeeKey(employeeService.getMaxKey());
		Employee employee1 = employeeService.getEmployeeDetails(emp1);
		Assert.assertNotNull(employee1);
		
	}
	
	@Test
	public void test4ModifyEmployee(){
		employee.setPersonalEmail("shiv_rec@yahoo.com");
		String result = employeeService.modifyEmployee(employee);
		Assert.assertEquals("SUCCESS", result);
		
	}
	
	@Test
	public void test5DeleteEmployee(){
		Employee emp1 = new Employee();
		emp1.setEmployeeKey(employeeService.getMaxKey());
		String result = employeeService.deleteEmployee(emp1);
		Assert.assertEquals("SUCCESS", result);
		
	}
	
 */
	
	
}
