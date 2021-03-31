package com.driveventures.servicestest;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.mail.EmailException;

import com.driveventures.model.Usuario;
import com.driveventures.service.UsuarioService;
import com.driveventures.service.Impl.UsuarioServiceImpl;

import DBCUtils.DataException;
import DBCUtils.MailException;

public class UsuarioServiceTest {

	private UsuarioService usuarioService = null;
	
	public UsuarioServiceTest() {
		usuarioService = new UsuarioServiceImpl();
	}
	
	/**public void testFindById() throws DataException {
		usuarioService.findById(1);
	} **/
	
	/** public void testCreate() throws DataException , MailException, EmailException {
		
		Usuario u = new Usuario();
		u.setEmail("gomezmatossssdgdaniel@gmail.com");
		u.setNombre("Encriptado");
		u.setApellidos("Encriptando");
		u.setPassword("abc123.");

		try {
			usuarioService.create(u);
		} catch (DataException | MailException | EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u);
	} **/
	
	public void testLogin() throws DataException {
		usuarioService.login("gomezmatosdaniel@gmail.com", "123");
		
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
	
	public void testDelete()
			throws Exception{
		
		long id = 44;
		id = usuarioService.delete(id);
		System.out.println("Se elimino el usuario con id "+id);

	}
	
	public static final void main(String args[]) throws DataException {
		UsuarioServiceTest test = new UsuarioServiceTest();
		try {
		test.testLogin();
		//test.testUpdate();
		//test.testCreate();
		//test.testFindById();
		test.testDelete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
