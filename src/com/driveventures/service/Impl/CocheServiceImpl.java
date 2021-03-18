package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.driveventures.daos.CocheDTODAO;
import com.driveventures.daos.impl.CocheDTODAOImpl;
import com.driveventures.model.Coche;
import com.driveventures.service.CocheService;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class CocheServiceImpl implements CocheService {


	private CocheDTODAO dao = null;

	public CocheServiceImpl() {
		dao = new CocheDTODAOImpl();
	}


	public Coche findById(int id) throws DataException, SQLException {

		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.FindById(id);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	public Coche registrar(Coche c) throws DataException, SQLException {

		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.add(c);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


	public Coche findByMarca(int idmarca) throws DataException, SQLException {
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByMarca(idmarca);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}



	public Coche findByPlazas(int plazas) throws DataException, SQLException {

		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByPlazas(plazas);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


	@Override
	public Coche findByAño(int fechamatriculacion) throws DataException, SQLException {
		
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByAño(fechamatriculacion);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}

}




