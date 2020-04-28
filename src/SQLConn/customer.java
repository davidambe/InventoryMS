package SQLConn;

import java.sql.*;

public class customer {
	// CRUD, CREATE, READ, UPDATE, DELETE for customer
	Connection conn = null;
	Statement stmt = null;

	public void createCustomer(Connection conn, String firstName, String lastName, String email, String address,
			String postCode, String country, String tableName) {
//Create Statement
		try {
			stmt = conn.createStatement();
			System.out.println("Starting Insert Statement....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Insert
		String sqlInsert = "INSERT INTO " + tableName
				+ "(firstName, lastName, email, address, postCode, country) VALUES('" + firstName + "','" + lastName
				+ "','" + email + "','" + address + "','" + postCode + "','" + country + "')";
//Execute create statement
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Record Inserted Successfully!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer(Connection conn, int customerID, String firstName, String lastName, String email,
			String address, String postCode, String country, String region, String tableName) {
//Create statement (conn create)
		try {
			stmt = conn.createStatement();
			System.out.println("Starting Update to" + tableName + "...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Update
		String SQL10 = "update " + tableName + " SET firstName = '" + firstName + "' WHERE customerID= '" + customerID
				+ "';";
//Execution
		try {
			stmt.executeUpdate(SQL10);
			System.out.println("Record has been Inserted Successfully!!");
		} catch (SQLException e) {
			System.out.println("Error, an Error has Occurred!");
			e.printStackTrace();
		}
	}

	public void selectCustomer(Connection conn, int customerID, String tableName) {
//Create statement
		try {
			stmt = conn.createStatement();
			System.out.println("Begining Select Statement...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Select STMT
		String SQL11 = "SELECT customerID, firstName, lastName, email, address, postCode, country, region " + "FROM "
				+ tableName + "WHERE customerID = '" + customerID + "';";
		ResultSet rs = null;
		System.out.println("Selecting records...");
		try {
			rs = stmt.executeQuery(SQL11);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int customerID1 = rs.getInt("customerID");
				String firstName1 = rs.getString("firstName");
				String lastName1 = rs.getString("lastName");
				String email1 = rs.getString("email");
				String address1 = rs.getString("address");
				String postCode1 = rs.getString("postCode");
				String country1 = rs.getString("country");
				String region1 = rs.getString("region");
				System.out.println("cusstomerID: " + customerID1 + " firstName: " + firstName1 + " lastName: "
						+ lastName1 + " email: " + email1 + " address: " + address1 + " postCode: " + postCode1
						+ " country: " + country1 + " region: " + region1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomer(Connection conn, int customerID, String tableName) {
//Create Statement
		try {
			stmt = conn.createStatement();
			System.out.println("Warning about to start DELETE statement\n Starting DELETE statement...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Delete STMT
		System.out.println("About to delete record!!");
		String SQL12 = "DELETE FROM customer WHERE customerID= '" + customerID + "';";
		try {
			stmt.execute(SQL12);
			System.out.println("Record has Successfully been DELETED from the Database: " + tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
