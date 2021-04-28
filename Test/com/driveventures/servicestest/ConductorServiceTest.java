package com.driveventures.servicestest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.model.Conductor;
import com.driveventures.service.Results;
import com.driveventures.service.Impl.ConductorServiceImpl;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

class ConductorServiceTest {

	private static Logger logger = LogManager.getLogger(ConductorServiceTest.class);

	private ConductorServiceImpl ConductorService = null;

	public ConductorDAO conductorDAO = null;
	public ConductorServiceTest() {
		ConductorService = new ConductorServiceImpl();
		conductorDAO = new ConductorDAOImpl();
	}

	protected void testFindByViajes() throws Exception {

		logger.info("Testing FindById");

		try {

			List<Conductor> c = ConductorService.findByViajes(2);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByViajes finished.\n");		
	}
	
	protected void testFindByBuenaRuta() throws DataException, SQLException {

		logger.info("Testing FindByBuenaRuta");

		try {

			List<Conductor> c = ConductorService.findByBuenaRuta(10);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByBuenaRuta finished.\n");		
	}
	
	protected void testFindByBuenaConversacion() throws DataException, SQLException {

		logger.info("Testing FindByBuenaConversacion");

		try {

			List<Conductor> c = ConductorService.findByBuenaConversacion(10);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByBuenaConversacion finished.\n");		
	}
	
	
	protected void testFindByResidencia() throws DataException, SQLException {

		logger.info("Testing FindByBuenaConversacion");

		try {

			List<Conductor> c = ConductorService.findByResidencia("Lugo");			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByBuenaConversacion finished.\n");		
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

	
	
public void testCreate() throws Exception {
		
		Conductor u = new Conductor();
		u.setUser_id(97L);
		u.setDni("34290427A");
		u.setResidencia("Lugo");
		u.setIdioma_principal("Español");
		try {
			ConductorService.create(u);
		} catch (DataException e) {
			e.printStackTrace();
		}
		System.out.println(u);
	}

public void testLogin() throws DataException {
	ConductorService.login("gomezmatosdaniel@gmail.com", "1234");
	
}
	
	public static void main(String args[]) throws Exception {
		ConductorServiceTest test = new ConductorServiceTest();
		//test.testFindByViajes();
		//test.testFindByBuenaRuta();
		//test.testFindByBuenaConversacion();
		//test.testFindByExcelenteServicio();
		test.testCreate();
		//test.testLogin();
		//test.testFindByResidencia();

	}
}