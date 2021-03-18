package com.driveventures.service.Impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.driveventures.service.MailService;

import DBCUtils.MailException;


public class MailServiceImpl implements MailService {

	
	public void sendEmail(String to, String message) throws MailException, EmailException {
		
		SimpleEmail email = new SimpleEmail();
		
		try {
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("venturesdrive@gmail.com", "Pruebacorreo123"));
			email.setSSLOnConnect(true);
			email.setFrom("venturesdrive@gmail.com");
			email.setSubject("Daniel Gómez Matos");
			email.setMsg("Correo enviado con Java");			
			email.addTo("gomezmatosdaniel@gmail.com");
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			throw new EmailException();
		}
		
		
		
	}

	
	
	
	
}
