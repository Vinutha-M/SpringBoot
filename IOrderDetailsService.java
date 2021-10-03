package com.demo.book.service;

import java.util.List;

import com.demo.book.entity.OrderDetails;

import com.demo.book.exception.OrderDetailsNotFoundException;

public interface IOrderDetailsService {

	List<OrderDetails> getAllOrderDetailss();
	
	OrderDetails getOrderDetailsByOrderId(int orderId) throws OrderDetailsNotFoundException;

	OrderDetails addOrderDetails(OrderDetails orderDetails);

	OrderDetails deleteOrderDetailsByOrderId(String fullName);
	
	OrderDetails updateOrderDetails(int orderId,OrderDetails orderDetails );

		List<OrderDetails> getAllOrderDetails();

		OrderDetails deleteOrderDetailsByQuality(int Quality);

		OrderDetails deleteOrderDetailsByQuantity(int quantity);

		OrderDetails getOrderDetailsByQuantity(int quantity) throws OrderDetailsNotFoundException;


				
}