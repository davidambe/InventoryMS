package ims.Services;

import java.util.List;

import ims.Entities.Orders;

public class OrdersServices implements CrudServices<Orders> {

	private Dao<Orders> ordersDao;

	public OrdersServices(Dao<Orders> ordersDao) {
		this.ordersDao = ordersDao;
	}

	public List<Orders> readAll() {
		return ordersDao.readAll();
	}

	public Orders create(Orders orders) {
		return ordersDao.create(orders);
	}

	public Orders update(Orders orders) {
		return ordersDao.update(orders);
	}

	public void delete(Long orderID) {
		ordersDao.delete(orderID);
	}

}
