package com.practice.self.project.spring.aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springAop.xml");
		Employee employee1 = (Employee) context.getBean("employee1");
		System.out.println("Employee number: " + employee1.getNumber());
		System.out.println("Employee designation: " + employee1.getDesignation()) ;
		String project1 = employee1.getProject();
		if (project1 == null) {
			try {
				employee1.throwException();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Employee employee2 = (Employee) context.getBean("employee2");
		System.out.println("Employee number: " + employee2.getNumber());
		System.out.println("Employee designation: " + employee2.getDesignation()) ;
		String project2 = employee2.getProject();
		if (project2 == null) {
			try {
				employee2.throwException();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
