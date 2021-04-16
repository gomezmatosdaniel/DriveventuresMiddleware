package com.driveventures.service;

import java.sql.SQLException;
import java.util.List;

import com.driveventures.model.Conductor;

import DBCUtils.DataException;

public interface ConductorService {

	public Conductor login(String email, String password) throws DataException;
	
	public List<Conductor> findByViajes(int viajes) throws DataException, SQLException;

	public List<Conductor> findByBuenaConversacion(int buenaconversacion) throws DataException, SQLException;

	public List<Conductor> findByBuenaRuta(int buenaruta) throws DataException, SQLException;
	
	public List<Conductor> findByAñosExp(int anhos_experiencia) throws DataException, SQLException;
	
	public Results<Conductor> findByExcelenteServicio(int excelenteservicio, int startIndex, int count) throws DataException, SQLException;

	public List<Conductor> findByResidencia (String Residencia) throws DataException, SQLException;
	
	public Conductor create(Conductor co) throws DataException, Exception;
	
}
