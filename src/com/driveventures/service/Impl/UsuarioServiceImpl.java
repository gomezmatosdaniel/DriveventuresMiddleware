package com.driveventures.service.Impl;

import java.sql.Connection;


import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.daos.UsuarioDAO;
import com.driveventures.daos.impl.UsuarioDAOImpl;
import com.driveventures.model.Usuario;
import com.driveventures.service.UsuarioService;


import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;
import DBCUtils.PasswordEncryptionUtil;

public class UsuarioServiceImpl implements UsuarioService {
	
	private static Logger logger = LogManager.getLogger(UsuarioServiceImpl.class);
	private UsuarioDAO usuarioDAO = null;
	
	public UsuarioServiceImpl() {
		usuarioDAO = new UsuarioDAOImpl();
	}
	
	
public Usuario login(String email, String password) throws DataException {
		
	if(logger.isDebugEnabled()) {
			logger.debug("Email = {}, contraseña = {}", email, (password == null));
		}
		
		Connection connection = null;
		
	try {
		connection = GetConnection.getConnection();
		connection.setAutoCommit(true);
		
		
		
		if( email == null ) {
			return null;
		}
		
		if( password == null ) {
			return null;
		}
		
		Usuario u = usuarioDAO.findByEmail(connection, email);
		
		if(u == null) {
			return u;
		} 
		
		if(PasswordEncryptionUtil.checkPassword(password, u.getPassword())) {
			logger.debug("Usuario "+u.getEmail()+" autenticado!");
			return u;
		} else {
			return null;
		}
		
		
				
				
			} catch (SQLException e){
				logger.warn(e.getMessage(), e);
				throw new DataException(e);
			} finally {
				DBUtils.closeConnection(connection);
			}
		
	}


@Override
public Usuario create(Usuario u) throws DataException {

	
	boolean commit = false;
	Connection c = null;
	
try {
	c = GetConnection.getConnection();
	c.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	c.setAutoCommit(false);
	
	
	
	u = usuarioDAO.create(c,u);
	
	
	commit=true;
	
	return u;
	
} catch (SQLException e){
	logger.warn(e.getMessage(), e);
	throw new DataException(e);
} finally {
	DBUtils.closeConnection(c,commit);
}
}


@Override
public void update(Usuario u) throws DataException {
	Connection connection = null;
    boolean commit = false;

    try {
      
        connection = GetConnection.getConnection();

        connection.setTransactionIsolation(
                Connection.TRANSACTION_READ_COMMITTED);

        connection.setAutoCommit(false);

        usuarioDAO.update(connection,u);
        commit = true;
        
    } catch (SQLException e) {
    	logger.warn(e.getMessage(), e);
        throw new DataException(e);

    } finally {
    	DBUtils.closeConnection(connection, commit);
    }
	
}
	
}
