package com.bridgelabz.demo.util;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Email implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String to;
	String from;
	String subject;
	String body;
}
