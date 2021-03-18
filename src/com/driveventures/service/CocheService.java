package com.driveventures.service;

import java.sql.SQLException;


import com.driveventures.model.Coche;


import DBCUtils.DataException;

public interface CocheService {


	public Coche findById(int id) throws DataException, SQLException;

	public Coche registrar(Coche c) throws DataException, SQLException;

	public Coche findByMarca(int idmarca) throws DataException, SQLException;

	public Coche findByPlazas(int plazas) throws DataException, SQLException;

	public Coche findByAño(int fechamatriculacion) throws DataException, SQLException;



}