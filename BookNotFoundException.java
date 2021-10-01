package com.demo.book.exception;

public class BookNotFoundException extends Exception {
	public BookNotFoundException() {
		super();
		
	}

	public BookNotFoundException(String message) {
		super(message);
		
	}

	public BookNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
