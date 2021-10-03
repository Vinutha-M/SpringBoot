package com.demo.book.exception;

public class OrderDetailsNotFoundException extends Exception{
	public OrderDetailsNotFoundException() {
		super();
		
	}

	public OrderDetailsNotFoundException(String message) {
		super(message);
		
	}

	public OrderDetailsNotFoundException(Throwable cause) {
		super(cause);
		
	}
}