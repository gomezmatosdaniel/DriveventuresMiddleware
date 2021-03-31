package com.driveventures.daos;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.driveventures.model.Conductor;

import DBCUtils.DataException;


public interface ConductorDAO {



public Conductor findById(Connection connection, int id) throws DataException, SQLException;
	
	public Conductor findByEmail(String email) throws DataException, SQLException;

	public Conductor findByProximidad(int lat, int lon) throws DataException, SQLException;

	public List <Conductor> findByPuntuacion(int puntucionmenor, int puntuacionmayor) throws DataException, SQLException;

	public List <Conductor> findByBuenaConversacion(int buenaconversacion) throws DataException, SQLException;

	public List <Conductor> findByBuenaRuta(int buenaruta) throws DataException, SQLException;

	public List <Conductor> findByExcelenteServicio(int excelenteservicio) throws DataException, SQLException;
	
	public Conductor findByViajes(int viajes) throws DataException, SQLException;
	
	public List <Conductor> findByResidencia(Connection connection, String Residencia) throws DataException, SQLException;

	public Conductor create(Connection connection, Conductor conductor) throws Exception;

	public void update(Conductor conductor) throws Exception;
	
	public boolean delete(int id) throws Exception;

}
