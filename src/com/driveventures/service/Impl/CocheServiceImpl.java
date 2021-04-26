package com.driveventures.service.Impl;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.driveventures.daos.CocheDAO;
import com.driveventures.daos.CocheDTODAO;
import com.driveventures.daos.impl.CocheDAOImpl;
import com.driveventures.model.Coche;
import com.driveventures.service.CocheService;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.GetConnection;

public class CocheServiceImpl implements CocheService {

	private static Logger logger = LogManager.getLogger(UsuarioServiceImpl.class);
	
	
	private CocheDAO dao = null;

	public CocheServiceImpl() {
		dao = new CocheDAOImpl();
	}


	public Coche findById(Long id) throws DataException, SQLException {

		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.FindById(conn, id);

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

			return dao.add(conn, c);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


	public List<Coche> findByMarca(int idmarca) throws DataException, SQLException {
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByMarca(conn, idmarca);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}



	public List<Coche> findByPlazas(int plazas) throws DataException, SQLException {

		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByPlazas(conn, plazas);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}


	@Override
	public List<Coche> findByAño(int fechamatriculacion) throws DataException, SQLException {
		
		Connection conn = null;

		try {


			conn = GetConnection.getConnection();

			return dao.findByAño(conn, fechamatriculacion);

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}


	@Override
	public long delete(Long id) throws DataException, SQLException {
		Connection connection = null;
	    boolean commit = false;
	    Long result = null;

	    try {
	      
	        connection = GetConnection.getConnection();

	        connection.setTransactionIsolation(
	                Connection.TRANSACTION_READ_COMMITTED);

	        connection.setAutoCommit(false);
	        
	        result = dao.delete(connection, id);   
	        
	        commit = true;            
	        return result;
	        
	    } catch (SQLException e) {
	    	logger.warn(e.getMessage(), e);
	        throw new DataException(e);

	    } finally {
	    	DBUtils.closeConnection(connection, commit);
	    }	
	}

}




