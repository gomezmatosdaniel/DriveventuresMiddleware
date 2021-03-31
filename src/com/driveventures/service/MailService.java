package com.driveventures.service;

import org.apache.commons.mail.EmailException;

import DBCUtils.MailException;

public interface MailService {

	
	public void sendEmail(String message, String subject, String to) throws MailException, EmailException;
	
	
}
