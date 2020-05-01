package ims.Controller;

import java.util.List;

import org.apache.log4j.Logger;

import ims.Entities.Orders;
import ims.Services.CrudServices;
import ims.Utilities.Utils;

public class OrdersController implements CrudController<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrdersController.class);

	private CrudServices<Orders> ordersServices;

	public OrdersController(CrudServices<Orders> ordersServices) {
		this.ordersServices = ordersServices;
	}

	public String getInput() {
		return Utils.getUserInput();
	}

	int getIntInput() {
		return Utils.getIntInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> Orders = ordersServices.readAll();
		for (Orders orders : Orders) {
			LOGGER.info(orders.toString());
		}
		return Orders;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Orders create() {
		LOGGER.info("Please enter Product Name: ");
		String productName = getInput();
		LOGGER.info("Please enter Product Price: ");
		double productPrice = getIntInput();
		LOGGER.info("Please enter the Quantity you would like to order");
		int quantity_orderd = getIntInput();
		Orders order = ordersServices.create(new Orders(null, productName, productPrice, quantity_orderd));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long orderID = Long.valueOf(getInput());
		LOGGER.info("Please enter new product Name");
		String productName = getInput();
		LOGGER.info("Please enter Product Price");
		double productPrice = getIntInput();
		LOGGER.info("Please update Order Quantity");
		Orders orders = ordersServices.update(new Orders(orderID, productName, productPrice, 0));
		LOGGER.info("Order Updated");
		return orders;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long orderID = Long.valueOf(getInput());
		ordersServices.delete(orderID);
	}

}
