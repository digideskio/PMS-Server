/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.employee;

/**
 * EmployeeDaoTest
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.employee.EmployeeDao;
import com.media2359.euphoria.dao.project.ProjectDao;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
public class EmployeeDaoTest {
	@Autowired
	private EmployeeDao employeeDao;
	private Logger log = Logger.getLogger(EmployeeDaoTest.class);
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		Assert.assertNotNull(employees);
		log.info("Number of Employees returned:"+employees.size());
		
	}
}
