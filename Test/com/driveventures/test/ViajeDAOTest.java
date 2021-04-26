package com.driveventures.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.impl.ViajeDAOImpl;
import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
import com.driveventures.model.Viaje;

import DBCUtils.DataException;

public class ViajeDAOTest {

	
	private static Logger logger = LogManager.getLogger(CocheDAOTest.class);

	private ViajeDAOImpl viajeDAO = null;
	
	public ViajeDAOTest() {
		viajeDAO = new ViajeDAOImpl();

	}
	
	
	public void testCreate() throws DataException, SQLException {
		Viaje v = new Viaje();
		Connection connection = DBCUtils.GetConnection.getConnection();
		
		v.setIdconductor(4);
		v.setIdpasajero(3);
		v.setLatitudinicial(-14.0096);
		v.setLongitudinicial(59.9973);
		v.setLatitudfinal(27.8691);
		v.setLongitudfinal(158.5541);
		v.setDireccion("Lugo");

		v = viajeDAO.create(connection , v);
		System.out.println("Viaje "+ v.getId()+ " creado");
	}
	
	public static final void main(String args[]) throws DataException, SQLException {
		ViajeDAOTest test = new ViajeDAOTest();
		//test.testFindId();
		//test.testFindByAnho();
		//test.testFindByMarca();
		//test.testFindByPlazas();
		test.testCreate();
	}
	
}
