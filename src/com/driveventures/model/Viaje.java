package com.driveventures.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Viaje {

	public int id;
	public double latitudinicial;
	public double latitudfinal;
	public double longitudinicial;
	public double longitudfinal;
	public int idconductor;
	public int idpasajero;
	public String direccion;
	
	public Viaje() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitudinicial() {
		return latitudinicial;
	}

	public void setLatitudinicial(double latitudinicial) {
		this.latitudinicial = latitudinicial;
	}

	public double getLatitudfinal() {
		return latitudfinal;
	}

	public void setLatitudfinal(double latitudfinal) {
		this.latitudfinal = latitudfinal;
	}

	public double getLongitudinicial() {
		return longitudinicial;
	}

	public void setLongitudinicial(double longitudinicial) {
		this.longitudinicial = longitudinicial;
	}

	public double getLongitudfinal() {
		return longitudfinal;
	}

	public void setLongitudfinal(double longitudfinal) {
		this.longitudfinal = longitudfinal;
	}

	public int getIdconductor() {
		return idconductor;
	}

	public void setIdconductor(int idconductor) {
		this.idconductor = idconductor;
	}

	public int getIdpasajero() {
		return idpasajero;
	}

	public void setIdpasajero(int idpasajero) {
		this.idpasajero = idpasajero;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
