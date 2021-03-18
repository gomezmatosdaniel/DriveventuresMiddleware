package com.driveventures.model;

public class Modelo {

	public int id;
	public static String modelo;
	public int idCoche;



	public Modelo() {

	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIdCoche() {
		return idCoche;
	}



	public static String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}


}