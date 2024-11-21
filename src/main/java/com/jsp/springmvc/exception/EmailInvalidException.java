package com.jsp.springmvc.exception;

public class EmailInvalidException extends RuntimeException{

	private String message;
	
	public EmailInvalidException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
