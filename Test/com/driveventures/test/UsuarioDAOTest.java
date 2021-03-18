package com.driveventures.test;

import com.driveventures.daos.impl.UsuarioDAOImpl;
import com.driveventures.model.Usuario;
import com.driveventures.service.UsuarioService;

import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class UsuarioDAOTest {
	
	private UsuarioService usuarioService = null;

	
private UsuarioDAOImpl  UsuarioDAO= null;
	
	public UsuarioDAOTest() {
		UsuarioDAO = new UsuarioDAOImpl();

	}
	
	public void testfindByEmail() {
		UsuarioDAOImpl UsuarioDAO = new UsuarioDAOImpl();
		try {
		
			
			Usuario u = UsuarioDAO.findByEmail(null, "gabriel2@gmail.com");

			System.out.println("FindByEmail");
			
			if (u==null) {
				System.out.println("No encontrado");
			} else {
				
				System.out.println(u.toString());
			}
		} catch (Exception e) {
			System.out.println("No se ha encontrado");
			e.printStackTrace();
			
		}
	
	}
	
	public static final void main(String args[]) throws DataException {
		UsuarioDAOTest test = new UsuarioDAOTest();
		test.testfindByEmail();
	}
	
}
