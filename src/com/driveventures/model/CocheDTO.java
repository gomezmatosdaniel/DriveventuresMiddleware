package com.driveventures.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CocheDTO extends Coche {

	private String nombreModelo;
	private String nombreMarca;


	public CocheDTO() {
	}


	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	
	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	public CocheDTO(int id, int idConductor, int fechaMatriculacion, int plazas, Long idModelo, String nombre,
			Long idMarca, String matricula, String nombreModelo, String nombreMarca) {
		super();


		this.nombreModelo = nombreModelo;
		this.nombreMarca = nombreMarca;
	}

	@Override
	public String toString() {

	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
		
		
	}
	



}
