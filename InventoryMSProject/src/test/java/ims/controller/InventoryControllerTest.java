package ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import ims.Controller.InventoryController;
import ims.Entities.Inventory;
import ims.Services.InventoryServices;

@RunWith(MockitoJUnitRunner.class)
public class InventoryControllerTest {

	// What i want to mock
	@Mock
	private InventoryServices inventoryServices;

	@Spy // Used to mock the methods inside the item im testing
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private InventoryController inventoryController;

	@Test
	public void readAllTest() {
		InventoryController inventoryController = new InventoryController(inventoryServices);
		List<Inventory> customers = new ArrayList<>();
		Inventory.add(new Inventory(null, null, 0, null, 0, 0, null));
		Inventory.add(new Inventory(null, null, 0, null, 0, 0, null));
		Inventory.add(new Inventory(null, null, 0, null, 0, 0, null));
		Mockito.when(inventoryServices.readAll()).thenReturn(customers);
		assertEquals(customers, inventoryController.readAll());
	}

	@Test
	public void createTest() {
		String productName = "Chris";
		double productPrice = 20;
		String category = "this adrress";
		int stock = 5;
		double maxStock = 40;
		Date restock_date = null;
		Mockito.doReturn(productName, productPrice).when(inventoryController).getInput();
		Inventory inventory = new Inventory(null, category, maxStock, category, stock, maxStock, restock_date);
		Inventory savedInventory = new Inventory(null, category, maxStock, category, stock, maxStock, restock_date);
		Mockito.when(inventoryServices.create(savedInventory)).thenReturn(savedInventory);
		assertEquals(savedInventory, inventoryController.create());
	}

	@Test
	public void updateTest() {
		String productID = "1";
		String productName = "Rhys";
		double productPrice = 20;
		String category = "this adrress";
		int stock = 5;
		double maxStock = 40;
		Mockito.doReturn(productID, productName, productPrice).when(inventoryController).getInput();
		Inventory inventory = new Inventory(null, productName, productPrice, category, stock, maxStock, null);
		Mockito.when(inventoryServices.update(inventory)).thenReturn(inventory);
		assertEquals(inventory, inventoryController.update());
	}

	// if result is true delete works
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(inventoryController).getInput();
		inventoryController.delete();
		Mockito.verify(inventoryServices, Mockito.times(1)).delete(1L);
	}

}
