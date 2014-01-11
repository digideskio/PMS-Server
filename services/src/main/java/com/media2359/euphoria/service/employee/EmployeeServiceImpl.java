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
				
				/*EmployeeDTO respEmployee =  employee.createEmployeeDTO();
				
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
				
				respEmployees.add(respEmployee);*/
				respEmployees.add(employee.createEmployeeDTO());
			}
			
			response.setEmployees(respEmployees);
		}
		
		return response;
		
 	}

	@Override
	public String addEmployee(EmployeeDTO employeeDto) {
		Employee employee = null;
		try{
			/*employee = new Employee();
			employee.setName(employeeDto.getName());
			employee.setMobile(employeeDto.getMobile());
			employee.setPersonalEmail(employeeDto.getPersonalEmail());
			employee.setCompanyEmail(employeeDto.getCompanyEmail());
			employee.setDesignation(employeeDto.getDesignation());
			employee.setPlatForms(employeeDto.getPlatForms());
			employee.setAssignedOffice(employeeDto.getAssignedOffice());
			employee.setEmploymentType(employeeDto.getEmploymentType());
			employee.setStartDate(employeeDto.getStartDate());
			employee.setEndDate(employeeDto.getEndDate());
			employee.setMandayRate(employeeDto.getMandayRate());
			
			employeeDao.addEmployee(employee);*/
			
			employee = new Employee(employeeDto);
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public String modifyEmployee(EmployeeDTO employeeDto) {
		Employee employee = null;
		try{
			/*employee = new Employee();
			employee.setName(employeeDto.getName());
			employee.setMobile(employeeDto.getMobile());
			employee.setPersonalEmail(employeeDto.getPersonalEmail());
			employee.setCompanyEmail(employeeDto.getCompanyEmail());
			employee.setDesignation(employeeDto.getDesignation());
			employee.setPlatForms(employeeDto.getPlatForms());
			employee.setAssignedOffice(employeeDto.getAssignedOffice());
			employee.setEmploymentType(employeeDto.getEmploymentType());
			employee.setStartDate(employeeDto.getStartDate());
			employee.setEndDate(employeeDto.getEndDate());
			employee.setMandayRate(employeeDto.getMandayRate());*/
			
			employee = new Employee(employeeDto);
			employeeDao.updateEmployee(employee);
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public String deleteEmployee(EmployeeDTO employeeDto) {
		try{
			employeeDao.deleteEmployee(Integer.parseInt(employeeDto.getEmployeeKey()));
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public EmployeeDTO getEmployeeDetails(EmployeeDTO employeeDto) {
		System.out.println("++++++ Employee Key +++++++"+employeeDto.getEmployeeKey());
		Employee employee = employeeDao.getEmployee(Integer.parseInt(employeeDto.getEmployeeKey()));
		
		/*EmployeeDTO respEmployee =  employee.createEmployeeDTO();
		
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
		respEmployee.setStatus(employee.getStatus());*/
		
		EmployeeDTO respEmployee =  employee.createEmployeeDTO();
		
		return respEmployee;
	}

	@Override
	public Integer getMaxKey() {
		// TODO Auto-generated method stub
		return employeeDao.getMaxKey();
	}
}
