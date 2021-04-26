package com.driveventures.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.driveventures.model.Marca;
import com.driveventures.model.Modelo;

import DBCUtils.DataException;

public interface ModeloService {

	public List<Modelo> findAll (Connection connection) throws DataException, SQLException;
	
}
