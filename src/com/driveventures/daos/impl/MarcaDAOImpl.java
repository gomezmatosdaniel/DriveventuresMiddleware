package com.driveventures.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.MarcaDAO;
import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
import com.driveventures.model.Marca;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class MarcaDAOImpl implements MarcaDAO {
	
	private static Logger logger = LogManager.getLogger(MarcaDAOImpl.class);
	
	
	public MarcaDAOImpl() {

	}

	@Override
	public List<Marca> findByAll(Connection connection) throws DataException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
	    	

	      logger.debug("Creating statement...");
	      String sql;
	      sql = " SELECT id, marca"
	      		+ " from marca";

	      

			preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = preparedStatement.executeQuery();						

			List<Marca> results = new ArrayList<Marca>();                        
			Marca u = null;


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
	
	private Marca loadNext(Connection connection, ResultSet rs) throws DataException, SQLException {
		Marca m = new Marca();
		int i = 1;
		m.setId(rs.getInt(i++));
		m.setMarca(rs.getString(i++));
		
		return m;
	}

}
