package com.driveventures.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Modelo {

	public int id;
	public String nombreModelo;
	public int idCoche;
	public int marcaid;



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




	public String getNombreModelo() {
		return nombreModelo;
	}



	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}



	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}



	public int getMarcaid() {
		return marcaid;
	}



	public void setMarcaid(int marcaid) {
		this.marcaid = marcaid;
	}
	
public String toString() {
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


}