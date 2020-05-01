package ims.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ims.Entities.Customer;
import ims.Services.Dao;
import ims.Utilities.Utils;

public class CustomerDaoMySQL implements Dao<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMySQL.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public void CustomerDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = Utils.MYSQL;
		this.username = username;
		this.password = password;
	}

	public void CustomerDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}


	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		Long customerID = resultSet.getLong("customerID");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("surname");
		String email = resultSet.getString("email");
		String address = resultSet.getString("address");
		String postCode = resultSet.getString("PostCode");

		return new Customer(customerID, firstName, lastName, email, address, postCode);
	}

//Read
	@Override
	public List<Customer> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from customers");) {
			ArrayList<Customer> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(customerFromResultSet(resultSet));
			}
			return customers;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Customer readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

// Creates a customer in the database
	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into customers(firstName, lastName) values('" + customer.getfirstName()
					+ "','" + customer.getlastName() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Customer readCustomer(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM customers where id = " + id);) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

//Updates
	@Override
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update customers set first_name ='" + customer.getfirstName() + "', lasatname ='"
					+ customer.getlastName() + "' where id =" + customer.getCustomerID());
			return readCustomer(customer.getCustomerID());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

//Delete
	public void delete(long customerID) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customers where id = " + customerID);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void delete(Long customerID) {
		// TODO Auto-generated method stub
		
	}

}
