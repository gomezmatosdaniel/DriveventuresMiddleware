package com.driveventures.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Conductor extends Usuario {

	public Long user_id;
	public String nombre;
	public String apellidos;
	public String email;
	public String password;
	public String dni;
	public double puntuacion;
	public int anosexp;
	public int numviajes;
	public int buenaconversacion;
	public int buenaruta;
	public int Excelenteservicio;
	public double lat;
	public double lon;
	public String residencia;
	public String idioma_principal;
	public int coche_id;

	public Conductor() {
		
	}

	public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellido1) {
		this.apellidos = apellido1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getAñosexp() {
		return anosexp;
	}

	public void setAñosexp(int añosexp) {
		this.anosexp = añosexp;
	}

	public int getNumviajes() {
		return numviajes;
	}

	public void setNumviajes(int numviajes) {
		this.numviajes = numviajes;
	}

	public int getBuenaconversacion() {
		return buenaconversacion;
	}

	public void setBuenaconversacion(int buenaconversacion) {
		this.buenaconversacion = buenaconversacion;
	}

	public int getBuenaruta() {
		return buenaruta;
	}

	public void setBuenaruta(int buenaruta) {
		this.buenaruta = buenaruta;
	}

	public int getExcelenteserviscio() {
		return Excelenteservicio;
	}

	public void setExcelenteserviscio(int excelenteserviscio) {
		this.Excelenteservicio = excelenteserviscio;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getAnosexp() {
		return anosexp;
	}

	public void setAnosexp(int anosexp) {
		this.anosexp = anosexp;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getExcelenteservicio() {
		return Excelenteservicio;
	}

	public void setExcelenteservicio(int excelenteservicio) {
		Excelenteservicio = excelenteservicio;
	}


	public String getIdioma_principal() {
		return idioma_principal;
	}

	public void setIdioma_principal(String idioma_principal) {
		this.idioma_principal = idioma_principal;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public int getCoche_id() {
		return coche_id;
	}

	public void setCoche_id(int coche_id) {
		this.coche_id = coche_id;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("equals" + o);
		return super.equals(o);
		}

	@Override
	public int hashCode() {
		System.out.println(" hasCode" +super.hashCode());
		return super.hashCode();
	}


}