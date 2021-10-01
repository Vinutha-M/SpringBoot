package com.demo.book.exception;

public class CategoryNotFoundException extends Exception{
	public CategoryNotFoundException() {
		super();
		
	}

	public CategoryNotFoundException(String message) {
		super(message);
		
	}

	public CategoryNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
