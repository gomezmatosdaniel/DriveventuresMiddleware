package com.driveventures.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.daos.ModeloDAO;
import com.driveventures.daos.impl.ModeloDAOImpl;
import com.driveventures.model.Marca;
import com.driveventures.model.Modelo;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class ModeloServiceImpl {
	
	
private static Logger logger = LogManager.getLogger(ModeloServiceImpl.class);
	
	public ModeloDAO modeloDAO = null;

	public ModeloServiceImpl() {
		modeloDAO = new ModeloDAOImpl();
	}

	
	public List<Modelo> findAll(Connection connection) throws DataException, SQLException {
		Connection conn = null;
		

		try {


			conn = GetConnection.getConnection();

			return modeloDAO.findAll(conn);

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}
}
