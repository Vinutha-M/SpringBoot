package com.demo.book.entity;

import lombok.Data;

@Data
public class CategoryErrorResponse {
	
    private int status;
	
	private String message;
	
	private long timeStamp;

}
