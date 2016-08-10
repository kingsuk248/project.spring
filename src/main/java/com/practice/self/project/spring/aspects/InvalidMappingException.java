package com.practice.self.project.spring.aspects;

public class InvalidMappingException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidMappingException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
