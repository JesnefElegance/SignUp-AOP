package com.jsp.springmvc.exception;

public class PasswordInvalidException extends RuntimeException {

	private String message;
	
	public PasswordInvalidException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
