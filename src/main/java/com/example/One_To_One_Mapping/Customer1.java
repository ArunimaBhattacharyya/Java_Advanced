package com.example.One_To_One_Mapping;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")

public class Customer1 {

	@Id
	@Column
	private int id;
	
	@Column
	private String customerName;
	
	@Column
	private String email;
	
	@Column
	private String gender;
	
	@Column
	private long phone;
	
	@Column
	private LocalDate registrationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order1 order;
	
	public Customer1() {
		
	}

	public Customer1(int id, String customerName, String email, String gender, long phone, LocalDate registrationDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.registrationDate = registrationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Order1 getOrder() {
		return order;
	}

	public void setOrder(Order1 order) {
		this.order = order;
	}
	
	

}


