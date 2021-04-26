package com.driveventures.daos;

import java.sql.Connection;
import java.util.List;

import com.driveventures.model.Modelo;

import DBCUtils.DataException;

public interface ModeloDAO {

	
	public List<Modelo> findAll(Connection connection) throws DataException;
	
	
}
