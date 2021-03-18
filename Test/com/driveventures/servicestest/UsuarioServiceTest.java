package com.driveventures.servicestest;

import java.util.Date;

import com.driveventures.model.Usuario;
import com.driveventures.service.UsuarioService;
import com.driveventures.service.Impl.UsuarioServiceImpl;

import DBCUtils.DataException;

public class UsuarioServiceTest {

	private UsuarioService usuarioService = null;
	
	public UsuarioServiceTest() {
		usuarioService = new UsuarioServiceImpl();
	}
	
	/**public void testCreate() throws DataException {
		
		Usuario u = new Usuario();
		u.setEmail("zzzzzzzzzz@gmail.com");
		u.setNombre("Encriptado");
		u.setApellidos("Encriptando");
		u.setPassword("abc123.");

		usuarioService.create(u);
		System.out.println(u);
	} **/
	
	public void testLogin() throws DataException {
		usuarioService.login("jaime21@hotmail.com", "abc123.");
		
	}
	
	/**public void testUpdate() throws DataException {
		
		Usuario u = new Usuario();
		u.setId(5l);
		u.setEmail("jaime21@hotmail.com");
		u.setNombre("Jaime");
		u.setApellidos("Hernandez Hernandez");
		u.setPassword("aloo");
		
		usuarioService.update(u);
	} **/
	
	public static final void main(String args[]) throws DataException {
		UsuarioServiceTest test = new UsuarioServiceTest();
		try {
		test.testLogin();
		//test.testUpdate();
		//test.testCreate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
