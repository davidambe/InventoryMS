package ims.Services;

import java.util.List;

import ims.Entities.Inventory;

public class InventoryServices implements CrudServices<Inventory> {

	private Dao<Inventory> inventoryDao;

	public InventoryServices(Dao<Inventory> inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	public List<Inventory> readAll() {
		return inventoryDao.readAll();
	}

	public Inventory create(Inventory inventory) {
		return inventoryDao.create(inventory);
	}

	public Inventory update(Inventory inventory) {
		return inventoryDao.update(inventory);
	}

	public void delete(Long productID) {
		inventoryDao.delete(productID);
	}

}
