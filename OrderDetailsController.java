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

import com.demo.book.entity.OrderDetails;
import com.demo.book.exception.OrderDetailsNotFoundException;
import com.demo.book.service.IOrderDetailsService;

@RestController
public class OrderDetailsController {
	@Autowired
	IOrderDetailsService orderDetailsService;

	// get all orderDetails
	@GetMapping("/orderdetails")
	ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
		return new ResponseEntity<>(orderDetailsService.getAllOrderDetails(), HttpStatus.OK); // 200 Ok
	}

	// Get orderDetails by orderDetailsId - GET
	@GetMapping("/orderdetails/quantity/{quantity}")
	ResponseEntity<OrderDetails>getOrderDetailsByQuantity(@PathVariable("quantity") int quantity)
			throws OrderDetailsNotFoundException {
		OrderDetails orderDetails = orderDetailsService.getOrderDetailsByQuantity(quantity);
		return new ResponseEntity<>(orderDetails, HttpStatus.OK); // 200 Ok

	}

	// Add new orderDetails - POST
	@PostMapping("/orderdetails")
	ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
		OrderDetails od = orderDetailsService.addOrderDetails(orderDetails);
		return new ResponseEntity<>(od, HttpStatus.CREATED); // 201 created
	}

	// Delete orderDetails by quantity - DELETE
	@DeleteMapping("/orderdetails/{quantity}")
	ResponseEntity<OrderDetails> deleteOrderDetailsByOrderId(@PathVariable("quantity") int quantity) {
		OrderDetails orderDetails = orderDetailsService.deleteOrderDetailsByQuantity(quantity);
		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
	}

	// Delete orderDetails by name
	@DeleteMapping("/OrderDetailss/delete/{quantity}")
	ResponseEntity<Void> deleteOrderDetails(@PathVariable("quantity") String quantity) {
		orderDetailsService.deleteOrderDetailsByOrderId(quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Update orderDetails - PUT
	@PutMapping("/OrderDetails")
	ResponseEntity<OrderDetails> updateOrderDetails(
			@RequestBody OrderDetails orderDetails) {
		OrderDetails od = orderDetailsService.addOrderDetails(orderDetails);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

	// update  orderDetails - PATCH
	@PatchMapping("/OrderDetails/{quantity}")
	ResponseEntity<OrderDetails> updateOrderDetailsQuantity(@PathVariable("quantity") int quantity,
			@RequestBody OrderDetails orderDetails) {
		OrderDetails od = orderDetailsService.updateOrderDetails(quantity, orderDetails);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

}

