package com.driveventures.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.impl.CocheDAOImpl;
import com.driveventures.daos.impl.CocheDTODAOImpl;
import com.driveventures.model.Coche;
import com.driveventures.model.CocheDTO;
import com.driveventures.model.Conductor;
import com.driveventures.model.Usuario;

import DBCUtils.DataException;

public class CocheDAOTest {
	
	private static Logger logger = LogManager.getLogger(CocheDAOTest.class);

	private CocheDAOImpl cocheDAO = null;
	
	public CocheDAOTest() {
		cocheDAO = new CocheDAOImpl();

	}
	
public void testFindId() {
	CocheDTODAOImpl cocheDTODAO = new CocheDTODAOImpl();
		try {
		
			CocheDTO c = cocheDTODAO.FindById(1);
            
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
	
	public void testFindByAnho() {
		
		try {
			
			Coche c = cocheDAO.findByAño(2017);
			
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
	
	public void testFindByMarca() {
		CocheDTODAOImpl cocheDTODAO = new CocheDTODAOImpl();
		
		try {
			
			Coche c = cocheDTODAO.findByMarca(1);
			
			logger.debug("FindByMarca");	
			logger.info(c==null?"No encontrado":c.toString());
		} catch (Exception e) {
			logger.info("No se ha encontrado");
			logger.error(e);;
		}
	}
	
	
	public void testFindByPlazas() {
		
		CocheDTODAOImpl cocheDTODAO = new CocheDTODAOImpl();
		
		try {
			
			Coche c = cocheDTODAO.findByPlazas(5);

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
	
	public void testCreate() throws DataException {
		Coche c = new Coche();
		Usuario u = new Usuario();
		Conductor conductor = new Conductor();
		c.setNombreModelo("Mercedes");
		c.setFechaMatriculacion(2020);
		c.setPlazas(5);
		c.setMatricula("3007 SCH");
		c.setIdModelo(7L);
		c.setId(9);
		u.setId(67L);

		c = cocheDAO.add(c);
		System.out.println("Coche"+ c.getId()+ " creado");
	}
	
	public static final void main(String args[]) throws DataException {
		CocheDAOTest test = new CocheDAOTest();
		//test.testFindId();
		//test.testFindByAnho();
		//test.testFindByMarca();
		//test.testFindByPlazas();
		test.testCreate();
	}
}
	

