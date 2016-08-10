package com.practice.self.project.spring.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext context;
	private static EmployeeJdbcTemplate ejt;
	public static void main(String[] args) {
		App app = new App();
		context = new ClassPathXmlApplicationContext("springJdbc.xml");
		ejt = (EmployeeJdbcTemplate)context.getBean("employeeJdbcTemplate");
		app.insert();
		System.out.println("Enter query=q, queryall=a update=u, delete=d --> ");
		while(true) {
			char choice = getChar();
			switch (choice) {
			case('q'):
				app.query();
			break;
			case('a'):
				app.queryAll();
			break;
			case('u'):
				app.update();
			break;
			case('d'):
				app.delete();
			break;
			case('r'):
				app.getRecord();
			break;
			default:
				System.out.println("Invalid choice...");
			}
		}
	}
	
	public static char getChar() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		try {
			str = reader.readLine();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return str.charAt(0);
	}
	
	private void insert() {
		Employee employee1 = (Employee)context.getBean("employee1");
		Employee employee2 = (Employee)context.getBean("employee2");
		Employee employee3 = (Employee)context.getBean("employee3");
		Employee employee4 = (Employee)context.getBean("employee4");
		ejt.truncate();
		ejt.insert(employee1);
		ejt.insert(employee2);
		ejt.insert(employee3);
		ejt.insert(employee4);
	}
	private void query() {
		int id = 1;
		Employee employee = ejt.get(id);
		displayEmployee(employee);
	}
	
	private void queryAll() {
		List<Employee> employees = ejt.list();
		for (Employee employee : employees) {
			displayEmployee(employee);
		}
	}
	
	private void displayEmployee(Employee employee) {
		System.out.println("ID: " + employee.getId() + " NAME: " + employee.getName() 
				+ " DEPARTMENT: " + employee.getDepartment());
	}
	
	private void update() {
		Employee employee3 = (Employee)context.getBean("employee3");
		employee3.setName("Jodie Raven");
		employee3.setDepartment("Quality");
		ejt.update(employee3);
	}
	private void delete() {
		int id = 2;
		ejt.delete(id);
	}
	
	private void getRecord() {
		int id = 3;
		Employee e = ejt.getRecord(id);
		displayEmployee(e);
	}
}
