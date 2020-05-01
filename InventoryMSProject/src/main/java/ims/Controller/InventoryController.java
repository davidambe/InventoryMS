package ims.Controller;

import java.util.List;

import org.apache.log4j.Logger;

import ims.Entities.Inventory;
import ims.Services.CrudServices;
import ims.Utilities.Utils;

public class InventoryController implements CrudController<Inventory> {
	public static final Logger LOGGER = Logger.getLogger(InventoryController.class);

	private CrudServices<Inventory> InventoryServices;

	public InventoryController(CrudServices<Inventory> InventoryServices) {
		this.InventoryServices = InventoryServices;
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
	public List<Inventory> readAll() {
		List<Inventory> Inventory = InventoryServices.readAll();
		for (Inventory inventory : Inventory) {
			LOGGER.info(inventory.toString());
		}
		return Inventory;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Inventory create() {
		LOGGER.info("Please enter Product Name: ");
		String productName = getInput();
		LOGGER.info("Please enter Product Price: ");
		double productPrice = getIntInput();
		LOGGER.info("Please enter Product Category: ");
		String cateogry = getInput();
		LOGGER.info("Please enter Product Quantity:");
		int stock = getIntInput();
		LOGGER.info("Please enter Product max stock");
		double maxStock = getIntInput();
		Inventory Inventory = InventoryServices
				.create(new Inventory(null, productName, productPrice, cateogry, stock, maxStock, null));
		LOGGER.info("Product created");
		return Inventory;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Inventory update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long productID = Long.valueOf(getInput());
		LOGGER.info("Please enter new Product Name");
		String productName = getInput();
		LOGGER.info("Please enter Product Price");
		double productPrice = getIntInput();
		LOGGER.info("Please update Product Category");
		String category = getInput();
		LOGGER.info("Please update Product Quantity");
		int stock = getIntInput();
		LOGGER.info("Please update Product max Stock");
		double maxStock = getIntInput();
		Inventory Inventory = InventoryServices
				.update(new Inventory(productID, productName, productPrice, category, stock, maxStock, null));
		LOGGER.info("Order Updated");
		return Inventory;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the Product you would like to delete from Inventory");
		Long productID = Long.valueOf(getInput());
		InventoryServices.delete(productID);
	}
}
