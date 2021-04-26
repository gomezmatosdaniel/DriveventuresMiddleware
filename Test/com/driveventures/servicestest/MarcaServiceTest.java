package com.driveventures.servicestest;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.MarcaDAO;
import com.driveventures.daos.impl.MarcaDAOImpl;
import com.driveventures.model.Marca;
import com.driveventures.service.Impl.MarcaServiceImpl;

import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class MarcaServiceTest {
	
	
	private static Logger logger = LogManager.getLogger(MarcaServiceTest.class);

	private MarcaServiceImpl marcaService = null;

	public MarcaDAO marcaDAO = null;
	public MarcaServiceTest() {
		marcaService = new MarcaServiceImpl();
		marcaDAO = new MarcaDAOImpl();
	}
	
	
	protected void testFindById() throws Exception {

		logger.info("Testing FindById");

		Connection conn = null;
		try {
			conn = GetConnection.getConnection();

			List<Marca> c = marcaService.findAll(conn);			
			logger.info(c);

		} catch (DataException t) {
			logger.error(t);
		}

		logger.info("Test testFindById finished.\n");		
	}
	
	public static void main(String args[]) throws Exception {
		MarcaServiceTest test = new MarcaServiceTest();

		test.testFindById();

	}

}
