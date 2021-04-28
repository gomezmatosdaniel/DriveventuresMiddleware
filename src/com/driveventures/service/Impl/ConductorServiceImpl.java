package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.UsuarioDAO;
import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.daos.impl.UsuarioDAOImpl;
import com.driveventures.model.Conductor;
import com.driveventures.service.ConductorService;
import com.driveventures.service.MailService;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;
import DBCUtils.PasswordEncryptionUtil;

public class ConductorServiceImpl implements ConductorService {

	private static Logger logger = LogManager.getLogger(ConductorServiceImpl.class);
	
	public ConductorDAO conductorDAO = null;
	public UsuarioDAO usuarioDAO = null;

	public ConductorServiceImpl() {
		conductorDAO = new ConductorDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
	}


	public List <Conductor> findByViajes(int viajes) throws DataException, SQLException {
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return conductorDAO.findByViajes(conn, viajes);

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


	@Override
	public List<Conductor> findByBuenaConversacion(int buenaconversacion) throws DataException, SQLException {
		Connection conn = null;

		try {

			conn = GetConnection.getConnection();

			return conductorDAO.findByBuenaConversacion(conn, buenaconversacion);

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


@Override
public List<Conductor> findByBuenaRuta(int buenaruta) throws DataException, SQLException {
	Connection conn = null;

	try {

		conn = GetConnection.getConnection();

		return conductorDAO.findByBuenaRuta(conn, buenaruta);

	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
}



public List<Conductor> findByExcelenteServicio(int excelenteservicio) throws DataException, SQLException {
	
	Connection conn = null;
	
	try {
		
		conn = GetConnection.getConnection();
		
		return conductorDAO.findByExcelenteServicio(conn, excelenteservicio);
		
	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
	}


@Override
public Conductor create(Conductor co) throws Exception {
	boolean commit = false;
	Connection c = null;
	MailService mailService = null;
	Map<String, Object> mapa = null;
	
try {
		mailService = new MailServiceImpl();
	c = GetConnection.getConnection();
	c.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	c.setAutoCommit(false);
	
	
	
	co = conductorDAO.create(c, co);
	
	
	
	commit = true;
	
	return co;
	
} catch (SQLException e){
	logger.warn(e.getMessage(), e);
	throw new DataException(e);
} finally {
	DBUtils.closeConnection(c,commit);
}
}


@Override
public List<Conductor> findByResidencia(String Residencia) throws DataException, SQLException {
	Connection conn = null;

	try {

		conn = GetConnection.getConnection();

		return conductorDAO.findByResidencia(conn, Residencia);

	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
}


public Conductor login(String email, String password) throws DataException {
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
	
	Conductor c = conductorDAO.findByEmail(connection, email);
	
	if(c == null) {
		return c;
	} 
	
	if(PasswordEncryptionUtil.checkPassword(password, c.getPassword())) {
		logger.debug("Conductor "+c.getEmail()+" autenticado!");
		return c;
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
public List<Conductor> findByAñosExp(int anhos_experiencia) throws DataException, SQLException {
	Connection conn = null;

	try {

		conn = GetConnection.getConnection();

		return conductorDAO.findByBuenaRuta(conn, anhos_experiencia);

	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
}


@Override
public long delete(Long id) throws DataException, Exception {
	Connection connection = null;
    boolean commit = false;
    Long result = null;

    try {
      
        connection = GetConnection.getConnection();

        connection.setTransactionIsolation(
                Connection.TRANSACTION_READ_COMMITTED);

        connection.setAutoCommit(false);
        
        result = conductorDAO.delete(connection, id);  
        
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
