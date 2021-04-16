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
		c.setUser_id(12L);
		c.setDni("3273738A");
		c.setResidencia("Lugo");
		c.setIdioma_principal("Español");
		c = conductorDAO.create(conn, c);
		System.out.println("Cuidador "+ c.getId()+ " creado");
	}
	
	public static final void main(String args[]) throws Exception {
		PruebaCreateConductor test = new PruebaCreateConductor();
		test.testCreate();
	}
	
}
