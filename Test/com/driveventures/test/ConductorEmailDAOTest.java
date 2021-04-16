package com.driveventures.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.model.Conductor;
import com.driveventures.model.Usuario;

import DBCUtils.DataException;

public class ConductorEmailDAOTest {

private ConductorDAOImpl  ConductorDAO= null;
	
	public ConductorEmailDAOTest() {
		ConductorDAO = new ConductorDAOImpl();

	}
	
	public void testfindByEmail() throws SQLException, DataException {
		ConductorDAOImpl ConductorDAO = new ConductorDAOImpl();
		Connection connection = DBCUtils.GetConnection.getConnection();
		try {
		
			
			Conductor c = ConductorDAO.findByEmail(connection, "gomezmatosdaniel@gmail.com");
			

			System.out.println("FindByEmail");
			
			if (c==null) {
				System.out.println("No encontrado");
			} else {
				
				System.out.println(c.toString());
			}
		} catch (SQLException e) {
			System.out.println("No se ha encontrado");
			e.printStackTrace();
			
		}
	
	}
	
	public static final void main(String args[]) throws SQLException, DataException {
		ConductorEmailDAOTest test = new ConductorEmailDAOTest();
		test.testfindByEmail();
	}
	
}
