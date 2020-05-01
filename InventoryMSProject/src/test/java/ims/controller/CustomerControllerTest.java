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

import ims.Controller.CustomerController;
import ims.Entities.Customer;
import ims.Services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
//What i want to mock
	@Mock
	private CustomerServices customerServices;

	@Spy //Used to mock the methods inside the item im testing
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private CustomerController customerController;

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(0, "Chris", "P", "gad", "agsa", "asga"));
		customers.add(new Customer(0, "James", "B", "ad", "asf", "af"));
		customers.add(new Customer(0, "David", "A", "kl", "ll", "JD31 KF34"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}

	@Test
	public void createTest() {
		String firstName = "Chris";
		String lastName = "Perrins";
		String email = "this@email.com";
		String address = "this.addresss";
		String postCode = "HG12 JD21";
		Mockito.doReturn(firstName, lastName).when(customerController).getInput();
		Customer customer = new Customer(0, firstName, lastName, email, address, postCode);
		Customer savedCustomer = new Customer(3L ,firstName, lastName, email, address, postCode);
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	@Test
	public void updateTest() {
		String customerID = "1";
		String firstName = "Rhys";
		String lastName = "Thompson";
		String email = "this adrress";
		String address = "this address";
		String postCode = "FG71 HG1J";
		Mockito.doReturn(customerID, firstName, lastName).when(customerController).getInput();
		Customer customer = new Customer(3L, firstName, lastName, email, address, postCode);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}

//if result is true delete works
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

}
