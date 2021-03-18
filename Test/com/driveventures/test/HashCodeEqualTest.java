package com.driveventures.test;

import java.util.ArrayList;
import java.util.List;

import com.driveventures.model.Conductor;

public class HashCodeEqualTest {

	public static void main(String[] args) {
	
		Conductor c1, c2;
		
		c1 = new Conductor();
		c1.setNombre("Manuel");
		
		c2 = new Conductor();
		c1.setNombre("Juan");
	
		List<Conductor> lista = new ArrayList<Conductor>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c2);
		lista.add(c2);
		
		
		lista.remove(c2);
		
		System.out.println("List size"+ lista.size());
	}

}
