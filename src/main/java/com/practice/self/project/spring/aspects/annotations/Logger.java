package com.practice.self.project.spring.aspects.annotations;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.practice.self.project.spring.aspects.InvalidMappingException;

@Aspect
public class Logger {
	@Pointcut("execution(* com.com.practice.self.project.spring.aspects.Employee.setNumber(..))")
	private void setterNumber(){}
	
	@Pointcut("execution(* com.com.practice.self.project.spring.aspects.Employee.setDesignation(..))")
	private void setterDesignation(){}
	
	@Pointcut("execution(* com.com.practice.self.project.spring.aspects.Employee.getProject(..))")
	private void getProject(){}
	
	@Pointcut("execution(* com.com.practice.self.project.spring.aspects.Employee.*)")
	private void exception(){}
	
	@Before("setterNumber()")
	public void beforeAdvice() {
		System.out.println("Before setting up...");
	}
	
	@After("setterDesignation()")
	public void afterAdvice() {
		System.out.println("After setting up...");
	}
	
	@AfterReturning("getProject()")
	public void afterReturning(Object returnValue) {
		System.out.println("After returning from normal flow...");
	}
	
	public void aroundAdvice() {
		System.out.println("Before and after intializing...");
	}
	
	@AfterThrowing("exception")
	public void afterThrowingException(InvalidMappingException ime) {
		System.out.println("Exception occurred: " + ime.getMessage());
	}
}
