package com.driveventures.daos;

import java.util.List;

import com.driveventures.model.Marca;

import DBCUtils.DataException;

public interface MarcaDAO {

	public List<Marca> findByMarca(String marca) throws DataException;
	
	
}
