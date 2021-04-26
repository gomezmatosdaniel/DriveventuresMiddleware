package com.driveventures.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.ModeloDAO;
import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
import com.driveventures.model.Marca;
import com.driveventures.model.Modelo;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class ModeloDAOImpl implements ModeloDAO {
	
	private static Logger logger = LogManager.getLogger(ModeloDAOImpl.class);
	
	public ModeloDAOImpl() {
		
	}

	@Override
	public List<Modelo> findAll(Connection connection) throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
	    	

	      logger.debug("Creating statement...");
	      String sql;
	      sql = " SELECT id, modelo"
	      		+ " from modelo";

	      

			preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = preparedStatement.executeQuery();						

			List<Modelo> results = new ArrayList<Modelo>();                        
			Modelo u = null;


			while(resultSet.next()) {
				u = loadNext(connection, resultSet);
				results.add(u);               	
			}

			return results;

		} catch (SQLException ex) {
			logger.warn(ex.getMessage(), ex);
			throw new DataException(ex);
		} finally {            
			DBUtils.closeResultSet(resultSet);
			DBUtils.closeStatement(preparedStatement);
		}  	
	}
	

	private Modelo loadNext(Connection connection, ResultSet rs) throws DataException, SQLException {
		Modelo m = new Modelo();
		int i = 1;
		m.setId(rs.getInt(i++));
		m.setNombreModelo(rs.getString(i++));
		return m;
		
	}
	
	
}
