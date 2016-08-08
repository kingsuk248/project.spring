package com.practice.self.project.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	@Autowired
	@Qualifier("employee2")
	private Employee employee;
	
	public void printProfile() {
		System.out.println("Employee ID: " + employee.getEmployeeId());
		System.out.println("Employee Name: " + employee.getEmployeeName());
	}
}
