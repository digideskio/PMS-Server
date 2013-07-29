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
