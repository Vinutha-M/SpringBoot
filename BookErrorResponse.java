package com.demo.book.entity;

import lombok.Data;

@Data
public class BookErrorResponse {
	private int status;
	private String message;
	private long timeStamp;

}
