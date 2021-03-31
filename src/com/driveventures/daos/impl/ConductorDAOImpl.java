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

import com.driveventures.daos.ConductorDAO;
import com.driveventures.daos.UsuarioDAO;
import com.driveventures.model.Conductor;
import com.driveventures.model.Usuario;

import DBCUtils.DBUtils;
import DBCUtils.DataException;
import DBCUtils.PasswordEncryptionUtil;

public class ConductorDAOImpl implements ConductorDAO {
	
	private UsuarioDAO usuarioDAO = null;
	
	private static Logger logger = LogManager.getLogger(ConductorDAOImpl.class);
	  
	  public ConductorDAOImpl() {
		  
		  usuarioDAO = new UsuarioDAOImpl();
	  }
	
	  public Conductor findById(Connection connection, int id) throws DataException, SQLException {
		  Conductor c = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
			try {
				
		      String sql;
		      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
						+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
						+ " c.excelente_servicio, c.Residencia "
						+ " FROM usuario u "
						+ " INNER JOIN conductor c "
						+ " ON u.id = c.user_id "
		    		+" WHERE c.user_id =  ? ";
		      
		      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		      int i = 1;
				preparedStatement.setInt(i++, id);

				rs = preparedStatement.executeQuery();	
		      
				if (rs.next()) {
					c =  loadNext(connection, rs);			
					//System.out.println("Cargado "+u);
				} 

				return c;

			} catch (SQLException ex) {
				logger.warn(ex.getMessage(), ex);
				throw new DataException(ex);
			} finally {            
				DBUtils.closeResultSet(rs);
				DBUtils.closeStatement(preparedStatement);
			}  	
	  }
	

	
	public Conductor findByEmail(String email) throws DataException, SQLException {
		
		Conductor result= null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			
			conn = DBCUtils.GetConnection.getConnection();

			
			sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM usuario u "
					+ " INNER JOIN conductor c "
					+ " ON u.id = c.user_id "
					+ " WHERE UPPER(u.email) like ? "; 


			System.out.println(sql);
			PreparedStatement preparedStatement = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;

			preparedStatement.setString(i++,email.toUpperCase());


			ResultSet resultSet = preparedStatement.executeQuery();
			result = new Conductor();
			

			while (resultSet.next()) {
				result= new Conductor();
				result = loadNext(conn, resultSet);				

			}
			resultSet.close();

			conn.close();
		} catch (SQLException se) {
			logger.error(se);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(stmt);
			DBUtils.closeResultSet(rs);
			DBUtils.closePreparedStatement(stmt);
		}
		
		return result;
	}
		

	@Override
	public Conductor findByProximidad(int lat, int lon) throws DataException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//TODO
	public List<Conductor> findByPuntuacion(int viajes) throws DataException, SQLException {
		
		List<Conductor> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
	    	
	    	conn = DBCUtils.GetConnection.getConnection();

	      logger.debug("Creating statement...");
	      String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM usuario u "
					+ " INNER JOIN conductor c "
					+ " ON u.id = c.user_id ";
	    		
	      if(+viajes >= 100) {
	    	  sql+= " WHERE c.viajes >= 100 ";
	      }
	      if(viajes < 100 ) {
	    	  sql+= " WHERE c.viajes < 100 ";
	      }
	      
	      stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	      rs = stmt.executeQuery();
	      
	      List<Conductor> results = new ArrayList<Conductor>();                        
			Conductor c = null;
			
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
	public List<Conductor> findByBuenaConversacion(int buenaconversacion) throws DataException, SQLException {
		List<Conductor> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
	    	
	    	conn = DBCUtils.GetConnection.getConnection();

	      logger.debug("Creating statement...");
	      String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM conductor c "
					+ " INNER JOIN usuario u "
					+ " ON c.user_id = u.id "
					+ " WHERE c.buena_conversacion >= " +buenaconversacion;
	    		
	      stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	      rs = stmt.executeQuery();
	      
	      List<Conductor> results = new ArrayList<Conductor>();                        
			Conductor c = null;
			
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
	public List<Conductor> findByBuenaRuta(int buenaruta) throws DataException, SQLException {
		List<Conductor> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
	    	
	    	conn = DBCUtils.GetConnection.getConnection();

	      logger.debug("Creating statement...");
	      String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM conductor c "
					+ " INNER JOIN usuario u "
					+ " ON c.user_id = u.id "
					+ " WHERE c.buena_ruta >= " +buenaruta;
	    		
	      stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	      rs = stmt.executeQuery();
	      
	      List<Conductor> results = new ArrayList<Conductor>();                        
			Conductor c = null;
			
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
	public List<Conductor> findByExcelenteServicio(int excelenteservicio) throws DataException, SQLException {
		List<Conductor> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
	    	
	    	conn = DBCUtils.GetConnection.getConnection();

	      logger.debug("Creating statement...");
	      String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM conductor c "
					+ " INNER JOIN usuario u "
					+ " ON c.user_id = u.id "
					+ " WHERE c.excelente_servicio >= " +excelenteservicio;
	    		
	      stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	      rs = stmt.executeQuery();
	      
	      List<Conductor> results = new ArrayList<Conductor>();                        
			Conductor c = null;
			
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
	public Conductor findByViajes(int viajes) throws DataException {
		Conductor result = null;
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
		try {
	    	
	    	conn = DBCUtils.GetConnection.getConnection();

	      logger.debug("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM usuario u "
					+ " INNER JOIN conductor c "
					+ " ON u.id = c.user_id ";
	    		
	      if(+viajes >= 100) {
	    	  sql+= " WHERE c.viajes >= 100 ";
	      }
	      if(viajes < 100 ) {
	    	  sql+= " WHERE c.viajes < 100 ";
	      }

	      rs = stmt.executeQuery(sql);

	      if (rs.next()) {			
				result = loadNext(conn, rs);			
			}
	      rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			logger.error(se);
		} catch (DataException e) {
			logger.error(e);
		} finally {
			
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(stmt);
			DBUtils.closeResultSet(rs);
			}
		
		return result;
  }

	
	public Conductor create(Connection connection, Conductor conductor) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {          
		
		String queryString = "INSERT INTO CONDUCTOR(USER_ID, VIAJES, AÑOS_EXPERIENCIA, DNI, RESIDENCIA, BUENA_CONVERSACION, BUENA_RUTA, EXCELENTE_SERVICIO, COCHE_ID, IDIOMA_ID)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		preparedStatement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);

		int i = 1;     		
		preparedStatement.setInt(i++, conductor.getNumviajes());
		preparedStatement.setInt(i++, conductor.getAñosexp());
		preparedStatement.setString(i++, conductor.getDni());
		preparedStatement.setString(i++, conductor.getResidencia());
		preparedStatement.setInt(i++, conductor.getBuenaconversacion());
		preparedStatement.setInt(i++, conductor.getBuenaruta());
		preparedStatement.setInt(i++, conductor.getExcelenteserviscio());
		preparedStatement.setInt(i++, conductor.getIdioma_id());
		int insertedRows = preparedStatement.executeUpdate();

		if (insertedRows == 0) {
			throw new SQLException("Can not add row to table 'Usuario'");
		}

		resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {
			Long id = resultSet.getLong(1);
			conductor.setId(id);

		} else {
			throw new DataException("Unable to fetch autogenerated primary key");
		}


		return conductor;					

	} catch (SQLException ex) {
		logger.warn(ex.getMessage(), ex);
		throw new DataException(ex);
	} finally {
		DBUtils.closeResultSet(resultSet);
		DBUtils.closeStatement(preparedStatement);			
	}
	}

	@Override
	public void update(Conductor conductor) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	private Conductor loadNext(Connection connection, ResultSet rs) throws DataException, SQLException {
		  Conductor co = new Conductor();	
		  int i = 1;
		  co.setEmail(rs.getString(i++));
		  co.setNombre(rs.getString(i++));
		  co.setApellidos(rs.getString(i++));
		  co.setId(rs.getLong(i++));
		  co.setNumviajes(rs.getInt(i++));
		  co.setAñosexp(rs.getInt(i++));
		  co.setBuenaconversacion(rs.getInt(i++));
		  co.setBuenaruta(rs.getInt(i++));
		  co.setExcelenteserviscio(rs.getInt(i++));
		  co.setResidencia(rs.getString(i++));
		  return co;
	  
	}

	@Override
	public List<Conductor> findByPuntuacion(int puntucionmenor, int puntuacionmayor)
			throws DataException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conductor> findByResidencia(Connection connection, String Residencia) throws DataException, SQLException {
		
		 List<Conductor> co = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
			try {
				
		      String sql;
		      
		      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
						+ " c.años_experiencia, c.buena_conversacion, c.buena_ruta, "
						+ " c.excelente_servicio, c.Residencia "
						+ " FROM usuario u "
						+ " INNER JOIN conductor c "
						+ " ON u.id = c.user_id " 
		      		    + " WHERE Residencia LIKE ? ";
		      
		      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				// Establece os parámetros
				int i = 1;
				preparedStatement.setString(i++, "%"+Residencia.toUpperCase()+"%");

			      rs = preparedStatement.executeQuery();
			      
			      List<Conductor> results = new ArrayList<Conductor>();                        
					Conductor c = null;
					
					while(rs.next()) {
						c = loadNext(connection, rs);
						results.add(c);               	
					}
					return results;

				} catch (SQLException ex) {
					logger.warn(ex.getMessage(), ex);
					throw new DataException(ex);
				} finally {            
					DBUtils.closeResultSet(rs);
					DBUtils.closeStatement(preparedStatement);
				}
	}
}
	
