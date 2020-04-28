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

	public static void main(String[] args) {
		// CREATE SWITCH CASE STATEMENT
		// VALIDATE INPUT //TRY CATCH FOR ERRORS
		SQLConnection customer = new SQLConnection();
		SQLConnection orders = new SQLConnection();
		SQLConnection inventory = new SQLConnection();
		Connection conn = orders.getConnection();

		customer cm1 = new customer();
		orders or1 = new orders();
		inventory iv1 = new inventory();

		// Switch case

		// Customer CRUD
		// CREATE
		cm1.createCustomer(conn, "James", "Bond", "jamesbond@aol.com", "41 Princton Road", "PR41 PD14",
				"United Kingdom", "customers");
		// READ
		// UPDATE

		// Orders CRUD

		// Inventory CRUD

	}

}
