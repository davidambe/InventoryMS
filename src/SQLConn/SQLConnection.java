package SQLConn;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

public class SQLConnection {

	private static String JDBC_DRIVER;
	private static String DB_URL;
	private static String USER;
	private static String PASS;

	Connection conn = null;
	Statement stmt = null;

	public Connection getConnection() {
		return conn;
	}

	public SQLConnection() {

		this.JDBC_DRIVER = "com.mysql.jdbc.Driver";
		this.DB_URL = "jdbc:mysql://localhost:3306/inventoryms?useSSL=false";
		this.USER = "root";
		this.PASS = "root";

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
			System.out.println("Connected!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
