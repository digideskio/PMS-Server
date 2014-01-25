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
import java.util.HashSet;
import java.util.Set;

import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
/**
 * Employee
 * 
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "employee")  
public class Employee implements java.io.Serializable{
	private Integer employeeKey;
	private String name;
	private String mobile;
	private String personalEmail;
	private String companyEmail;
	private String designation;
	private Set<Platform> platForms;
	private String employmentType;
	private String mandayRate;
	private String assignedOffice;
	private Date startDate;
	private Date endDate;
	private String status;
	private String company_id="Media2359";
	private String createdById;
	private Date createTstamp;
	private String lastUpdById;
	private Date lastUpdTstamp;
	
	Set<Platform> skills;
	Set<Role> roles;
	EmployeeLeavePlan leavePlan;


	public Employee() {

	}

	public Employee(EmployeeDTO employeeDTO) {
		this.employeeKey = employeeDTO.getEmployeeKey();
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
		this.company_id=employeeDTO.getCompany_id();
		this.createdById=employeeDTO.getCreatedById();
		this.createTstamp = employeeDTO.getCreateTstamp();
		this.lastUpdById = employeeDTO.getLastUpdById();
		this.lastUpdTstamp = employeeDTO.getLastUpdTstamp();

		this.platForms = new HashSet(0);
		if(employeeDTO.getPlatFormDtos()!=null){
			for(PlatformDTO platFormDto: employeeDTO.getPlatFormDtos()){
				Platform platForm = new Platform(platFormDto);
				this.platForms.add(platForm);
			}
		}
		
	}

	@Id
	@GeneratedValue(generator = "EmployeeGenerator")     
	@GenericGenerator(name = "EmployeeGenerator", strategy = "increment") 
	@Column(name = "employee_key")
	public Integer getEmployeeKey() {
		return employeeKey;
	}

	public void setEmployeeKey(Integer employeeKey) {
		this.employeeKey = employeeKey;
	}
	
	@Column(name = "full_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "mobile_nbr")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "personal_email_addr")
	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	@Column(name = "company_eamil_addr")
	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	@Column(name = "designation")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "employment_type")
	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.REFRESH)
	@Fetch(FetchMode.JOIN)
	@JoinTable(name="employee_platform_xref",
	joinColumns = {@JoinColumn(name="employee_key", referencedColumnName="employee_key", updatable=false)},
	inverseJoinColumns = {@JoinColumn(name="platform_key", referencedColumnName="platform_key", updatable=false)})
	public Set<Platform> getPlatForms() {
		return platForms;
	}

	public void setPlatForms(Set<Platform> platForms) {
		this.platForms = platForms;
	}


	/**
	 * @return the mandayRate
	 */
	@Column(name = "manday_rate")
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
	@Column(name = "assigned_office")
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
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
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
	@Column(name = "status")
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
	@Column(name = "company_id")
	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
	
	@Column(name="create_by_id")
	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	@Column(name="create_tstamp")
	public Date getCreateTstamp() {
		return createTstamp;
	}

	public void setCreateTstamp(Date createTstamp) {
		this.createTstamp = createTstamp;
	}

	
	@Column(name="last_upd_by_id")
	public String getLastUpdById() {
		return lastUpdById;
	}

	public void setLastUpdById(String lastUpdById) {
		this.lastUpdById = lastUpdById;
	}

	@Column(name="last_upd_tstamp")
	public Date getLastUpdTstamp() {
		return lastUpdTstamp;
	}

	public void setLastUpdTstamp(Date lastUpdTstamp) {
		this.lastUpdTstamp = lastUpdTstamp;
	}


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
		
		employeeDTO.setStartDate(getStartDate());
		employeeDTO.setEndDate(getEndDate());
		employeeDTO.setAssignedOffice(getAssignedOffice());
		employeeDTO.setMandayRate(getMandayRate());
		employeeDTO.setStatus(getStatus());
		employeeDTO.setCompany_id(getCompany_id());
		
		employeeDTO.setCreatedById(getCreatedById());
		employeeDTO.setCreateTstamp(getCreateTstamp());
		employeeDTO.setLastUpdById(getLastUpdById());
		employeeDTO.setLastUpdTstamp(getLastUpdTstamp());
		
		employeeDTO.setPlatFormDtos(new HashSet<PlatformDTO>(0));
		if(platForms !=null){
			for (Platform platform: platForms){
				PlatformDTO platformDto = platform.createPlatformDTO();
				employeeDTO.getPlatFormDtos().add(platformDto);
			}
		}
		
		
		return employeeDTO;
	}

	@Override
	public String toString() {
		return "Employee [employeeKey=" + employeeKey + ", name=" + name
				+ ", mobile=" + mobile + ", personalEmail=" + personalEmail
				+ ", companyEmail=" + companyEmail + ", designation="
				+ designation + ", platForms=" + platForms
				+ ", employmentType=" + employmentType + ", mandayRate="
				+ mandayRate + ", assignedOffice=" + assignedOffice
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", company_id=" + company_id
				+ ", createdById=" + createdById + ", createTstamp="
				+ createTstamp + ", lastUpdById=" + lastUpdById
				+ ", lastUpdTstamp=" + lastUpdTstamp + ", skills=" + skills
				+ ", roles=" + roles + ", leavePlan=" + leavePlan + "]";
	}

}
