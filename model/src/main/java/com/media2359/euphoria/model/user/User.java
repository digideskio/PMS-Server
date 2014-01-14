/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.user;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.user.*;

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

import org.hibernate.annotations.GenericGenerator;
/**
 * User
 * 
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "users")  
public class User implements java.io.Serializable{
	
	@Id
	@GeneratedValue(generator = "UserGenerator")     
	@GenericGenerator(name = "UserGenerator", strategy = "increment") 
	@Column(name = "user_key")
	private Integer userKey;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@OneToOne
	@JoinColumn(name = "employee_key")
	private Employee employee;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="user_role_xref", 
	joinColumns = {@JoinColumn(name="user_key", referencedColumnName="user_key")},
	inverseJoinColumns = {@JoinColumn(name="role_key", referencedColumnName="role_key")})
	private Set<Role> roles;
	
	@Column(name = "create_by_id")
	private String createdById ;
	
	@Column(name = "create_tstamp")
	private Date createTstamp; 

	public User() {

	}

	public User(UserDTO userDto) {
		this.userKey = userDto.getUserKey();
		this.userId= userDto.getUserId();
		this.employee = userDto.getEmployee();
		this.userName = userDto.getUserName();
		this.createdById = userDto.getCreatedById();
		this.createTstamp = userDto.getCreateTstamp();

		this.roles = new HashSet(0);
		if(userDto.getRoleDtos()!=null){
			for(RoleDTO roleDto: userDto.getRoleDtos()){
				Role role = new Role(roleDto);
				this.roles.add(role);
			}
		}
		
	}

	public Integer getUserKey() {
		return userKey;
	}

	public void setUserKey(Integer userKey) {
		this.userKey = userKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public Date getCreateTstamp() {
		return createTstamp;
	}

	public void setCreateTstamp(Date createTstamp) {
		this.createTstamp = createTstamp;
	}

	public UserDTO createUserDTO(){
		UserDTO userDto = new UserDTO();
		userDto.setUserKey(getUserKey());
		userDto.setUserId(getUserId());
		userDto.setUserName(getUserName());
		userDto.setEmployee(getEmployee());
		userDto.setCreatedById(getCreatedById());
		userDto.setCreateTstamp(getCreateTstamp());
		
		
		userDto.setRoleDtos(new HashSet<RoleDTO>(0));
		for (Role role: roles){
			RoleDTO roleDto = role.createRoleDTO();
			userDto.getRoleDtos().add(roleDto);
		}
		
		return userDto;
		
	}

	@Override
	public String toString() {
		return "User [userKey=" + userKey + ", userId=" + userId
				+ ", userName=" + userName + ", employee=" + employee
				+ ", createdById=" + createdById + ", createTstamp="
				+ createTstamp + "]";
	}

	
}
