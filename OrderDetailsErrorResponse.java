package com.demo.book.entity;

import lombok.Data;

@Data
public class OrderDetailsErrorResponse {
    
	private int status;
	
	private String message;
	
	private long timeStamp;

	public void setStatus(int value) {
		
		
	}

	public void setMessage(String message2) {
		
	}

	public void setTimeStamp(long currentTimeMillis) {
		
		
	}


}