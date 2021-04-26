package com.driveventures.daos;
import java.sql.Connection;

import com.driveventures.model.Viaje;

import DBCUtils.DataException;

public interface ViajeDAO {


	public Viaje findByLocalizacion(double lat_in, 
			double long_in, double lat_fin, double long_fin) throws DataException;

	public Viaje findByConductor(int id_conductor) throws DataException;

	public Viaje findByPasajero(int id_pasajero) throws DataException;
	
	public Viaje create(Connection connection, Viaje viaje) throws DataException;

}
