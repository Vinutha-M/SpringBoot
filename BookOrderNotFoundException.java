package com.demo.book.exception;

public class BookOrderNotFoundException extends Exception{
	public BookOrderNotFoundException() {
		super();
		
	}

	public BookOrderNotFoundException(String message) {
		super(message);
		
	}

	public BookOrderNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
