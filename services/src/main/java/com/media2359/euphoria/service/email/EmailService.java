package com.media2359.euphoria.service.email;

/**
 *
* EmailService to send email to recipients using PostMark Server
*
* @author AJ
* @version 1.0
*
 */
public interface EmailService {
	/**
	 * Send email to some recipients
	 *
	 * @returns void
	 */
	public void sendEmail(String[] recipients, String subject, String body) ;	
}
