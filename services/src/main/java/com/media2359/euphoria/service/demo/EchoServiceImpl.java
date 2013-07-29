package com.media2359.euphoria.service.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.demo.EchoDao;
import com.media2359.euphoria.view.server.demo.EchoService;

@Service("EchoService")
public class EchoServiceImpl implements EchoService {
	@Autowired
	private EchoDao echoDao;
	private final Logger log = Logger.getLogger(EchoServiceImpl.class);
	
	public String getMessage(String message) {
		log.info("Received request :"+message);
		return echoDao.getMessage(message);
	}
}
