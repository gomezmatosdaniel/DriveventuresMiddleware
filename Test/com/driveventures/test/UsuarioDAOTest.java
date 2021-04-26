package com.driveventures.test;

import java.sql.Connection;
import java.sql.SQLException;

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
	
	public void testFindById() throws SQLException {
		UsuarioDAOImpl UsuarioDAO = new UsuarioDAOImpl();
	
		try {
		
			Connection connection = DBCUtils.GetConnection.getConnection();
			Usuario u = UsuarioDAO.findById(connection, 1L);
					
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
	
	public void testDelete() throws DataException, SQLException {
		UsuarioDAOImpl UsuarioDAO = new UsuarioDAOImpl();
		Connection conn = null;
		conn = GetConnection.getConnection();
		long id = 44;
		id = UsuarioDAO.delete(conn, 44l);
		System.out.println("Se elimino el usuario con id "+id);

		}
	
	public static final void main(String args[]) throws DataException, SQLException {
		UsuarioDAOTest test = new UsuarioDAOTest();
		//test.testfindByEmail();
		test.testFindById();
	}
	
}
