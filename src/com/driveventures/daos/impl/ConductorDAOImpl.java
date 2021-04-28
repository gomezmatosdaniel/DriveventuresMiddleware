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
import com.driveventures.service.Results;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

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
						+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
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
	

	
	public Conductor findByEmail(Connection connection, String email) throws DataException, SQLException {
		
		Conductor c = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{

			String sql;
			sql =    "SELECT USER_ID, EMAIL, NOMBRE, APELLIDOS, PASSWORD "
					+" FROM CONDUCTOR "
					+" WHERE "
					+"	UPPER(EMAIL) LIKE ?";


			preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			
			int i = 1;
			preparedStatement.setString(i++, "%"+email.toUpperCase()+"%");

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
					+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
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
	public List<Conductor> findByBuenaConversacion(Connection connection, int buenaconversacion) throws DataException, SQLException {
		List<Conductor> co = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
	try {
    	
		String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM conductor c "
					+ " INNER JOIN usuario u "
					+ " ON c.user_id = u.id ";
					if(+buenaconversacion >= 100) {
				    	  sql+= " WHERE c.buena_ruta >= 100 ";
				      }
				      if(buenaconversacion < 100 ) {
				    	  sql+= " WHERE c.buena_ruta < 100 ";
				      }
	    		
				      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

	@Override
	public List<Conductor> findByBuenaRuta(Connection connection, int buenaruta) throws DataException, SQLException {
		
		List<Conductor> co = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
		try {
	    	
			String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM conductor c "
					+ " INNER JOIN usuario u "
					+ " ON c.user_id = u.id ";
					
					 if(+buenaruta >= 100) {
				    	  sql+= " WHERE c.buena_ruta >= 100 ";
				      }
				      if(buenaruta < 100 ) {
				    	  sql+= " WHERE c.buena_ruta < 100 ";
				      }
	    		
				      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

	@Override
	public List<Conductor> findByExcelenteServicio(Connection connection, int excelenteservicio) throws DataException, SQLException {
		List<Conductor> co = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
	try {
    	
		String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM conductor c "
					+ " INNER JOIN usuario u "
					+ " ON c.user_id = u.id ";
	    		
	      if(+excelenteservicio >= 100) {
	    	  sql+= " WHERE c.excelente_servicio >= 100 ";
	      }
	      if(excelenteservicio < 100 ) {
	    	  sql+= " WHERE c.excelente_servicio < 100 ";
	      }
	
	      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

	@Override
	public List<Conductor> findByViajes(Connection connection, int viajes) throws DataException {
		
		 List<Conductor> co = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
		try {
	    	
			String sql;
			
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
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
	      
	      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

	
	public Conductor create(Connection connection, Conductor conductor) throws Exception {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {          
		
		String queryString = "INSERT INTO CONDUCTOR (USER_ID, VIAJES, ANHOS_EXPERIENCIA, DNI, RESIDENCIA, BUENA_CONVERSACION, BUENA_RUTA, EXCELENTE_SERVICIO, IDIOMA_PRINCIPAL)"
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		preparedStatement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);

		int i = 1;     		
		preparedStatement.setLong(i++, conductor.getUser_id());
		preparedStatement.setInt(i++, conductor.getNumviajes());
		preparedStatement.setInt(i++, conductor.getAñosexp());
		preparedStatement.setString(i++, conductor.getDni());
		preparedStatement.setString(i++, conductor.getResidencia());
		preparedStatement.setInt(i++, conductor.getBuenaconversacion());
		preparedStatement.setInt(i++, conductor.getBuenaruta());
		preparedStatement.setInt(i++, conductor.getExcelenteserviscio());
		preparedStatement.setString(i++, conductor.getIdioma_principal());
		int insertedRows = preparedStatement.executeUpdate();

		if (insertedRows == 0) {
			throw new SQLException("Can not add row to table 'Conductor'");
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
						+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
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

	@Override
	public List<Conductor> findByAñosExp(Connection connection, int anhos_experiencia) throws DataException, SQLException {
		List<Conductor> co = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
	try {
    	
		String sql;
	      sql = " SELECT u.email, u.nombre, u.apellido, c.user_id, c.viajes, "
					+ " c.anhos_experiencia, c.buena_conversacion, c.buena_ruta, "
					+ " c.excelente_servicio, c.Residencia "
					+ " FROM conductor c "
					+ " INNER JOIN usuario u "
					+ " ON c.user_id = u.id ";
					if(+anhos_experiencia >= 100) {
				    	  sql+= " WHERE c.buena_ruta >= 100 ";
				      }
				      if(anhos_experiencia < 100 ) {
				    	  sql+= " WHERE c.buena_ruta < 100 ";
				      }
	    		
				      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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


	public long delete(Connection connection, Long id) throws Exception {
		
		PreparedStatement preparedStatement = null;

		try {
			

			String queryString =	
					"DELETE FROM CONDUCTOR " 
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
	
