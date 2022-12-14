package com.order.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false,columnDefinition = "DATE")
	private LocalDate orderDate;
	
//	private int customerId;

	
	@Column(nullable = false)
	private double ammountPaid;
	
	@Column(nullable = false)
	private String modeOfPayment;
	
	@Column(nullable = false)
	private String orderStatus;
	
	@Column(nullable = false)
	private int quantity;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
					name="order_has_address",
					joinColumns=@JoinColumn(name="order_id"),
					inverseJoinColumns = @JoinColumn(name="customer_id")
			)
	private List<Address> address;
	
	
	
	public Orders(Long id, LocalDate orderDate, double ammountPaid, String modeOfPayment,
			String orderStatus, int quantity) {
		super();
		this.id = id;
		this.orderDate = orderDate;
//		this.customerId = customerId;
		this.ammountPaid = ammountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	

	public double getAmmountPaid() {
		return ammountPaid;
	}

	public void setAmmountPaid(double ammountPaid) {
		this.ammountPaid = ammountPaid;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
