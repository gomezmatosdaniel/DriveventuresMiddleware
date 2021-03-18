package DBCUtils;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement preparedStatement;

	
	public static void closeResultSet(ResultSet rs)
			throws DataException {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DataException(e);
				}
			}

		}
	
	public static void closePreparedStatement(PreparedStatement preparedStatement)
	throws DataException {
		
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new DataException(e);
			}
		}
	}

	
		public static void closeStatement(Statement stmt)
			throws DataException {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new DataException(e);
				}
			}

		}


		public static void closeConnection(Connection conn)
				throws DataException {
			
			if (conn != null) {
				try {
	
					if (!conn.getAutoCommit()) {
						throw new DataException("Autocommit disabled. Commit or Rollback should be done explicitly.");
					}			
					
					conn.close();
				} catch (SQLException e) {
					throw new DataException(e);
				}
			}
		}
		
	
	
		public static void closeConnection(Connection conn, boolean commitOrRollback)
			throws DataException {
	        try {
	            if (conn != null) {
	                if (commitOrRollback) {
	                	conn.commit();
	                } else {
	                	conn.rollback();                        
	                }
	                conn.close();
	            }
	        } catch (SQLException e) {
	            throw new DataException(e);
	        }
		}

	
}
