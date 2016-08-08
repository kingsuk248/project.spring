package com.practice.self.project.spring.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GettingStarted {
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	@PostConstruct
	public void initialize() {
		System.out.println("Inside init-method");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Inside destroy-method");
	}
}
