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

import java.util.Date;
import java.util.List;

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
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;

	private EmployeeDTO employeeDto ; 
	
	
	@Before
	public void setUp(){
		employeeDto = new EmployeeDTO();
		employeeDto.setName("Shiv Ranjan Kole");
		employeeDto.setPersonalEmail("shiv.kole@gmail.com");
		employeeDto.setMobile("83222489");
		employeeDto.setDesignation("Project Manager");
		employeeDto.setCompanyEmail("shiv.kole@media2359.com");
		employeeDto.setEmploymentType("Permanent");
		employeeDto.setCreatedById("TY");
		employeeDto.setCreateTstamp(new Date());
		
		
	}
	
	
	
	
	@Test
	public void test1GetAllEmployees() {
		EmployeeListResponse response = 
				employeeService.getAllEmployees(new EmployeeListRequest());
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getEmployees());
	}
	
	
	@Test
	public void test2AddEmployee(){
		
		String result = employeeService.addEmployee(employeeDto);
		Assert.assertEquals("SUCCESS", result);
		
	
	}
	
	@Test
	public void test3GetEmployeeDetails(){
		EmployeeDTO emp1 = new EmployeeDTO();
		emp1.setEmployeeKey(employeeService.getMaxKey());
		EmployeeDTO employee1 = employeeService.getEmployeeDetails(emp1);
		Assert.assertNotNull(employee1);
		
	}
	
	@Test
	public void test4ModifyEmployee(){
		employeeDto.setPersonalEmail("shiv_rec@yahoo.com");
		String result = employeeService.modifyEmployee(employeeDto);
		Assert.assertEquals("SUCCESS", result);
		
	}
	
	@Test
	public void test5DeleteEmployee(){
		EmployeeDTO emp1 = new EmployeeDTO();
		emp1.setEmployeeKey(employeeService.getMaxKey());
		String result = employeeService.deleteEmployee(emp1);
		Assert.assertEquals("SUCCESS", result);
		
	}
	
	@Test
	public void test6GetAllPlatforms(){
		List<PlatformDTO> platformDTOs = employeeService.findAllPlatforms();
		Assert.assertNotNull(platformDTOs);
	}
	
 
	
	
}
