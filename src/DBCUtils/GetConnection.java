package DBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GetConnection {
	
	private static Logger logger = LogManager.getLogger(GetConnection.class);
	
	private static ResourceBundle serviceConfiguration = ResourceBundle.getBundle("ServiceConfiguration");

	static final String JDBC_DRIVER = "jdbc.driver.classname";
	static final String DB_URL = "jdbc.url";

	static final String USER = "jdbc.user";
	static final String PASS = "jdbc.password";

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
