package com.demo.book.exception;

public class BookOrderFoundException extends RuntimeException{
	public BookOrderFoundException() {
		super();
	}
	public BookOrderFoundException(String message) {
		super(message);
		
	}

	public BookOrderFoundException(Throwable cause) {
		super(cause);
		
	}

}