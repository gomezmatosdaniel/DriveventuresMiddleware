package com.driveventures.daos.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.CocheDTODAO;
import com.driveventures.model.Coche;
import com.driveventures.model.CocheDTO;
import com.driveventures.model.Conductor;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class CocheDTODAOImpl implements CocheDTODAO {

	private static Logger logger = LogManager.getLogger(CocheDTODAOImpl.class);

	
	public CocheDTO FindById(Connection connection, Long id) throws DataException {
		CocheDTO result= null;
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {

	    	conn = DBCUtils.GetConnection.getConnection();

	      logger.debug("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, mo.modelo, ma.marca "
	      		+" FROM coche c "
	    		+" INNER JOIN modelo mo "
	      		+" ON c.modelo_id = mo.id "
	    		+" INNER JOIN marca ma"
	      		+" ON ma.id = mo.marca_id"
	    		+" WHERE c.ID = " +id;

	      ResultSet rsl = stmt.executeQuery(sql);

	      if (rsl.next()) {			
				result = loadNext(conn, rsl);			
			}
	      rsl.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			logger.error(se);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(stmt);
			DBUtils.closeResultSet(rs);
		}
		return result;
	}



	@Override
	public List<Coche> findByPlazas(Connection connection, int plazas) throws DataException, SQLException {
		List<Coche> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

			try {

				conn = DBCUtils.GetConnection.getConnection();

				logger.debug("Creating statement...");
				String sql;
				sql = " SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, mo.modelo, m.marca "
						+" FROM coche c "
						+" INNER JOIN modelo mo "
			      		+" ON c.modelo_id = mo.id "
			      		+" INNER JOIN marca m "
			      		+" ON mo.marca_id = m.id "
			      		+" WHERE c.plazas = " +plazas;
				if(plazas >= 5) {
					sql += " WHERE c.plazas >= 5 ";
				}
				if(plazas < 5) {
					sql += " WHERE c.plazas < 5 ";
				}

				   stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				      rs = stmt.executeQuery();
				      
				      List<Coche> results = new ArrayList<Coche>();                        
						Coche c = null;
						
						while(rs.next()) {
							c = loadNext(conn, rs);
							results.add(c);               	
						}
						return results;

					} catch (SQLException ex) {
						logger.warn(ex.getMessage(), ex);
						throw new DataException(ex);
					} finally {            
						DBUtils.closeResultSet(rs);
						DBUtils.closeStatement(stmt);
					}
	}

	@Override
	public List<Coche> findByA�o(Connection connection, int fechamatriculacion) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coche> findByMarca(Connection connection, int idmarca) throws DataException {
		List<Coche> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		  { 
		
		try {

			conn = DBCUtils.GetConnection.getConnection();
			
		    logger.debug("Creating statement...");
		
		    String sql;
		    sql = "SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, mo.modelo, m.marca "
		    		+" FROM coche c "
		    		+" INNER JOIN modelo mo "
		      		+" ON c.modelo_id = mo.id "
		      		+" INNER JOIN marca m "
		      		+" ON mo.marca_id = m.id "
		      		+" WHERE m.id = " +idmarca;

		    stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		      rs = stmt.executeQuery();
		      
		      List<Coche> results = new ArrayList<Coche>();                        
				Coche c = null;
				
				while(rs.next()) {
					c = loadNext(conn, rs);
					results.add(c);               	
				}
				return results;

			} catch (SQLException ex) {
				logger.warn(ex.getMessage(), ex);
				throw new DataException(ex);
			} finally {            
				DBUtils.closeResultSet(rs);
				DBUtils.closeStatement(stmt);
			}
		  }
		  }



	@Override
	public Coche add(Connection connection, Coche coche) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void update(Connection connection, Coche coche) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public long delete(Connection connection, Long id) {
		return id;
		// TODO Auto-generated method stub
		
	}
	
	private CocheDTO loadNext(Connection conn, ResultSet rs) throws DataException, SQLException {
		CocheDTO c = new CocheDTO();		
		int i = 1;
		c.setId(rs.getInt(i++));		
		c.setNombreModelo(rs.getString(i++));				
		c.setFechaMatriculacion(rs.getInt(i++));			
		c.setPlazas(rs.getInt(i++));
		c.setMatricula(rs.getString(i++));
		c.setNombreModelo(rs.getString(i++));
		c.setNombreMarca(rs.getString(i++));
		return c;
	}



	@Override
	public Coche findByPlazas(int plazas) throws DataException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coche findByA�o(int fechamatriculacion) throws DataException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coche findByMarca(int idmarca) throws DataException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
