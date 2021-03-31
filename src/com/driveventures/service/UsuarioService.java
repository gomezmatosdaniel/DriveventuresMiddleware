package com.driveventures.service;

import org.apache.commons.mail.EmailException;

import com.driveventures.model.Usuario;

import DBCUtils.DataException;
import DBCUtils.MailException;

public interface UsuarioService {

	public Usuario findById(int id) throws DataException;
	
	public Usuario login(String email, String password) throws DataException;
	
	public Usuario create(Usuario u) throws DataException, MailException, EmailException;
	
	public void update(Usuario u) throws DataException;
	
	public long delete(Long id) throws DataException;
}
