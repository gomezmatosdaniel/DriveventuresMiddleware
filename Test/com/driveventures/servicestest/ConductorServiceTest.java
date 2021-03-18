package com.driveventures.servicestest;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.model.Conductor;

import com.driveventures.service.Impl.ConductorServiceImpl;

import DBCUtils.DataException;

class ConductorServiceTest {

	private static Logger logger = LogManager.getLogger(ConductorServiceTest.class);

	private ConductorServiceImpl ConductorService = null;


	public ConductorServiceTest() {
		ConductorService = new ConductorServiceImpl();

	}

	protected void testFindByViajes() throws Exception {

		logger.info("Testing FindById");

		try {

			Conductor c = ConductorService.findByViajes(2);			
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
	
	protected void testFindByExcelenteServicio() throws DataException, SQLException {

		logger.info("Testing FindByExcelenteServicio");

		try {

			List<Conductor> c = ConductorService.findByExcelenteServicio(10);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByExcelenteServicio finished.\n");		
	}
	
	public static void main(String args[]) throws Exception {
		ConductorServiceTest test = new ConductorServiceTest();
		test.testFindByViajes();
		test.testFindByBuenaRuta();
		test.testFindByBuenaConversacion();
		test.testFindByExcelenteServicio();

	}
}