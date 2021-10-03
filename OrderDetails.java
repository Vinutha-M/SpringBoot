package com.demo.book.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="orderDetails")
public class OrderDetails {
@Id
@GeneratedValue
private int quantity;
private double subTotal;
   
 @OneToOne(mappedBy="orderDetails",cascade=CascadeType.ALL)
 BookOrder bookOrder;
 
 @JsonIgnore
	@OneToOne(mappedBy="orderDetails",cascade= CascadeType.ALL)
	Book book;

public  int getQuantity() {
	return quantity;
}

public double getSubTotal() {
	return subTotal;
}

public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}

public BookOrder getBookOrder() {
	return bookOrder;
}

public void setBookOrder(BookOrder bookOrder) {
	this.bookOrder = bookOrder;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
