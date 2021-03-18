package com.driveventures.daos.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.ViajeDAO;
import com.driveventures.model.Viaje;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class ViajeDAOImpl implements ViajeDAO {
	
	private static Logger logger = LogManager.getLogger(ViajeDAOImpl.class);
	  
	  public ViajeDAOImpl() {
	  }
	


	public Viaje findByLocalizacion(double lat_in, double long_in, double lat_fin, double long_fin) throws DataException {
		return null;	
		
	}

	
		public Viaje findByConductor(int id_conductor) throws DataException {
			  Connection conn = null;
			  Statement stmt = null;
			  ResultSet rs = null;
			  Viaje result = null;
			  
			  try {

				  conn = DBCUtils.GetConnection.getConnection();
			      
			      logger.debug("Creating statement...");
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT id, id_conductor, id_pasajero, lat_in, long_in, lat_fin, long_fin, nombre_direccion "
			      		+" FROM viaje "
			    		+" WHERE id_conductor = " +id_conductor;

			      ResultSet rsl = stmt.executeQuery(sql);

			      if (rsl.next()) {			
						result = loadNext(rs);			
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

	
	public Viaje findByPasajero(int id_pasajero) throws DataException {
		Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  Viaje result = null;
		  
		  try {

			  conn = DBCUtils.GetConnection.getConnection();
			  
		      logger.debug("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT id, id_conductor, id_pasajero, lat_in, long_in, lat_fin, long_fin, nombre_direccion "
		      		+" FROM viaje "
		    		+" WHERE id_pasajero = " +id_pasajero;

		      ResultSet rsl = stmt.executeQuery(sql);

		      if (rsl.next()) {			
					result = loadNext(rs);			
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
				;
			}
		  return result;
	  }
	
	
	private Viaje loadNext(ResultSet rs) throws Exception {
		Viaje v = new Viaje();
		int i = 1;
		v.setId(rs.getInt(i++));
		v.setIdconductor(rs.getInt(i++));
		v.setIdpasajero(rs.getInt(i++));
		v.setLatitudinicial(rs.getDouble(i++));
		v.setLongitudinicial(rs.getDouble(i++));
		v.setLatitudfinal(rs.getDouble(i++));
		v.setLongitudfinal(rs.getDouble(i++));
		v.setDireccion(rs.getString(i++));

		return v;
	}
	
	
}

