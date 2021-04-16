package com.driveventures.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.driveventures.daos.CocheDAO;
import com.driveventures.model.Coche;
import com.driveventures.model.Conductor;
import com.driveventures.model.Marca;
import com.driveventures.model.Modelo;

import DBCUtils.DBUtils;
import DBCUtils.DataException;

public class CocheDAOImpl implements CocheDAO {

	private static Logger logger = LogManager.getLogger(CocheDAOImpl.class);

	public CocheDAOImpl() {

	}

	public Coche FindById(int user_id) throws DataException {

		Coche result= null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = DBCUtils.GetConnection.getConnection();

			logger.debug("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, modelo "
					+" FROM coche c "
					+" INNER JOIN modelo "
					+" ON c.modelo_id = modelo.id "
					+" WHERE c.ID = " +user_id;

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



	public Coche findByPlazas(int plazas) throws DataException {


		Coche result = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		{ 

			try {

				conn = DBCUtils.GetConnection.getConnection();

				logger.debug("Creating statement...");
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT c.nombre , c.plazas "
						+" FROM coche c ";
				if(plazas <= 5) {
					sql += " WHERE c.plazas <= 5";
				}
				if(plazas < 5) {
					sql += " WHERE c.plazas < 5";
				}

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
				DBUtils.closeResultSet(rs);
				DBUtils.closeStatement(stmt);
			}


			return result;		
		}
	}



	public Coche findByAño(int fechamatriculacion) throws DataException {

		Coche result = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;{ 

			try {

				conn = DBCUtils.GetConnection.getConnection();

				logger.debug("Creating statement...");
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT c.id , c.nombre , c.anho_creacion ,c.plazas, c.matricula, modelo "
						+" FROM coche c "
						+" INNER JOIN modelo "
						+" ON c.modelo_id = modelo.id "
						+" WHERE c.anho_creacion = " +fechamatriculacion;

				ResultSet rsl = stmt.executeQuery(sql);
				if (rsl.next()) {			
					result = loadNext(rsl);			
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
				DBUtils.closeResultSet(rs);
				DBUtils.closeStatement(stmt);
			}


			return result;		
		}

	}


	public Coche findByMarca(int idmarca) throws DataException {
		Coche result = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		{ 

			try {

				conn = DBCUtils.GetConnection.getConnection();

				logger.debug("Creating statement...");
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT  m.marca ,c.nombre, mo.modelo, c.anho_creacion, c.plazas , c.matricula"
						+" FROM coche c "
						+" INNER JOIN modelo mo "
						+" ON c.modelo_id = mo.id "
						+" INNER JOIN marca m "
						+" ON mo.marca_id = m.id "
						+" WHERE m.id = " +idmarca;

				ResultSet rsl = stmt.executeQuery(sql);
				if (rsl.next()) {			
					result = loadNext(rsl);			
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
				DBUtils.closeResultSet(rs);
				DBUtils.closeStatement(stmt);
			}


			return result;		
		}
	}

	public Coche add(Coche coche) throws DataException {

		Conductor conductor = new Conductor();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		{ 

			try {

				conn = DBCUtils.GetConnection.getConnection();

				logger.debug("Creating statement...");


				String sql = " insert into coche(id, nombre, anho_creacion, "
						+ " plazas, matricula, modelo_id)  "
						+ " value(? , ? , ?, ? , ?, ?) ";

				System.out.println("sql = "+sql);

				preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				int i = 1;
				preparedStatement.setInt(i++, coche.getId());
				preparedStatement.setString(i++, coche.getNombreModelo());
				preparedStatement.setInt(i++, coche.getFechaMatriculacion());
				preparedStatement.setInt(i++, coche.getPlazas());
				preparedStatement.setString(i++, coche.getMatricula());
				preparedStatement.setLong(i++, coche.getIdModelo());

				preparedStatement.executeUpdate();

				rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					coche.setId(rs.getInt(1));
				} rs.close();
				preparedStatement.close();

			}catch (SQLException se) {
				logger.error(se);
			} catch (Exception e) {
				logger.error(e);
			} finally {		

				DBUtils.closeConnection(conn);
				DBUtils.closePreparedStatement(preparedStatement);
				DBUtils.closeResultSet(rs);
			}
			return coche;	
		}
	}


	private Coche loadNext(ResultSet rs) throws DataException, SQLException {
		Coche c = new Coche();
		Marca m = new Marca();
		Modelo mo = new Modelo();
		int i = 1;
		m.setMarca(rs.getString(i++));
		mo.setModelo(rs.getString(i++));				
		c.setFechaMatriculacion(rs.getInt(i++));			
		c.setPlazas(rs.getInt(i++));
		c.setMatricula(rs.getString(i++));
		return c;
	}



	@Override
	public void update(Coche coche) {
		// TODO Auto-generated method stub

	}



	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}


}
