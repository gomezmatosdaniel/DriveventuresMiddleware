package com.driveventures.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DireccionDTO {

	public int paisid;
	public String pais;
	public int provinciaid;
	public String provincia;
	public int ciudadid;
	public String ciudad;
	public int cp;
	public int localidadid;
	public String localidad;
	public String direccion;


	public DireccionDTO() {

	}


	public int getPaisid() {
		return paisid;
	}


	public void setPaisid(int paisid) {
		this.paisid = paisid;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public int getProvinciaid() {
		return provinciaid;
	}


	public void setProvinciaid(int provinciaid) {
		this.provinciaid = provinciaid;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public int getCiudadid() {
		return ciudadid;
	}


	public void setCiudadid(int ciudadid) {
		this.ciudadid = ciudadid;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public int getLocalidadid() {
		return localidadid;
	}


	public void setLocalidadid(int localidadid) {
		this.localidadid = localidadid;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
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
