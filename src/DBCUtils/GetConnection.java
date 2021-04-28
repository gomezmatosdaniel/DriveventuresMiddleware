package DBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class GetConnection {
	
	private static Logger logger = LogManager.getLogger(GetConnection.class);
	
	private static ResourceBundle DBConfiguration = ResourceBundle.getBundle("DBConfiguration");
	
	private static final String DRIVER_CLASS_NAME_PARAMETER = "jdbc.driver.classname";
	private static final String URL_PARAMETER = "jdbc.url";
	private static final String USER_PARAMETER = "jdbc.user";
	private static final String PASSWORD_PARAMETER = "jdbc.password";
	
	private static String url;
	private static String user;
	private static String password;
	
	private static ComboPooledDataSource dataSource = null;
	
	
	static {
		try {

			String driverClassName = DBConfiguration.getString(DRIVER_CLASS_NAME_PARAMETER);
			url = DBConfiguration.getString(URL_PARAMETER);
			user = DBConfiguration.getString(USER_PARAMETER);
			password = DBConfiguration.getString(PASSWORD_PARAMETER);
			
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass(driverClassName); //loads the jdbc driver            
			dataSource.setJdbcUrl(url);
			dataSource.setUser(user);                                  
			dataSource.setPassword(password);  
			
			
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static final Connection getConnection()
			throws SQLException {		

		return dataSource.getConnection();
	}


}
