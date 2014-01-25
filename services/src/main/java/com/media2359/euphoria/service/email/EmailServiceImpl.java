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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.postmark.PostmarkMailSender;

/**
 * Added  logic to send email
*
* @author AJ
* @version 1.0
*
 */
@Service("EmailService")
public class EmailServiceImpl implements EmailService {
	private static final String POSTMARK_API_KEY = "POSTMARK_API_KEY";
	private static final String SENDER_EMAIL = "SENDER_EMAIL";
	private final Logger log = Logger.getLogger(EmailService.class);
	
	String postMarkApiKey = null;
	String senderEmail = null;
	
	public EmailServiceImpl() {
		postMarkApiKey = System.getenv(POSTMARK_API_KEY);
		senderEmail = System.getenv(SENDER_EMAIL);	
	}
	
	public void sendEmail(String[] recipients, String subject, String body) {
		sendEmail_JSON(recipients, subject, body);
	}
	
	public void sendEmail_JSON(String[] recipients, String subject, String body) {
		log.info("Sending email using "+senderEmail+" and "+postMarkApiKey);
		if(postMarkApiKey==null || senderEmail==null) {
			log.fatal("Cannot send email as postMarkApiKey or Sender email is null");
			return;
		}
		
		log.info("Sending email ...");
		
		PostmarkMailSender mailSender = new PostmarkMailSender(postMarkApiKey);

		SimpleMailMessage m = new SimpleMailMessage();
		m.setFrom(senderEmail);
		m.setTo(recipients);
		m.setSubject(subject);
		m.setText(body);
		mailSender.send(m);		
		
		log.info("Sent email to "+recipients+" successfully!");
	}
	
	public void sendEmail_SMTP(String recipient, String subject, String message) throws AddressException,
			MessagingException {
		// Recipient's email ID needs to be mentioned.
		String to = recipient;

		// Sender's email ID needs to be mentioned
		String from = "a0079972@nus.edu.sg";

		// Assuming you are sending email from localhost
		String host = "smtp.postmarkapp.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "25");

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

	public String getPostMarkApiKey() {
		return postMarkApiKey;
	}

	public void setPostMarkApiKey(String postMarkApiKey) {
		this.postMarkApiKey = postMarkApiKey;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
}
