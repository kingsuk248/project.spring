package com.practice.self.project.spring.transaction;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext context;
	private static EmployeeJdbcTemplate ejt;
	public static void main(String[] args) {
		App app = new App();
		context = new ClassPathXmlApplicationContext("springTransaction.xml");
		ejt = (EmployeeJdbcTemplate)context.getBean("employeeJdbcTemplate");
		app.insert();
	}
	
	private void insert() {
		EmployeeSalary es1 = (EmployeeSalary) context.getBean("es1");
		EmployeeSalary es2 = (EmployeeSalary) context.getBean("es2");
		EmployeeSalary es3 = (EmployeeSalary) context.getBean("es3");
		ejt.insert(es1);
		ejt.insert(es2);
		ejt.insert(es3);
		query();
	}
	
	private void query() {
		List<EmployeeSalary> employeeSalaries = ejt.list();
		for (EmployeeSalary employeeSalary : employeeSalaries) {
			displayEmployee(employeeSalary);
		}
	}
	
	private void displayEmployee(EmployeeSalary es) {
		System.out.println("Employee Details ->");
		System.out.println("ID: " + es.getId() + " NAME: " + es.getName() 
				+ " DEPARTMENT: " + es.getDepartment());
		System.out.println("Salary Details ->");
		System.out.println("Year: " + es.getYear() + " Salary: " + es.getSalary());
	}
}
