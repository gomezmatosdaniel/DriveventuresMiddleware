package com.driveventures.test;

import java.sql.Connection;

import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.model.Conductor;
import com.driveventures.model.Usuario;

import DBCUtils.GetConnection;

public class PruebaCreateConductor {

	
private ConductorDAOImpl conductorDAO = null;
	
	public void PruebaCreate() {
		
		conductorDAO = new ConductorDAOImpl();

	}
	
	public void testCreate() throws Exception {
		System.out.println("Testing create ...");
		
		
		Conductor c = new Conductor();
		Connection conn = null;
		conn = GetConnection.getConnection();
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		conn.setAutoCommit(false);
		c.setNombre("RamoN");
		c.setNumviajes(0);
		c.setAnosexp(0);
		c.setDni("3273738A");
		c.setResidencia("Lugo");
		c.setBuenaconversacion(0);
		c.setBuenaruta(0);
		c.setExcelenteserviscio(0);
		c.setIdioma_id(1);
		c = conductorDAO.create(conn, c);
		System.out.println("Cuidador "+ c.getId()+ " creado");
	}
	
	public static final void main(String args[]) throws Exception {
		PruebaCreateConductor test = new PruebaCreateConductor();
		test.testCreate();
	}
	
}
