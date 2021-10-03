package com.demo.book.service;

import java.util.List;



import com.demo.book.entity.BookOrder;

import com.demo.book.exception.BookOrderNotFoundException;

public interface IBookOrderService {

	List<BookOrder> getAllBookOrders();
	
	BookOrder getBookOrderByOrderId(int orderId) throws BookOrderNotFoundException;

	BookOrder addBookOrder(BookOrder bookorder);

	BookOrder deleteBookOrderByOrderId(String fullName);
	
	BookOrder updateBookOrder(int orderId,BookOrder bookorder );

		List<BookOrder> getAllBookOrder();

		BookOrder deleteBookOrderByOrderId(int orderId);
		
}