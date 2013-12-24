/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.employee;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;

/**
 * Employee
 * 
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class Employee {
	private Integer employeeKey;
	private String name;
	private String mobile;
	private String personalEmail;
	private String companyEmail;
	private String designation;
	private String platForms;
	private String employmentType;
	private String mandayRate;
	private String assignedOffice;
	private Date startDate;
	private Date endDate;
	private String status;
	private String company_id="Media2359";
	private String created_by_id ;
	private Timestamp create_tstamp; 
	
	Set<Platform> skills;
	Set<Role> roles;
	EmployeeLeavePlan leavePlan;


	public Employee() {

	}

	public Employee(EmployeeDTO employeeDTO) {
		this.employeeKey = Integer.valueOf(employeeDTO.getEmployeeKey());
		this.name = employeeDTO.getName();
		this.personalEmail = employeeDTO.getPersonalEmail();
		this.companyEmail = employeeDTO.getCompanyEmail();
		this.mobile = employeeDTO.getMobile();
		this.designation = employeeDTO.getDesignation();
		this.employmentType = employeeDTO.getEmploymentType();
		this.mandayRate = employeeDTO.getMandayRate();
		this.assignedOffice = employeeDTO.getAssignedOffice();
		this.startDate = employeeDTO.getStartDate();
		this.endDate = employeeDTO.getEndDate();
		this.status = employeeDTO.getStatus();
	}

	
	public Integer getEmployeeKey() {
		return employeeKey;
	}

	public void setEmployeeKey(Integer employeeKey) {
		this.employeeKey = employeeKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	
	

	/**
	 * @return the platForms
	 */
	public String getPlatForms() {
		return platForms;
	}

	/**
	 * @param platForms the platForms to set
	 */
	public void setPlatForms(String platForms) {
		this.platForms = platForms;
	}

	/**
	 * @return the mandayRate
	 */
	public String getMandayRate() {
		return mandayRate;
	}

	/**
	 * @param mandayRate the mandayRate to set
	 */
	public void setMandayRate(String mandayRate) {
		this.mandayRate = mandayRate;
	}

	/**
	 * @return the assignedOffice
	 */
	public String getAssignedOffice() {
		return assignedOffice;
	}

	/**
	 * @param assignedOffice the assignedOffice to set
	 */
	public void setAssignedOffice(String assignedOffice) {
		this.assignedOffice = assignedOffice;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 
	 * @return
	 */
	
	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
	
	

	public String getCreated_by_id() {
		return created_by_id;
	}

	public void setCreated_by_id(String created_by_id) {
		this.created_by_id = created_by_id;
	}

	public Timestamp getCreate_tstamp() {
		return new Timestamp(new Date().getTime());
	}

	public void setCreate_tstamp(Timestamp create_tstamp) {
		this.create_tstamp = create_tstamp;
	}

	/**


	/**
	 * TODO Write something about this method
	 * 
	 * @returns EmployeeDTO
	 */
	public EmployeeDTO createEmployeeDTO() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeKey(getEmployeeKey());
		employeeDTO.setName(getName());
		employeeDTO.setPersonalEmail(getPersonalEmail());
		employeeDTO.setCompanyEmail(getCompanyEmail());
		employeeDTO.setEmploymentType(getEmploymentType());
		employeeDTO.setMobile(getMobile());
		employeeDTO.setDesignation(getDesignation());
		return employeeDTO;
	}
}
