package com.driveventures.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Coche  {

	public int id;
	private Long idConductor;
	public int fechaMatriculacion;
	public int plazas;
	public String nombre;
	public Long idModelo;
	public String nombreModelo;
	public Long idMarca;
	public String nombreMarca;
	public String Matricula;


	public Coche() {

	}

	


	




	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
	}









	public void setIdConductor(Long idConductor) {
		this.idConductor = idConductor;
	}


	public int getPlazas() {
		return plazas;
	}




	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}




	public String getNombre() {
		return nombre;
	}

	public Long getIdConductor() {
		return idConductor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public Long getIdModelo() {
		return idModelo;
	}




	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}


	public String getNombreModelo() {
		return nombreModelo;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}


	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	
	public int getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(int i) {
		this.fechaMatriculacion = i;
	}

	public String toString() {
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


}
