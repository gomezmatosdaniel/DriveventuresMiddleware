package com.driveventures.service;

import com.driveventures.model.Usuario;

import DBCUtils.DataException;

public interface UsuarioService {

	public Usuario findById(int id) throws DataException;
	
	public Usuario login(String email, String password) throws DataException;
	
	public Usuario create(Usuario u) throws DataException;
	
	public void update(Usuario u) throws DataException;
}
