package com.practice.self.project.spring.aspects;

public class Employee {
	private int number;
	private String designation;
	private String project;
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void throwException() {
		throw new InvalidMappingException("Invalid project mapping...");
	}
	
}
