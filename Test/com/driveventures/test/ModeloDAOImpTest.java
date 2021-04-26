package com.driveventures.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.impl.ModeloDAOImpl;
import com.driveventures.model.Modelo;

public class ModeloDAOImpTest {
	
	private static Logger logger = LogManager.getLogger(ModeloDAOImpTest.class);
	
	private ModeloDAOImpl modeloDAOImpl = null;
	
	
	public ModeloDAOImpTest() { 
		modeloDAOImpl = new ModeloDAOImpl();
	}
	
	public void testFindByMarca() throws SQLException {
		ModeloDAOImpl modeloDAO = new ModeloDAOImpl();
		Connection connection = DBCUtils.GetConnection.getConnection();
		try {

			List<Modelo> co = modeloDAO.findAll(connection);

			logger.debug("FindByMarca");

			if (co==null) {
				logger.error("No encontrado");
			} else {

				System.out.println(co.toString());
			}
		} catch (Exception e) {
			logger.error("No se ha encontrado");
			e.printStackTrace();

		}
	}
	
	public static final void main(String args[]) throws SQLException {
		ModeloDAOImpTest test = new ModeloDAOImpTest();
		test.testFindByMarca();
	}
	
}
