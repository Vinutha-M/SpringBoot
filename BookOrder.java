package com.demo.book.entity;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
public class BookOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@Column(name = "orderDate")
	private LocalDate orderDate;
	
	@Column(name = "orderTotal")
	private double orderTotal;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "shippingAddress")
	private String shippingAddress;
	
	@Column(name = "paymentMethod")
	private String paymentMethod;
	
	@Column(name = "recipientName")
	private String recipientName;
	
	@Column(name = "recipientPhone")
	private String recipientPhone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderdetails_fk")
	OrderDetails orderDetails;

	// constructors
	public BookOrder() {
	}

	  public BookOrder(int orderId, LocalDate orderDate, double orderTotal, String status, String paymentMethod,
			String shippingAddress, String recipientName, String reciepientPhone) {

		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.recipientPhone = reciepientPhone;
		this.recipientName = recipientName;
		this.shippingAddress = shippingAddress;
	} 

	// getters and setters

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getReciepentName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

			public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	
	// toString
	@Override
	public String toString() {
		return "BookOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + ", status="
				+ status + ", shippingAddress=" + shippingAddress + ",paymentMethod=" + paymentMethod
				+ ",recipientName=" + recipientName + ", recipientPhone=" + recipientPhone + "]";
	}

	

}

