package com.driveventures.servicestest;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
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

			Coche c = CocheService.findById(2L);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindById finished.\n");		
	}


	protected void testFindByMarca() throws SQLException, DataException {

		logger.info("Testing FindByMarca");

		try {

			List<Coche> c = CocheService.findByMarca(2);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByMarca finished.\n");		
	}
	
	protected void testFindByPlazas() throws SQLException, DataException {

		logger.info("Testing FindByPlazas");

		try {

			List<Coche> c = CocheService.findByPlazas(5);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByPlazas finished.\n");	
		
	}
	
	protected void testFindByAño() throws SQLException, DataException {
		
		logger.info("Testing FindByPlazas");

		try {

			List<Coche> c = CocheService.findByAño(2001);			
			logger.debug(c.toString());

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindByPlazas finished.\n");	
		
	}
	
	protected void testAdd() throws SQLException, DataException {
		
		logger.info("Testing Add");

Coche c = new Coche();
		

		c.setNombre("Mercedes");
		c.setFechaMatriculacion(2020);
		c.setPlazas(5);
		c.setMatricula("3007 SCH");
		c.setIdModelo(7L);
		c.setIdConductor(67L);

		CocheService.registrar(c);
		logger.info(c+"creado");
	}
	
	protected void testDelete() throws DataException, SQLException {
		
		logger.info("Testing Delete");
		
		long id = 67;
		id = CocheService.delete(id);
		System.out.println("Se borró el coche con id de usuario: "+id);
	}


	public static void main(String args[]) throws DataException, SQLException {
		CocheServiceTest test = new CocheServiceTest();
		test.testFindById();
		//test.testFindByMarca();
		//test.testFindByPlazas();
		//test.testFindByAño();
		//test.testAdd();
		//test.testDelete();
	}

}

