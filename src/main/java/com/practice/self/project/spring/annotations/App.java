package com.practice.self.project.spring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.self.project.spring.xml.GettingStarted;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springAnnotations.xml");
		//Employee employee = (Employee)context.getBean("employee");
		//System.out.println("Employee Id: " + employee.getEmployeeId());
		//System.out.println("Employee Name: " + employee.getEmployeeName());
		App app = new App();
		app.createChatBox(context);
		//app.printProfile(context);
		//app.prePostMethods();
	}
	
	private void prePostMethods() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("springAnnotations.xml");
		GettingStarted gs = (GettingStarted) context.getBean("gettingStarted");
		System.out.println(gs.getMessage());
	}

	public void printProfile(ApplicationContext context) {
		Profile profile = (Profile) context.getBean("profile");
		profile.printProfile();
		
	}

	public void createChatBox(ApplicationContext context) {
		ChatBot bot = (ChatBot)context.getBean("chatBot");
		bot.startEngine();
	}
}
