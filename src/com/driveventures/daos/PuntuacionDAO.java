package com.driveventures.daos;

import DBCUtils.DataException;

public interface PuntuacionDAO {

	
	public double findByConductor(int id) throws DataException;
	
}