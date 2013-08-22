/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.demo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EchoDaoImpl implements EchoDao {
	private final Logger log = Logger.getLogger(EchoDaoImpl.class);
	
	public String getMessage(String message) {
		return "Hello "+message;
	}

}
