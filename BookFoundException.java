package com.demo.book.exception;

public class BookFoundException extends RuntimeException {
	public BookFoundException() {
		super();	
	}
	public BookFoundException(String message) {
		super(message);
		
	}

	public BookFoundException(Throwable cause) {
		super(cause);
		
	}

}
