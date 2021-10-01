package com.demo.book.exception;

public class CategoryFoundException extends RuntimeException {
	public CategoryFoundException() {
		super();	
	}
	public CategoryFoundException(String message) {
		super(message);
		
	}

	public CategoryFoundException(Throwable cause) {
		super(cause);
		
	}

}
