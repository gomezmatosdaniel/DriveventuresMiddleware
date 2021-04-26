package com.driveventures.daos;


import java.sql.Connection;

import com.driveventures.model.Usuario;

import DBCUtils.DataException;

public interface UsuarioDAO {


	public Usuario findByEmail(Connection connection, String email) throws DataException;

	public Usuario findById(Connection connection, Long id) throws DataException;
	
	public Usuario create(Connection connection, Usuario usuario) throws DataException;

	public void update(Connection connection, Usuario usuario) throws DataException;
	
	public long delete(Connection connection, Long id) throws DataException;

    
}
