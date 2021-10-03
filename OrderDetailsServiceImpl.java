package com.demo.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.book.dao.IOrderDetailsDao;
import com.demo.book.entity.OrderDetails;
import com.demo.book.exception.OrderDetailsFoundException;
import com.demo.book.exception.OrderDetailsNotFoundException;


@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {
	@Autowired
	IOrderDetailsDao orderDetailsDao;

	@Override
	public List<OrderDetails> getAllOrderDetailss() {
		return orderDetailsDao.findAll();	
		}

	public OrderDetails getOrderDetailsByQuantity(int quantity) throws OrderDetailsNotFoundException {
		
		Optional<OrderDetails> orderDetails = orderDetailsDao.findByQuantity(quantity);
		if(!orderDetails.isPresent()) {
			throw new OrderDetailsNotFoundException("OrderDetails not found with given quantity "+quantity);
		}
		return orderDetails.get();
	}

	@Override
	public OrderDetails addOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		Optional<OrderDetails> od = orderDetailsDao.findByQuantity(orderDetails.getQuantity());
		if(od.isPresent()) {
			throw new OrderDetailsFoundException("OrderDetails already exists with given quantity "+orderDetails.getQuantity());
		}
		return orderDetailsDao.save(orderDetails);
	}

	@Override
	public OrderDetails deleteOrderDetailsByQuantity(int quantity) {
		OrderDetails od = orderDetailsDao.findByquantity(quantity);
		orderDetailsDao.deleteByQuantity(quantity);
		return od;
	}

	@Override
	public OrderDetails updateOrderDetails(int quantity, OrderDetails orderDetails) {
		OrderDetails od = orderDetailsDao.findByquantity(quantity);
		od.setQuantity(orderDetails.getQuantity());
		return orderDetailsDao.save(od);
	}


	@Override
	public List<OrderDetails> getAllOrderDetails() {
		return null;
	}

    @Override
	public OrderDetails deleteOrderDetailsByQuality(int quality) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails getOrderDetailsByOrderId(int orderId) throws OrderDetailsNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails deleteOrderDetailsByOrderId(String fullName) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
