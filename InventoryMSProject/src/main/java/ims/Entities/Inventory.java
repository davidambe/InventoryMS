package ims.Entities;

import java.util.Date;

public class Inventory {
	private Long productID;
	private String productName;
	private double productPrice;
	private String category;
	private int stock;
	private double maxStock;
	private Date restock_date;

	public Inventory(Long productID, String productName, double productPrice, String category, int stock,
			double maxStock, Date restock_date) {

		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.stock = stock;
		this.maxStock = maxStock;
		this.restock_date = restock_date;
	}

	// Getters
	public Long productID() {
		return productID;
	}

	public String productName() {
		return productName;
	}

	public double productPrice() {
		return productPrice;
	}

	public String category() {
		return category;
	}

	public int stock() {
		return stock;
	}

	public double maxStock() {
		return maxStock;
	}

	public Date restock_date() {
		return restock_date;
	}

//	public int order_quantity() {
//		return order_quantity;
//	}

	// Setters
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setMaxStock(double maxStock) {
		this.maxStock = maxStock;
	}

	public void setRestockDate(Date restock_date) {
		this.restock_date = restock_date;
	}

	public static void add(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

//	public void setOrderQty(int order_quantity) {
//		this.order_quantity = order_quantity;
//	}
}
