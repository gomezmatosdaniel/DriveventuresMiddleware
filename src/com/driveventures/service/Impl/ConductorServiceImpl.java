package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.model.Conductor;
import com.driveventures.service.ConductorService;
import com.driveventures.service.MailService;
import com.driveventures.velocity.MailEngineBuilder;
import com.driveventures.velocity.MapNames;
import com.driveventures.velocity.TemplatesURLs;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class ConductorServiceImpl implements ConductorService {

	private static Logger logger = LogManager.getLogger(ConductorServiceImpl.class);
	
	public ConductorDAO dao = null;

	public ConductorServiceImpl() {
		dao = new ConductorDAOImpl();
	}


	public Conductor findByViajes(int viajes) throws DataException, SQLException {
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByViajes(viajes);

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

			return dao.findByBuenaConversacion(buenaconversacion);

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

		return dao.findByBuenaRuta(buenaruta);

	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
}


@Override
public List<Conductor> findByExcelenteServicio(int excelenteservicio) throws DataException, SQLException {
	
	Connection conn = null;
	
	try {
		
		conn = GetConnection.getConnection();
		
		return dao.findByExcelenteServicio(excelenteservicio);
		
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
	
	
	
	co = dao.create(c, co);
	
	
	mapa = new HashMap<String, Object>();
	mapa.put(MapNames.NOMBRE, co.getNombre());
	String template = TemplatesURLs.WELCOME_TEMPLATE;
	String mensaje = MailEngineBuilder.createMail(template, mapa);
	mailService.sendEmail(mensaje, "Benvido a Driveventures" ,co.getEmail());
	
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

		return dao.findByResidencia(conn, Residencia);

	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
}
	
	
}
