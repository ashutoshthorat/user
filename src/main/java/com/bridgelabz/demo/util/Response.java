package com.bridgelabz.demo.util;

import lombok.Data;

@Data
public class Response {
	int statusCode;
	String message;
	Object token;
	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", message=" + message + "]";
	}

	public Response(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public Response(int statusCode, String message, Object token) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.token = token;
	}

	

}
