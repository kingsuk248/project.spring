package com.practice.self.project.spring.aspects;

public class Logger {
	public void beforeAdvice() {
		System.out.println("Before setting up...");
	}
	
	public void afterAdvice() {
		System.out.println("After setting up...");
	}
	
	public void afterReturning(Object returnValue) {
		System.out.println("After returning from normal flow...");
	}
	
	public void aroundAdvice() {
		System.out.println("Before and after intializing...");
	}
	
	public void afterThrowingException(InvalidMappingException ime) {
		System.out.println("Exception occurred: " + ime.getMessage());
	}
}
