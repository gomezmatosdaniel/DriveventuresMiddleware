package com.driveventures.service;

import java.sql.SQLException;
import java.util.List;

import com.driveventures.model.Coche;

import DBCUtils.DataException;

public interface CocheService {


	public Coche findById(Long id) throws DataException, SQLException;

	public Coche registrar(Coche c) throws DataException, SQLException;

	public List<Coche> findByMarca(int idmarca) throws DataException, SQLException;

	public List<Coche> findByPlazas(int plazas) throws DataException, SQLException;

	public List<Coche> findByAño(int fechamatriculacion) throws DataException, SQLException;
	
	public long delete(Long id) throws DataException, SQLException;



}