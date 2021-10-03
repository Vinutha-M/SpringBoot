package com.demo.book.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book.entity.BookOrder;
import com.demo.book.exception.BookOrderNotFoundException;
import com.demo.book.service.IBookOrderService;


@RestController
public class BookOrderController {
	@Autowired
	IBookOrderService bookOrderService;
	
	//get all bookOrders
	@GetMapping("/bookorders")
	ResponseEntity<List<BookOrder>> getAllBookOrders() {
		return new ResponseEntity<>(bookOrderService.getAllBookOrders(), HttpStatus.OK); // 200 Ok
	}
	
	// Get bookOrder by bookOrderId - GET
			@GetMapping("/bookorders/bookorderId/{bookorderId}")
			ResponseEntity<BookOrder> getBookOrderByBookOrderId(@PathVariable("bookorderId") int bookorderId) throws BookOrderNotFoundException  {
			BookOrder bookOrder = bookOrderService.getBookOrderByOrderId(bookorderId);
			 return new ResponseEntity<>(bookOrder, HttpStatus.OK); // 200 Ok
				
			}
	
	// Get bookOrder by Name - GET
		@GetMapping("/bookorders/orderId/{orderId}")
		ResponseEntity<BookOrder> getBookOrderByOrderId(@PathVariable("orderId") int orderId) throws BookOrderNotFoundException {
			BookOrder bookorder = bookOrderService.getBookOrderByOrderId(orderId);
			return new ResponseEntity<>(bookorder, HttpStatus.OK);
		}
		
		// Add new bookOrder - POST
		@PostMapping("/bookorders")
		ResponseEntity<BookOrder> addBookOrder(@RequestBody BookOrder bookorder) {
			BookOrder bo = bookOrderService.addBookOrder(bookorder);
			return new ResponseEntity<>(bo, HttpStatus.CREATED); // 201 created
		}
		
		// Delete bookOrder by orderId - DELETE
		@DeleteMapping("/bookorders/{orderId}")
		ResponseEntity<BookOrder> deleteBookOrderByOrderId(@PathVariable("orderId") int orderId) {
			BookOrder bookorder= bookOrderService.deleteBookOrderByOrderId(orderId);
			return new ResponseEntity<>(bookorder, HttpStatus.OK);
		}
		
		//Delete bookOrder by name
		@DeleteMapping("/BookOrders/delete/{orderId}")
		ResponseEntity<Void> deleteBookOrder(@PathVariable("orderId") String orderId) {
			bookOrderService.deleteBookOrderByOrderId(orderId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		// Update bookOrder - PUT
		@PutMapping("/BookOrders/{orderId}")
		ResponseEntity<BookOrder> updateBookOrder(@PathVariable("orderId") int orderId, @RequestBody BookOrder bookorder) {
		 BookOrder cus = bookOrderService.updateBookOrder(orderId, bookorder);
		 return new ResponseEntity<>(cus, HttpStatus.OK);
		}
		
		// update student name - PATCH
		@PatchMapping("/BookOrders/{orderId}")
		ResponseEntity<BookOrder> updateBookOrderName(@PathVariable("orderId") int orderId, @RequestBody BookOrder newName) {
			BookOrder bookOrder = bookOrderService.updateBookOrder(orderId, newName);
			return new ResponseEntity<>(bookOrder, HttpStatus.OK);
		}


}
