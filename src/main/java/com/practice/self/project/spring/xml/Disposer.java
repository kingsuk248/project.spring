package com.practice.self.project.spring.xml;

import org.springframework.beans.factory.DisposableBean;

public class Disposer implements DisposableBean{

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void destroy() throws Exception {
		System.out.println("Destroy: " + message);
	}

}
