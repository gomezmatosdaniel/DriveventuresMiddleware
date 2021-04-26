package com.driveventures.service;

import java.sql.SQLException;

import com.driveventures.model.Viaje;

import DBCUtils.DataException;

public interface ViajeService {

	public Viaje create(Viaje viaje) throws DataException, SQLException;
	
}
