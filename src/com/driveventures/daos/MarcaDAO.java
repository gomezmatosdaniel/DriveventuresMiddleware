package com.driveventures.daos;

import java.sql.Connection;
import java.util.List;

import com.driveventures.model.Marca;

import DBCUtils.DataException;

public interface MarcaDAO {

	public List<Marca> findByAll(Connection connection) throws DataException;
	
	
}
