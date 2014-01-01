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
/**
 * EmployeeServiceImpl
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.employee.EmployeeDAO;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;


@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDao;
	private final Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	
	public EmployeeListResponse getAllEmployees(EmployeeListRequest request) {
		log.info("Received request :"+request);
		
		List<Employee> employees = employeeDao.getAllEmployees();
		EmployeeListResponse response =  new EmployeeListResponse();
		
		if(employees != null) {
			
			List<EmployeeDTO> respEmployees
			= new ArrayList<EmployeeDTO> ();
			
			for(Employee employee:employees){
				
				EmployeeDTO respEmployee =  employee.createEmployeeDTO();
				
				respEmployee.setName(employee.getName());
				respEmployee.setCompanyEmail(employee.getCompanyEmail());
				respEmployee.setDesignation(employee.getDesignation());
				respEmployee.setEmploymentType(employee.getEmploymentType());
				respEmployee.setMobile(employee.getMobile());
				respEmployee.setPersonalEmail(employee.getPersonalEmail());
				respEmployee.setPlatForms(employee.getPlatForms());
				respEmployee.setEmploymentType(employee.getEmploymentType());
				respEmployee.setMandayRate(employee.getMandayRate());
				respEmployee.setAssignedOffice(employee.getAssignedOffice());
				respEmployee.setStartDate(employee.getStartDate());
				respEmployee.setEndDate(employee.getEndDate());
				respEmployee.setStatus(employee.getStatus());
				
				respEmployees.add(respEmployee);
			}
			
			response.setEmployees(respEmployees);
		}
		
		return response;
		
 	}

	@Override
	public String addEmployee(Employee employee) {
		try{
			employeeDao.addEmployee(employee);
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public String modifyEmployee(Employee employee) {
		try{
			employeeDao.updateEmployee(employee);
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public String deleteEmployee(Employee employee) {
		try{
			employeeDao.deleteEmployee(employee.getEmployeeKey());
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public Employee getEmployeeDetails(Employee employee) {
		System.out.println("++++++ Employee Key +++++++"+employee.getEmployeeKey());
		return employeeDao.getEmployee(employee.getEmployeeKey());
	}

	@Override
	public Integer getMaxKey() {
		// TODO Auto-generated method stub
		return employeeDao.getMaxKey();
	}
}
