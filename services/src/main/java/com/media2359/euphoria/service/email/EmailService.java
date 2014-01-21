package com.media2359.euphoria.service.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class EmailService {
	private final Logger log = Logger.getLogger(EmailService.class);
	
	public void sendEmail(String recipient, String subject, String message) throws AddressException,
			MessagingException {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;

		// Sender's email ID needs to be mentioned
		String from = "info@postmarkapp.com";

		// Assuming you are sending email from localhost
		String host = "smtp.postmarkapp.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "2525");

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("aa239d6c-c104-4262-b1d1-5c809fd818c4", "aa239d6c-c104-4262-b1d1-5c809fd818c4");
			}
		};

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties, auth);

		// Create a default MimeMessage object.
		MimeMessage mimeMessage = new MimeMessage(session);

		// Set From: header field of the header.
		mimeMessage.setFrom(new InternetAddress(from));

		// Set To: header field of the header.
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(
				to));

		// Set Subject: header field
		mimeMessage.setSubject(subject);

		// Now set the actual message
		mimeMessage.setText(message);

		// Send message
		Transport.send(mimeMessage);
		
		log.info("Sent email to "+recipient+" successfully!");
	}
}
