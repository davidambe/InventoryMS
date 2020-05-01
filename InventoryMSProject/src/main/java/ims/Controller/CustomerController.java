package ims.Controller;

import java.util.List;

import org.apache.log4j.Logger;

import ims.Entities.Customer;
import ims.Services.CrudServices;
import ims.Utilities.Utils;

public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> CustomerServices;

	public CustomerController(CrudServices<Customer> CustomerServices) {
		this.CustomerServices = CustomerServices;
	}

	public String getInput() {
		return Utils.getUserInput();
	}
//Read call customers to the logger
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = CustomerServices.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

//Creates customer by taking in user input
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String lastName = getInput();
		LOGGER.info("Please enter your email");
		String email = getInput();
		LOGGER.info("Please enter your address");
		String address = getInput();
		LOGGER.info("Please enter your postcode");
		String postCode = getInput();
		Customer customer = CustomerServices.create(new Customer(0, firstName, lastName, email, address, postCode));
		LOGGER.info("Customer created");
		return customer;
	}

//Updates an existing customer by taking in new input
	@Override
	public Customer update() {
		LOGGER.info("Please enter the ID of the customer you wish to update");
		Long customerID = Long.valueOf(getInput());
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String lastName = getInput();
		LOGGER.info("Please enter your email");
		String email = getInput();
		LOGGER.info("Please enter your address");
		String address = getInput();
		LOGGER.info("Please enter your postcode");
		String postCode = getInput();
		Customer customer = CustomerServices.create(new Customer(customerID, firstName, lastName, email, address, postCode));
		LOGGER.info("Customer created");
		return customer;
	}

//Delet's customer by customerID
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you wish to delete");
		Long customerID = Long.valueOf(getInput());
		CustomerServices.delete(customerID);
	}

}
