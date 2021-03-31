package com.driveventures.service.Impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.driveventures.service.MailService;

import DBCUtils.MailException;


public class MailServiceImpl implements MailService {

	
	public void sendEmail(String message, String subject, String to) throws MailException, EmailException {
		
		
		
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("venturesdrive@gmail.com", "Pruebacorreo123"));
			email.setSSLOnConnect(true);
			email.setFrom("venturesdrive@gmail.com");
			email.setSubject(subject);
			email.setMsg(message);			
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new EmailException();
		}
		
		
		
	}

	
	
	
	
}
