package com.bridgelabz.demo.exception;

import lombok.Data;

@Data
public class UserException extends RuntimeException {
	
	private long statusCode;
	private String statusmessage;
	public UserException(long statusCode, String statusmessage) {
		super();
		this.statusCode = statusCode;
		this.statusmessage = statusmessage;
	}
}
