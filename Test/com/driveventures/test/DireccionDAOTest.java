package com.driveventures.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.impl.DireccionDTODAOImpl;

import com.driveventures.model.DireccionDTO;

public class DireccionDAOTest {

	private static Logger logger = LogManager.getLogger(DireccionDAOTest.class);

	private DireccionDTODAOImpl DireccionDAO = null;

	public DireccionDAOTest() {
		DireccionDAO = new DireccionDTODAOImpl();

	}

	public void testFindByCiudad() {
		DireccionDTODAOImpl DireccionDTODAO = new DireccionDTODAOImpl();
		try {

			DireccionDTO d = DireccionDTODAO.findByUsuario(1);

			logger.debug("FindByID");

			if (d==null) {
				logger.error("No encontrado");
			} else {

				System.out.println(d.toString());
			}
		} catch (Exception e) {
			logger.info("No se ha encontrado");
			logger.error(e);

		}
	}

	public static final void main(String args[]) {
		DireccionDAOTest test = new DireccionDAOTest();
		test.testFindByCiudad();
	}


}
