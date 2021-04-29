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

import com.driveventures.daos.CocheDAO;
import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
import com.driveventures.model.Marca;
import com.driveventures.model.Modelo;
import com.driveventures.model.Usuario;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class CocheDAOImpl implements CocheDAO {

	private static Logger logger = LogManager.getLogger(CocheDAOImpl.class);

	public CocheDAOImpl() {

	}

	public Coche FindById(Connection connection , Long user_id) throws DataException {

		Coche c = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql;

			logger.debug("Creating statement...");

			sql = "SELECT coche.id, coche.nombre, coche.anho_creacion, coche.plazas, coche.matricula, coche.modelo_id, "
					+ "coche.user_id, modelo.modelo, marca.marca "
					+" FROM marca "
					+" INNER JOIN modelo ON modelo.marca_id = marca.id "
					+" INNER JOIN coche ON coche.modelo_id = modelo.id "
					+" where coche.user_id = ? ";

			preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			preparedStatement.setLong(i++, user_id);

			resultSet = preparedStatement.executeQuery();					

			if (resultSet.next()) {
				c =  loadNext(connection, resultSet);			

			} 

			return c;

		} catch (SQLException ex) {
			logger.warn(ex.getMessage(), ex);
			throw new DataException(ex);
		} finally {            
			DBUtils.closeResultSet(resultSet);
			DBUtils.closeStatement(preparedStatement);
		}
	}  



	public List<Coche> findByPlazas(Connection connection, int plazas) throws DataException {


		List<Coche> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			conn = DBCUtils.GetConnection.getConnection();
			
				logger.debug("Creating statement...");
				String sql;
				sql = "SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, modelo "
						+" FROM coche c "
						+" INNER JOIN modelo "
						+" ON c.modelo_id = modelo.id ";
				if(+plazas >= 5) {
					sql += " WHERE c.plazas >= 5";
				}
				if(plazas < 5) {
					sql += " WHERE c.plazas < 5";
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



	public List<Coche> findByAño(Connection connection, int fechamatriculacion) throws DataException {


		List<Coche> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

			try {

				conn = DBCUtils.GetConnection.getConnection();

				logger.debug("Creating statement...");
				
				String sql;
				sql = "SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, modelo "
						+" FROM coche c "
						+" INNER JOIN modelo "
						+" ON c.modelo_id = modelo.id "
						+" WHERE c.anho_creacion = " +fechamatriculacion;

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
				sql = "SELECT  m.marca ,c.nombre, mo.modelo, c.anho_creacion, c.plazas , c.matricula"
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

	public Coche add(Connection connection, Coche coche) throws DataException, SQLException {

		Conductor conductor = new Conductor();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		{ 

			try {

				conn = DBCUtils.GetConnection.getConnection();

				logger.debug("Creating statement...");


				String sql = " insert into coche(id, nombre, anho_creacion, "
						+ " plazas, matricula, modelo_id, user_id)  "
						+ " value(? , ? , ?, ? , ?, ?, ?) ";

				logger.info("sql = "+sql);

				preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				int i = 1;
				preparedStatement.setInt(i++, coche.getId());
				preparedStatement.setString(i++, coche.getNombre());
				preparedStatement.setInt(i++, coche.getFechaMatriculacion());
				preparedStatement.setInt(i++, coche.getPlazas());
				preparedStatement.setString(i++, coche.getMatricula());
				preparedStatement.setLong(i++, coche.getIdModelo());
				preparedStatement.setLong(i++, coche.getIdConductor());
				
				preparedStatement.executeUpdate();

				rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					coche.setId(rs.getInt(1));
				} rs.close();
				preparedStatement.close();

			}catch (SQLException se) {
				logger.error(se);
				
			} finally {		

				DBUtils.closeConnection(conn);
				DBUtils.closePreparedStatement(preparedStatement);
				DBUtils.closeResultSet(rs);
			}
			return coche;	
		}
	}


	private Coche loadNext(Connection connection, ResultSet rs) throws DataException, SQLException {
		Coche c = new Coche();
		int i = 1;
		c.setId(rs.getInt(i++));
		c.setNombre(rs.getString(i++));
		c.setFechaMatriculacion(rs.getInt(i++));
		c.setPlazas(rs.getInt(i++));
		c.setMatricula(rs.getString(i++));
		c.setIdModelo(rs.getLong(i++));
		c.setIdConductor(rs.getLong(i++));
		c.setNombreModelo(rs.getString(i++));	
		c.setNombreMarca(rs.getString(i++));

		return c;
	}



	@Override
	public void update(Connection connection, Coche coche) {
		// TODO Auto-generated method stub

	}



	
	public long delete(Connection connection, Long id) throws DataException, SQLException {
		PreparedStatement preparedStatement = null;

		try {
			

			String queryString =	
					"DELETE FROM COCHE " 
							+ "WHERE USER_ID = ? ";


			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, id);

			long removedRows = preparedStatement.executeUpdate();

			return removedRows;

		} catch (SQLException e) {
			logger.warn(e.getMessage(), e);
			throw new DataException(e);
		} finally {
			DBUtils.closeStatement(preparedStatement);
		}

	}


}
