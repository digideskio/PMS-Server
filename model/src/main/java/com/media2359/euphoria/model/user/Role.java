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
 * Role
 * 
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/
@Entity 
@Table(name = "role")  
public class Role implements java.io.Serializable{
	
	@Id
	@GeneratedValue(generator = "RoleGenerator")     
	@GenericGenerator(name = "RoleGenerator", strategy = "increment") 
	@Column(name = "role_key")
	private Integer roleKey;
	
	@Column(name = "role_id")
	private String roleId;
	
	@Column(name = "role_name")
	private String roleName;

	public Role() {

	}

	public Role(RoleDTO roleDto) {
		
		this.setRoleKey(roleKey);
		this.setRoleName(getRoleName());
		this.setRoleId(roleDto.getRoleId());
	}
	

	public Integer getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(Integer roleKey) {
		this.roleKey = roleKey;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public RoleDTO createRoleDTO(){
		RoleDTO roleDto = new RoleDTO();
		roleDto.setRoleKey(getRoleKey());
		roleDto.setRoleId(getRoleId());
		roleDto.setRoleName(getRoleName());
		
		return roleDto;
	}

	@Override
	public String toString() {
		return "Role [roleKey=" + roleKey + ", roleId=" + roleId
				+ ", roleName=" + roleName + "]";
	}
	
	
}
