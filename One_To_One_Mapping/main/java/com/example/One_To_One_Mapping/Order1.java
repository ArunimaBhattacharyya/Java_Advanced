package com.example.One_To_One_Mapping;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order1 {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String orderNumber;
	
	@Column
	private String productName;
	
	@Column 
	private int quantity;
	
	@Column
	private double price;
	
	@Column
	private LocalDate orderDate;
	
	@OneToOne(mappedBy = "order")
	private Customer1 customer;
	
	public Order1() {
		
	}

	public Order1(int id, String orderNumber, String productName, int quantity, double price, LocalDate orderDate) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customer1 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer1 customer) {
		this.customer = customer;
	}
	
	

}

