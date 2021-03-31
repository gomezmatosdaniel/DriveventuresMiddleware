package com.driveventures.daos;

import java.sql.SQLException;

import com.driveventures.model.Coche;

import DBCUtils.DataException;

public interface CocheDAO {


	public Coche FindById(int id) throws DataException, SQLException;

	public Coche findByPlazas(int plazas) throws DataException, SQLException;

	public Coche findByAño(int fechamatriculacion) throws DataException, SQLException;
	
	public Coche findByMarca(int idmarca) throws DataException, SQLException;

	public Coche add(Coche coche) throws DataException, SQLException;

	public void update(Coche coche) throws DataException, SQLException;

	public void delete(int id) throws DataException, SQLException;

}
