package com.driveventures.servicestest;

import java.sql.SQLException;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.driveventures.model.Coche;
import com.driveventures.service.CocheService;
import com.driveventures.service.Impl.CocheServiceImpl;

import DBCUtils.DataException;



class CocheServiceTest {

	private static Logger logger = LogManager.getLogger(CocheServiceTest.class);

	private CocheService CocheService = null;


	public CocheServiceTest() {

		CocheService = new CocheServiceImpl();

	}

	protected void testFindById() throws SQLException, DataException {

		logger.info("Testing FindById");

		try {

			Coche c = CocheService.findById(2);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindById finished.\n");		
	}


	protected void testFindByMarca() throws SQLException, DataException {

		logger.info("Testing FindByMarca");

		try {

			Coche c = CocheService.findByMarca(2);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByMarca finished.\n");		
	}
	
	protected void testFindByPlazas() throws SQLException, DataException {

		logger.info("Testing FindByPlazas");

		try {

			Coche c = CocheService.findByPlazas(5);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByPlazas finished.\n");	
		
	}
	
	protected void testFindByAño() throws SQLException, DataException {
		
		logger.info("Testing FindByPlazas");

		try {

			Coche c = CocheService.findByAño(2001);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByPlazas finished.\n");	
		
	}
	

	public static void main(String args[]) throws DataException, SQLException {
		CocheServiceTest test = new CocheServiceTest();
		test.testFindById();
		test.testFindByMarca();
		test.testFindByPlazas();
		test.testFindByAño();

	}

}

