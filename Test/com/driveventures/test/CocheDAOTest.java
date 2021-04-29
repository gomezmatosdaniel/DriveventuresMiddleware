package com.driveventures.test;

import java.sql.Connection;


import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.impl.CocheDAOImpl;


import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;


import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class CocheDAOTest {
	
	private static Logger logger = LogManager.getLogger(CocheDAOTest.class);

	private CocheDAOImpl cocheDAO = null;
	
	public CocheDAOTest() {
		cocheDAO = new CocheDAOImpl();

	}
	
public void testFindId() throws SQLException {
	CocheDAOImpl cocheDTODAO = new CocheDAOImpl();
	Connection connection = DBCUtils.GetConnection.getConnection();
		try {
			Coche c = cocheDAO.FindById(connection, 1L);
            
			logger.debug("FindByID");
			
			if (c==null) {
				logger.error("No encontrado");
			} else {
				
				System.out.println(c.toString());
			}
		} catch (Exception e) {
			logger.info("No se ha encontrado");
			logger.error(e);
			
		}
	}
	
	public void testFindByAnho() throws SQLException {
		Connection connection = DBCUtils.GetConnection.getConnection();
		try {
			
			List<Coche> c = cocheDAO.findByAño(connection, 2017);
			
					logger.debug("FindByAnho");
			if(c==null) {
				logger.info("No encontrado");
				} else {
					System.out.println(c.toString());	
				}
			} catch (Exception e) {
				logger.info("No se ha encontrado");
				logger.error(e);
			}
	}
	
	public void testFindByMarca() throws SQLException {
		CocheDAOImpl cocheDTODAO = new CocheDAOImpl();
		Connection connection = DBCUtils.GetConnection.getConnection();
		try {
			
			List<Coche> c = cocheDTODAO.findByMarca(connection, 1);
			
			logger.debug("FindByMarca");	
			logger.info(c==null?"No encontrado":c.toString());
		} catch (Exception e) {
			logger.info("No se ha encontrado");
			logger.error(e);;
		}
	}
	
	
	public void testFindByPlazas() throws SQLException {
		Connection connection = DBCUtils.GetConnection.getConnection();
		CocheDAOImpl cocheDTODAO = new CocheDAOImpl();
		
		try {
			
			List<Coche> c = cocheDTODAO.findByPlazas(connection, 5);

			logger.debug("FindByPlazas");
	if(c==null) {
		logger.info("No encontrado");
		} else {
			System.out.println(c.toString());	
		}
	} catch (Exception e) {
		logger.info("No se ha encontrado");
		logger.error(e);
			
		}
	}
	
	public void testCreate() throws DataException, SQLException {
		Coche c = new Coche();
		Connection connection = DBCUtils.GetConnection.getConnection();
		Conductor conductor = new Conductor();
		c.setNombre("Mercedes");
		c.setFechaMatriculacion(2020);
		c.setPlazas(5);
		c.setMatricula("3007 SCH");
		c.setIdModelo(7L);
		c.setIdConductor(67L);

		c = cocheDAO.add(null, c);
		System.out.println("Coche"+ c.getId()+ " creado");
	}
	
	
	public void testDelete() throws DataException, SQLException {
		
		CocheDAOImpl UsuarioDAO = new CocheDAOImpl();
		Connection conn = null;
		conn = GetConnection.getConnection();
		long id = 67;
		id = UsuarioDAO.delete(conn, 67l);
		System.out.println("Se elimino el coche con id "+id);
		
	}
	
	
	public static final void main(String args[]) throws DataException, SQLException {
		CocheDAOTest test = new CocheDAOTest();
		test.testFindId();
		test.testFindByAnho();
		test.testFindByMarca();
		test.testFindByPlazas();
		test.testCreate();
		test.testDelete();
	}
}
	

