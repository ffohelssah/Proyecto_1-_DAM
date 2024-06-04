package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	/**
	 * Conexión de java a mysql a través del archivo jdbc almacenado en la librearía del tomcat
	 */
	public static Connection instance = null;
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/arsedex";
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");
			
			
			instance = DriverManager.getConnection(JDBC_URL, props);
		}
		return instance;
		
	}
	

}
