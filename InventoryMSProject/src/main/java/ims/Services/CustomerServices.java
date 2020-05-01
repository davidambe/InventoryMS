package ims.Services;

import java.util.List;

import ims.Entities.Customer;

public class CustomerServices implements CrudServices<Customer> {

	private Dao<Customer> customerDao;

	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}

	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	public void delete(Long customerID) {
		customerDao.delete(customerID);
	}

}
