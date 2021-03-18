package DBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GetConnection {
	
	private static Logger logger = LogManager.getLogger(GetConnection.class);

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/driveventures";

	static final String USER = "driveventures";
	static final String PASS = "Driveventures123";

	static {
		try {

			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static final Connection getConnection()
			throws SQLException {		

		return DriverManager.getConnection(DB_URL, USER, PASS);
	}


}
