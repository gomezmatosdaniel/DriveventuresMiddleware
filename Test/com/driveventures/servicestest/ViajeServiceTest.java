package com.driveventures.servicestest;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.model.Viaje;
import com.driveventures.service.ViajeService;
import com.driveventures.service.Impl.ViajeServiceImpl;

import DBCUtils.DataException;


public class ViajeServiceTest {

	private static Logger logger = LogManager.getLogger(CocheServiceTest.class);

	private ViajeService ViajeService = null;


	public ViajeServiceTest() {

		ViajeService = new ViajeServiceImpl();

	}
	
	protected void testCreate() throws SQLException, DataException {
		
		logger.info("Testing Create Viaje");
		
		Viaje v = new Viaje();
		
		v.setIdconductor(4);
		v.setIdpasajero(3);
		v.setLatitudinicial(-14.0096);
		v.setLongitudinicial(59.9973);
		v.setLatitudfinal(27.8691);
		v.setLongitudfinal(158.5541);
		v.setDireccion("Lugo");
		
		
		ViajeService.create(v);
		logger.info(v +"creado");

	}
	
	
	public static void main(String args[]) throws DataException, SQLException {
		ViajeServiceTest test = new ViajeServiceTest();
		test.testCreate();
	}
	
}
