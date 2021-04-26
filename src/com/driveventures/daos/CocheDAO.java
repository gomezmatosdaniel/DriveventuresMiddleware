package com.driveventures.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.driveventures.model.Coche;

import DBCUtils.DataException;

public interface CocheDAO {


	public Coche FindById(Connection connection, Long id) throws DataException, SQLException;

	public List<Coche> findByPlazas(Connection connection, int plazas) throws DataException, SQLException;

	public List<Coche> findByAño(Connection connection, int fechamatriculacion) throws DataException, SQLException;
	
	public List<Coche> findByMarca(Connection connection, int idmarca) throws DataException, SQLException;

	public Coche add(Connection connection, Coche coche) throws DataException, SQLException;

	public void update(Connection connection, Coche coche) throws DataException, SQLException;

	public long delete(Connection connection, Long id) throws DataException, SQLException;

}
