package com.driveventures.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Idiomas {

	public List <Idiomas> idiomas;
	private int idConductor;
	
	
	public Idiomas() {
		idiomas = new ArrayList<>();
	}


	public List<Idiomas> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(List<Idiomas> idiomas) {
		this.idiomas = idiomas;
	}


	public int getIdConductor() {
		return idConductor;
	}


	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
