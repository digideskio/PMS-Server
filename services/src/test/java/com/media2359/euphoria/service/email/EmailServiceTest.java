package com.media2359.euphoria.service.email;

import org.junit.Before;
import org.junit.Test;

public class EmailServiceTest {
	EmailServiceImpl service;

	static final String TEST_API_KEY = "aa239d6c-c104-4262-b1d1-5c809fd818c4";

	static final String VALID_EMAIL = "a0079972@nus.edu.sg";
	static final String INVALID_EMAIL = "test-exemple.com";

	@Before
	public void initialize() {
		
		service = new EmailServiceImpl();
		service.setPostMarkApiKey(TEST_API_KEY);
		service.setSenderEmail(VALID_EMAIL);
	}

	
	public void testSendValidEmail() {
		service.sendEmail(new String[]{"alfredisfun@gmail.com"}, "Test subject",
					"This is a test message");
	}
}
