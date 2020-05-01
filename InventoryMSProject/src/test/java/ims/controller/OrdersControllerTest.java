package ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import ims.Controller.OrdersController;
import ims.Entities.Orders;
import ims.Services.OrdersServices;

@RunWith(MockitoJUnitRunner.class)
public class OrdersControllerTest {

	// What i want to mock
	@Mock
	private OrdersServices ordersServices;

	@Spy // Used to mock the methods inside the item im testing
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private OrdersController ordersController;

	@Test
	public void readAllTest() {
		OrdersController ordersController = new OrdersController(ordersServices);
		List<Orders> orders = new ArrayList<>();
		Orders.add(new Orders(null, null, 0, 0));
		Orders.add(new Orders(null, null, 0, 0));
		Orders.add(new Orders(null, null, 0, 0));
		Mockito.when(ordersServices.readAll()).thenReturn(orders);
		assertEquals(orders, ordersController.readAll());
	}

	@Test
	public void createTest() {
		String productName = "Chris";
		double productPrice = 20;
		String category = "this adrress";
		int quantity_orderd = 5;
		Mockito.doReturn(productName, productPrice).when(ordersController).getInput();
		Orders savedOrders = new Orders(null, category, productPrice, quantity_orderd);
		Mockito.when(ordersServices.create(savedOrders)).thenReturn(savedOrders);
		assertEquals(savedOrders, ordersController.create());
	}

	@Test
	public void updateTest() {
		String productID = "1";
		String productName = "Rhys";
		double productPrice = 20;
		String category = "this adrress";
		int stock = 5;
		double maxStock = 40;
		Mockito.doReturn(productID, productName, productPrice).when(ordersController).getInput();
		Orders orders = new Orders(null, category, maxStock, stock);
		Mockito.when(ordersServices.update(orders)).thenReturn(orders);
		assertEquals(orders, ordersController.update());
	}

	// if result is true delete works
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(ordersController).getInput();
		ordersController.delete();
		Mockito.verify(ordersServices, Mockito.times(1)).delete(1L);
	}
}
