package com.practice.self.project.spring.annotations;

public class GettingStarted {
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void initialize() {
		System.out.println("Inside init-method");
	}

	public void destroy() {
		System.out.println("Inside destroy-method");
	}
}
