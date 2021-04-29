package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.daos.CocheDAO;
import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.UsuarioDAO;
import com.driveventures.daos.impl.CocheDAOImpl;
import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.daos.impl.UsuarioDAOImpl;
import com.driveventures.model.Usuario;
import com.driveventures.service.MailService;
import com.driveventures.service.UsuarioService;
import com.driveventures.velocity.MailEngineBuilder;
import com.driveventures.velocity.MapNames;
import com.driveventures.velocity.TemplatesURLs;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;
import DBCUtils.MailException;
import DBCUtils.PasswordEncryptionUtil;

public class UsuarioServiceImpl implements UsuarioService {
	
	private static Logger logger = LogManager.getLogger(UsuarioServiceImpl.class);
	private UsuarioDAO usuarioDAO = null;
	private ConductorDAO conductorDAO = null;
	private CocheDAO cocheDAO = null;
	public UsuarioServiceImpl() {
		usuarioDAO = new UsuarioDAOImpl();
		conductorDAO = new ConductorDAOImpl();
		cocheDAO = new CocheDAOImpl();
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
			if(logger.isDebugEnabled()) logger.debug("Psswd inorrecta");
			throw new DataException("Hemos detetado un problema, comprueba los datos introducidos");
		}
		
		
				
				
			} catch (SQLException e){
				logger.warn(e.getMessage(), e);
				throw new DataException(e);
			} finally {
				DBUtils.closeConnection(connection);
			}
		
	}


@Override
public Usuario create(Usuario u) throws DataException, MailException, EmailException {

	
	boolean commit = false;
	Connection c = null;
	MailService mailService = null;
	Map<String, Object> mapa = null;
	
try {
		mailService = new MailServiceImpl();
	c = GetConnection.getConnection();
	c.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	c.setAutoCommit(false);
	
	
	
	u = usuarioDAO.create(c,u);
	
	
	mapa = new HashMap<String, Object>();
	mapa.put(MapNames.NOMBRE, u.getNombre());
	String template = TemplatesURLs.WELCOME_TEMPLATE;
	String mensaje = MailEngineBuilder.createMail(template, mapa);
	mailService.sendEmail(mensaje, "Benvido a Driveventures" ,u.getEmail());
	
	commit = true;
	
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



public Usuario findById(Long id) throws DataException {
	
	Connection c = null;
	
	try {
		
		c = GetConnection.getConnection();
		c.setAutoCommit(true);
		
		Usuario u = usuarioDAO.findById(c, id); 
		
		return u;
		
	} catch (SQLException e){
		logger.warn(e.getMessage(), e);
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(c);
	}
	
}


@Override
public long delete(Long id) throws DataException {
	Connection connection = null;
    boolean commit = false;
    Long result = null;

    try {
      
        connection = GetConnection.getConnection();

        connection.setTransactionIsolation(
                Connection.TRANSACTION_READ_COMMITTED);

        connection.setAutoCommit(false);
        
        result = cocheDAO.delete(connection, id);
        		conductorDAO.delete(connection, id); 
        usuarioDAO.delete(connection, id);   
        
        commit = true;            
        return result;
        
    } catch (SQLException e) {
    	logger.warn(e.getMessage(), e);
        throw new DataException(e);

    } finally {
    	DBUtils.closeConnection(connection, commit);
    }	
}
	
}
