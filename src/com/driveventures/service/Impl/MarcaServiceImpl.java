package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.MarcaDAO;
import com.driveventures.daos.impl.MarcaDAOImpl;
import com.driveventures.model.Marca;
import com.driveventures.service.MarcaService;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class MarcaServiceImpl implements MarcaService {
	
	private static Logger logger = LogManager.getLogger(MarcaServiceImpl.class);
	
	public MarcaDAO marcaDAO = null;

	public MarcaServiceImpl() {
		marcaDAO = new MarcaDAOImpl();
	}

	@Override
	public List<Marca> findAll(Connection connection) throws DataException, SQLException {
		Connection conn = null;
		

		try {


			conn = GetConnection.getConnection();

			return marcaDAO.findByAll(conn);

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	
	
	
}
