package com.demo.book.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.book.dao.IBookOrderDao;
import com.demo.book.entity.BookOrder;
import com.demo.book.exception.BookOrderFoundException;
import com.demo.book.exception.BookOrderNotFoundException;


@Service
public class BookOrderServiceImpl implements IBookOrderService {
	@Autowired
	IBookOrderDao bookOrderDao;

	@Override
	public List<BookOrder> getAllBookOrders() {
		return bookOrderDao.findAll();	
		}

	@Override
	public BookOrder getBookOrderByOrderId(int orderId) throws BookOrderNotFoundException {
		
		Optional<BookOrder> bookOrder = bookOrderDao.findById(orderId);
		if(!bookOrder.isPresent()) {
			throw new BookOrderNotFoundException("BookOrder not found with given orderId "+orderId);
		}
		return bookOrder.get();
	}

	@Override
	public BookOrder addBookOrder(BookOrder bookOrder) {
		// TODO Auto-generated method stub
		Optional<BookOrder> book = bookOrderDao.findById(bookOrder.getOrderId());
		if(book.isPresent()) {
			throw new BookOrderFoundException("BookOrder already exists with given bookorderId "+bookOrder.getOrderId());
		}
		return bookOrderDao.save(bookOrder);
	}

	@Override
	public BookOrder deleteBookOrderByOrderId(int orderId) {
		BookOrder bo = bookOrderDao.findById(orderId).get();
		bookOrderDao.deleteById(orderId);
		return bo;
	}

	@Override
	public BookOrder updateBookOrder(int orderId, BookOrder bookOrder) {
		BookOrder book = bookOrderDao.findById(orderId).get();
		book.setOrderDate(bookOrder.getOrderDate());
		return bookOrderDao.save(book);
	}


	@Override
	public List<BookOrder> getAllBookOrder() {
		return null;
	}

	@Override
	public BookOrder deleteBookOrderByOrderId(String orderId) {
		return null;
	}
}
