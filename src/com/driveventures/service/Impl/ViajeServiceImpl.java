package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.driveventures.daos.ViajeDAO;
import com.driveventures.daos.impl.ViajeDAOImpl;
import com.driveventures.model.Viaje;
import com.driveventures.service.ViajeService;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class ViajeServiceImpl implements ViajeService {
	
	private ViajeDAO dao = null;

	public ViajeServiceImpl() {
		dao = new ViajeDAOImpl();
	}

	@Override
	public Viaje create(Viaje viaje) throws DataException, SQLException {
		
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.create(conn, viaje);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	
	
	
}
