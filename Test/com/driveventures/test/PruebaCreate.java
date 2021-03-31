package com.driveventures.test;

import com.driveventures.daos.impl.CocheDAOImpl;
import com.driveventures.model.Coche;


public class PruebaCreate {

	
private CocheDAOImpl cocheDAO = null;
	
	public PruebaCreate() {
		cocheDAO = new CocheDAOImpl();

	}
	
	public void testCreate() throws Exception {
		
		System.out.println("Testing create ...");
		Coche c = new Coche();
		c.setNombre("Audi");
		c.setFechaMatriculacion(2018);
		c.setPlazas(5);
		c.setMatricula("7597 YAV");
		c.setIdModelo(2L);

		c = cocheDAO.add(c);
		System.out.println("Cuidador "+ c.getId()+ " creado");
	}
	
	public static final void main(String args[]) throws Exception {
		PruebaCreate test = new PruebaCreate();
		test.testCreate();
	}
	
}
