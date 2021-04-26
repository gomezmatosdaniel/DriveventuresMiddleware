package com.driveventures.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Marca {

	public int id;
	public String marca;
	public int idmodelo;
	
	
	
	public Marca() {
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public int getIdmodelo() {
		return idmodelo;
	}



	public void setIdmodelo(int idmodelo) {
		this.idmodelo = idmodelo;
	}
	
public String toString() {
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
}
