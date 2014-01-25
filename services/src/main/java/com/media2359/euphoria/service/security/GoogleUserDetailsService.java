/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.service.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;

import com.media2359.euphoria.dao.employee.EmployeeDAO;
import com.media2359.euphoria.model.employee.Employee;

/**
 * 
 * GoogleUserDetailsService
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 *
 */
public class GoogleUserDetailsService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {
	private Logger log = Logger.getLogger(GoogleUserDetailsService.class);
	
	@Autowired
	EmployeeDAO employeeDao;

	public UserDetails loadUserDetails(OpenIDAuthenticationToken token)
			throws UsernameNotFoundException, DataAccessException {
		log.info("Fetching user details ...");
		UserDetails userDetail = null;
		if(token != null) {
			List<OpenIDAttribute> attributes = token.getAttributes();
			if(attributes != null) {
				for(OpenIDAttribute attribute:attributes) {
					if("email".equals(attribute.getName())) {
						if(attribute.getValues() != null) {
							String email = attribute.getValues().get(0);
							log.info("Retrieved Email of the user: "+email);
							
							//Verify this user in database and fetch role details
							//Employee employee = employeeDao.getEmployeeByUserId(email);
							
							//if(employee != null) {
								//log.info("Employee Designation is "+employee.getDesignation());
								List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
								grantedAuthorities.add(new GrantedAuthorityImpl(com.media2359.euphoria.dao.user.Role.USER.getCode()));
								//grantedAuthorities.add(new GrantedAuthorityImpl((employee.getDesignation())));	
								userDetail = new User(email, "", true, true, true, true, grantedAuthorities);
								return userDetail;
							//}
						} else {
							log.error("Received empty email attribute");
						}
					}
				}
			} else {
				log.error("Did not receive any attributes");
			}
		} else {
			log.error("Received empty token");
		}
		throw new UsernameNotFoundException("Invalid user details");
	}
}
