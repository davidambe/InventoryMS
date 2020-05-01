package ims.MySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ims.Entities.Orders;
import sqlConnection.SQLConnection;

public class OrdersDaoMySQL {
	Connection conn = null;
	Statement stmt = null;

	public Object createOrder(Connection conn, int orderID, String productName, int productPrice, int quantity_ordered,
			int i, String orderStatus, int j, SQLConnection orders) {
//Create Statement
		try {
			stmt = conn.createStatement();
			System.out.println("Starting creation of Order....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Insert
		String sqlInsert = "INSERT INTO " + orders
				+ "(productName, productPrice, quantity_ordered, order_date, orderStatus, shipped_date) VALUES('"
				+ productName + "','" + productPrice + "','" + quantity_ordered + "','" + i + "','" + orderStatus
				+ "','" + j + "')";
//Execute create statement
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Order Created Successfully!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return createOrder(conn, orderID, productName, productPrice, quantity_ordered, j, orderStatus, j, orders);
	}

	public Object updateOrder(Connection conn, int orderID, String productName, int productPrice, int quantity_ordered,
			int i, String orderStatus, Date shipped_date, SQLConnection tableName) {
//Create statement (conn create)
		try {
			stmt = conn.createStatement();
			System.out.println("Starting Update to" + tableName + "...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Update
		String SQL10 = "update " + tableName + " SET productName = '" + productName + "' WHERE orderID= '" + orderID
				+ "';";
//Execution
		try {
			stmt.executeUpdate(SQL10);
			System.out.println("Record has been Inserted Successfully!!");
		} catch (SQLException e) {
			System.out.println("Error, an Error has Occurred!");
			e.printStackTrace();
		}
		return updateOrder(conn, i, productName, orderID, i, i, SQL10, shipped_date, tableName);
	}

	public Object selectOrder(Connection conn, int orderID, SQLConnection orders) {
//Create statement
		try {
			stmt = conn.createStatement();
			System.out.println("Begining Select Statement...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Select STMT
		String SQL11 = "SELECT orderID, productName, productPrice, quantity_ordered, order_date, orderStatus, shipped_date "
				+ "FROM " + orders + "WHERE orderID = '" + orderID + "';";
		ResultSet rs = null;
		System.out.println("Selecting records...");
		try {
			rs = stmt.executeQuery(SQL11);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int orderID1 = rs.getInt("orderID");
				String productName1 = rs.getString("productName");
				int productPrice1 = rs.getInt("productPrice");
				int quantity_ordered1 = rs.getInt("quantity_ordered");
				Date order_date1 = rs.getDate("order_date");
				String orderStatus1 = rs.getString("orderStatus");
				Date shipped_date1 = rs.getDate("shipped_date");
				System.out.println("orderID: " + orderID1 + " productName: " + productName1 + " productPrice: "
						+ productPrice1 + " quantity_ordered: " + quantity_ordered1 + " order_date: " + order_date1
						+ " orderStatus: " + orderStatus1 + " shipped_date: " + shipped_date1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectOrder(conn, orderID, orders);
	}

	public Object deleteOrder(Connection conn, int orderID, Orders order) {
//Create Statement
		try {
			stmt = conn.createStatement();
			System.out.println("Warning about to start DELETE statement\n Starting DELETE statement...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Delete STMT
		System.out.println("About to delete record!!");
		String SQL12 = "DELETE FROM orders WHERE orderID= '" + orderID + "';";
		try {
			stmt.execute(SQL12);
			System.out.println("Record has Successfully been DELETED from the Database: " + order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteOrder(conn, orderID, order);
	}

}
