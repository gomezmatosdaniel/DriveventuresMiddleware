package com.driveventures.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.DireccionDTODAO;
import com.driveventures.model.DireccionDTO;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class DireccionDTODAOImpl implements DireccionDTODAO {
	
	private static Logger logger = LogManager.getLogger(DireccionDTODAOImpl.class);
	
	
	public DireccionDTODAOImpl() {
		
	}


	public DireccionDTO findByUsuario(int usuario_id) throws DataException {
		
	    DireccionDTO result = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			conn = DBCUtils.GetConnection.getConnection();

			logger.debug("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT p.nombre, c.nombre_ciudad, d.direccion, d.codigo_postal "
					+" FROM direccion d "
					+" INNER JOIN direccion_usuario " 
					+" ON d.direccion_id = direccion_usuario.direccion_id "
					+" INNER JOIN ciudad c "
					+" ON d.ciudad_id = c.ciudad_id "
					+" INNER JOIN pais p "
					+" ON c.pais_id = p.pais_id "
					+" WHERE direccion_usuario.usuario_id = " +usuario_id;

			ResultSet rsl = stmt.executeQuery(sql);

			if (rsl.next()) {			
				result = loadNext(rsl);			
			}
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


	public DireccionDTO findByCiudad(int ciudadid) throws DataException {
		
		return null;
	}
	
	
	public DireccionDTO findByPais(int pais_id) throws DataException {

		return null;
	}

	private DireccionDTO loadNext(ResultSet rsl) throws DataException, SQLException {
		DireccionDTO d = new DireccionDTO();
		int i = 1;
		d.setPais(rsl.getString(i++));
		d.setCiudad(rsl.getString(i++));
		d.setDireccion(rsl.getString(i++));
		d.setCp(rsl.getInt(i++));
		return d;
	}
}
