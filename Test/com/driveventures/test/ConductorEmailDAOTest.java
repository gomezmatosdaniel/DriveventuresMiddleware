package com.driveventures.test;

import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.model.Conductor;
import com.driveventures.model.Usuario;

public class ConductorEmailDAOTest {

private ConductorDAOImpl  ConductorDAO= null;
	
	public ConductorEmailDAOTest() {
		ConductorDAO = new ConductorDAOImpl();

	}
	
	public void testfindByEmail() {
		ConductorDAOImpl ConductorDAO = new ConductorDAOImpl();
		try {
		
			
			Conductor c = ConductorDAO.findByEmail("gabriel2@gmail.com");
			

			System.out.println("FindByEmail");
			
			if (c==null) {
				System.out.println("No encontrado");
			} else {
				
				System.out.println(c.toString());
			}
		} catch (Exception e) {
			System.out.println("No se ha encontrado");
			e.printStackTrace();
			
		}
	
	}
	
	public static final void main(String args[]) {
		ConductorEmailDAOTest test = new ConductorEmailDAOTest();
		test.testfindByEmail();
	}
	
}
