package com.practice.self.project.spring;

import org.springframework.beans.factory.InitializingBean;

public class Initializer implements InitializingBean{

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set: " + message);
	}

}
