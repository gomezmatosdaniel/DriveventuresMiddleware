package com.driveventures.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.driveventures.model.Marca;

import DBCUtils.DataException;

public interface MarcaService {

	public List<Marca> findAll (Connection connectionO) throws DataException, SQLException;
	
	
	
}
