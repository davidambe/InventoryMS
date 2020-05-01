package sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	private static String JDBC_DRIVER;
	private static String DB_URL;
	Connection conn = null;
	Statement stmt = null;

	public Connection getConnection() {
		return conn;
	}

	@SuppressWarnings("static-access")
	public SQLConnection(String USER, String PASS) {

		this.JDBC_DRIVER = "com.mysql.jdbc.Driver";
		this.DB_URL = "jdbc:mysql://localhost:3306/inventorymstest?useSSL=false";
		// Establishing Connection
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Starting Database Connection...");

		// Connection Established!!
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected!!\n ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
