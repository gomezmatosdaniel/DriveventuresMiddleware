package com.driveventures.daos;

import java.sql.SQLException;

import com.driveventures.model.Coche;

import DBCUtils.DataException;

public interface CocheDTODAO extends CocheDAO {

	
	public Coche findByPlazas(int plazas) throws DataException, SQLException;

	public Coche findByA�o(int fechamatriculacion) throws DataException, SQLException;
	
	public Coche findByMarca(int idmarca) throws DataException, SQLException;
	
}


