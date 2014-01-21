package com.media2359.euphoria.service.email;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;

import com.ibm.icu.impl.Assert;
import com.postmark.PostmarkMailSender;

public class EmailServiceTest {
	EmailService service;

	static final String TEST_API_KEY = "aa239d6c-c104-4262-b1d1-5c809fd818c4";

	static final String VALID_EMAIL = "info@postmark.com";
	static final String INVALID_EMAIL = "test-exemple.com";

	@Before
	public void initialize() {
		service = new EmailService();
	}

	public void testSendEmail() {
		try {
			service.sendEmail("alfredisfun@gmail.com", "Test subject",
					"This is a test message");
		} catch (AddressException e) {
			Assert.fail(e);
		} catch (MessagingException e) {
			Assert.fail(e);
		}
	}

	@Test
	public void testSendEmailPostmark() {

		PostmarkMailSender mailSender = new PostmarkMailSender(TEST_API_KEY);
		
		Logger.getLogger("com.postmark").setLevel(Level.FINEST);

		SimpleMailMessage m = new SimpleMailMessage();
		m.setFrom("alfredisfun@gmail.com");
		m.setTo("alfredisfun@gmail.com");
		m.setSubject("Test Mail");
		m.setText("This is the body");
		mailSender.send(m);
	}
}
