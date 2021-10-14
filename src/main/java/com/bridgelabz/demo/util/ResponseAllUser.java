package com.bridgelabz.demo.util;

import lombok.Data;

@Data
public class ResponseAllUser {
	int statusCode;
	String statusMessage;
	Object token;
	public ResponseAllUser(int statusCode, String statusMessage, Object token) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.token = token;
	}
	
}
