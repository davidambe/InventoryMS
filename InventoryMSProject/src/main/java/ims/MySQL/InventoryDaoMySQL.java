package ims.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ims.Entities.Inventory;
import sqlConnection.SQLConnection;

public class InventoryDaoMySQL {
	Connection conn = null;
	Statement stmt = null;

	public Object createProduct(Connection conn, String productName, String category, int stock, int maxStock, int i,
			int j, Inventory inventory) {
//Create Statement
		try {
			stmt = conn.createStatement();
			System.out.println("Starting Insert Statement....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Insert
		String sqlInsert = "INSERT INTO " + inventory
				+ "(productName, category, stock, maxStock, restock_date, order_quantity) VALUES('" + productName
				+ "','" + category + "','" + stock + "','" + maxStock + "','" + i + "','" + j + "')";
//Execute create statement
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Product Inserted Successfully!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return createProduct(conn, sqlInsert, sqlInsert, j, j, j, j, inventory);
	}

	public Object updateInventory(Connection conn, int productID, String productName, String category, int stock,
			int maxStock, java.util.Date restock_date, int order_quantity, Inventory inventory) {
//Create statement (conn create)
		try {
			stmt = conn.createStatement();
			System.out.println("Starting Update to" + inventory + "...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Update
		String SQL10 = "update " + inventory + " SET productName = '" + productName + "' WHERE productID= '" + productID
				+ "';";
//Execution
		try {
			stmt.executeUpdate(SQL10);
			System.out.println("Record has been Inserted Successfully!!");
		} catch (SQLException e) {
			System.out.println("Error, an Error has Occurred!");
			e.printStackTrace();
		}
		return updateInventory(conn, order_quantity, SQL10, SQL10, order_quantity, order_quantity, restock_date,
				order_quantity, inventory);
	}

	public Object selectProduct(Connection conn, int productID, Inventory inventory) {
//Create statement
		try {
			stmt = conn.createStatement();
			System.out.println("Begining Select Statement...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Select STMT
		String SQL11 = "SELECT productID, productName, category, stock, maxStock, restock_date, order_quantity "
				+ "FROM " + inventory + "WHERE productID = '" + productID + "';";
		ResultSet rs = null;
		System.out.println("Selecting records...");
		try {
			rs = stmt.executeQuery(SQL11);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int productID1 = rs.getInt("productID");
				String productName1 = rs.getString("productName");
				String category1 = rs.getString("category");
				String stock1 = rs.getString("stock");
				String maxStock1 = rs.getString("maxStock");
				String restock_date1 = rs.getString("restock_date");
				String order_quantity1 = rs.getString("order_quantity");
				System.out.println("productID: " + productID1 + " productName: " + productName1 + " category: "
						+ category1 + " stock: " + stock1 + " maxStock: " + maxStock1 + " restock_date: "
						+ restock_date1 + " order_quantity: " + order_quantity1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectProduct(conn, productID, inventory);
	}

	public Object deleteProduct(Connection conn, int productID, Inventory inventory) {
//Create Statement
		try {
			stmt = conn.createStatement();
			System.out.println("Warning about to start DELETE statement\n Starting DELETE statement...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//SQL Delete STMT
		System.out.println("About to delete record!!");
		String SQL12 = "DELETE FROM inventory WHERE productID= '" + productID + "';";
		try {
			stmt.execute(SQL12);
			System.out.println("Record has Successfully been DELETED from the Database: " + inventory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteProduct(conn, productID, inventory);
	}

	public void createProduct(Connection conn2, String productName, String category, int stock, int maxStock, int i,
			int j, SQLConnection inventory) {
		// TODO Auto-generated method stub

	}

	public void selectProduct(Connection conn2, int productID, SQLConnection inventory) {
		// TODO Auto-generated method stub

	}

	public void updateInventory(Connection conn2, int productID, String productName, String category, int stock,
			int maxStock, Object restock_date, int order_quantity, SQLConnection inventory) {
		// TODO Auto-generated method stub

	}

	public void deleteProduct(Connection conn2, int productID, SQLConnection inventory) {
		// TODO Auto-generated method stub

	}

}
