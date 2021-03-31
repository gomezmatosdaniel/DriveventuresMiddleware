package com.driveventures.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.model.Conductor;

public class ConductorDAOImplTest {

	private static Logger logger = LogManager.getLogger(ConductorDAOImplTest.class);

	private ConductorDAOImpl  ConductorDAO= null;

	public ConductorDAOImplTest() {
		ConductorDAO = new ConductorDAOImpl();

	}

	public void testFindId() {
		ConductorDAOImpl ConductorDAO = new ConductorDAOImpl();
		try {

			Connection connection = DBCUtils.GetConnection.getConnection();
			Conductor co = ConductorDAO.findById(connection, 1);

			logger.debug("FindByID");

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

	public void testFindViajes() {
		ConductorDAOImpl ConductorDAO = new ConductorDAOImpl();
		try {

			Conductor co = ConductorDAO.findByViajes(10);

			logger.debug("FindByViajes");

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

	public void testFindByBuenaConversacion() {
		ConductorDAOImpl ConductorDAO = new ConductorDAOImpl();
		try {

			List<Conductor> co = ConductorDAO.findByBuenaConversacion(20);

			logger.debug("FindByBuenaConversacion");

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

	public void testFindByBuenaRuta() {
		ConductorDAOImpl ConductorDAO = new ConductorDAOImpl();
		try {

			List<Conductor> co = ConductorDAO.findByBuenaRuta(10);

			logger.debug("FindByBuenRuta");

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

	public void testFindByResidencia() throws SQLException {
		
		ConductorDAOImpl ConductorDAO = new ConductorDAOImpl();
		Connection connection = DBCUtils.GetConnection.getConnection();
		try {

			List<Conductor> co = ConductorDAO.findByResidencia(connection, "L");

			logger.debug("FindByResidencia");

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
		ConductorDAOImplTest test = new ConductorDAOImplTest();
		test.testFindId();
		test.testFindViajes();
		test.testFindByBuenaConversacion();
		test.testFindByBuenaRuta();
		test.testFindByResidencia();

	}

}
