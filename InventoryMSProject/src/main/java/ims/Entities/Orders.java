package ims.Entities;

import java.util.Date;

public class Orders {
	private Long orderID;
	private String productName;
	private double productPrice;
	private int quantity_orderd;
	private Date order_date;
	private String orderStatus;
	private Date shipped_date;

	// CREATE
	public Orders(Long orderID, String productName, double productPrice, int quantity_orderd) {
		this.orderID = orderID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity_orderd = quantity_orderd;
		//this.order_date = order_date;
		//this.orderStatus = orderStatus;
		//this.shipped_date = shipped_date;
	}

	// Getters
	public Long getOrder() {
		return orderID;
	}

	public String getproductName() {
		return productName;
	}

	public double getproductPrice() {
		return productPrice;
	}

	public int getqtyOrderd() {
		return quantity_orderd;
	}

	public Date getorderDate() {
		return order_date;
	}

	public String getorderStatus() {
		return orderStatus;
	}

	public Date getshippedDate() {
		return shipped_date;
	}

	// Setters
	public void setCustomerID(Long orderID) {
		this.orderID = orderID;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public void setproductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setqtyOrderd(int quantity_orderd) {
		this.quantity_orderd = quantity_orderd;
	}

	public void setorderDate(Date order_date) {
		this.order_date = order_date;
	}

	public void setorderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setshippedDate(Date shipped_date) {
		this.shipped_date = shipped_date;
	}

	public static void add(Orders orders) {
		// TODO Auto-generated method stub
		
	}

}