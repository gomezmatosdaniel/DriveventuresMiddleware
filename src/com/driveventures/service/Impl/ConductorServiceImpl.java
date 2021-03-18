package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.impl.ConductorDAOImpl;
import com.driveventures.model.Conductor;
import com.driveventures.service.ConductorService;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class ConductorServiceImpl implements ConductorService {


	public ConductorDAO dao = null;

	public ConductorServiceImpl() {
		dao = new ConductorDAOImpl();
	}


	public Conductor findByViajes(int viajes) throws DataException, SQLException {
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByViajes(viajes);

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


	@Override
	public List<Conductor> findByBuenaConversacion(int buenaconversacion) throws DataException, SQLException {
		Connection conn = null;

		try {

			conn = GetConnection.getConnection();

			return dao.findByBuenaConversacion(buenaconversacion);

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


@Override
public List<Conductor> findByBuenaRuta(int buenaruta) throws DataException, SQLException {
	Connection conn = null;

	try {

		conn = GetConnection.getConnection();

		return dao.findByBuenaRuta(buenaruta);

	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
}


@Override
public List<Conductor> findByExcelenteServicio(int excelenteservicio) throws DataException, SQLException {
	
	Connection conn = null;
	
	try {
		
		conn = GetConnection.getConnection();
		
		return dao.findByExcelenteServicio(excelenteservicio);
		
	} catch (SQLException e) {
		throw new DataException(e);
	} finally {
		DBUtils.closeConnection(conn);
	}
	}
	
	
}
