package com.driveventures.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.UsuarioFavoritoDAO;
import com.driveventures.model.Coche;
import com.driveventures.model.Usuario;
import com.driveventures.model.UsuarioFavorito;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class UsuarioFavoritoDAOImpl implements UsuarioFavoritoDAO {
	
	private static Logger logger = LogManager.getLogger(UsuarioFavoritoDAOImpl.class);
	
	
	public UsuarioFavoritoDAOImpl() {
		
	}

	//TODO
	public UsuarioFavorito FindById(int idusuario, int idconductor) throws DataException {
		
		UsuarioFavorito result= null;
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {
	    	
	    	conn = DBCUtils.GetConnection.getConnection();

	      logger.debug("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      //TODO
	      sql = "SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, modelo "
	      		+" FROM coche c "
	    		+" INNER JOIN modelo "
	      		+" ON c.modelo_id = modelo.id "
	    		+" WHERE c.ID = " +idusuario;

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

		private UsuarioFavorito loadNext(ResultSet rs) throws SQLException {
		UsuarioFavorito u = new UsuarioFavorito();
		int i = 1;
		u.setIdconductor(rs.getInt(i++));
		u.setIdusuario(rs.getInt(i++));
		return u;
		}
	
	}
