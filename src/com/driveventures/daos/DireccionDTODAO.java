package com.driveventures.daos;

import com.driveventures.model.DireccionDTO;

import DBCUtils.DataException;

public interface DireccionDTODAO {

	public DireccionDTO findByUsuario(int usuario_id) throws DataException;
	public DireccionDTO findByPais(int pais_id) throws DataException;
	public DireccionDTO findByCiudad(int ciudad_id) throws DataException;
	
	
	
}
