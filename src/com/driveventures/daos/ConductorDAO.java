package com.driveventures.daos;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.driveventures.model.Conductor;
import com.driveventures.service.Results;

import DBCUtils.DataException;


public interface ConductorDAO {



public Conductor findById(Connection connection, int id) throws DataException, SQLException;
	
	public Conductor findByEmail(Connection connection, String email) throws DataException, SQLException;

	public Conductor findByProximidad(int lat, int lon) throws DataException, SQLException;

	public List <Conductor> findByPuntuacion(int puntucionmenor, int puntuacionmayor) throws DataException, SQLException;

	public List <Conductor> findByBuenaConversacion(Connection connection, int buenaconversacion) throws DataException, SQLException;

	public List <Conductor> findByBuenaRuta(Connection connection, int buenaruta) throws DataException, SQLException;

	public List <Conductor> findByAñosExp (Connection connection, int anosexp) throws DataException, SQLException;
	
	public List<Conductor> findByExcelenteServicio(Connection connection, int excelenteservicio) throws DataException, SQLException;
	
	public List <Conductor> findByViajes(Connection connection, int viajes) throws DataException, SQLException;
	
	public List <Conductor> findByResidencia(Connection connection, String Residencia) throws DataException, SQLException;

	public Conductor create(Connection connection, Conductor conductor) throws DataException, SQLException;

	public void update(Conductor conductor) throws Exception;
	
	public long delete(Connection connection, Long id) throws DataException;

}
