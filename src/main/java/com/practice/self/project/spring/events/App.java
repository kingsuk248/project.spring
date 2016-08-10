package com.practice.self.project.spring.events;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springEvents.xml");
		HelloEventfulWorld hew = (HelloEventfulWorld) context.getBean("helloEventfulWorld");
		context.start();
		System.out.println("Message from HEW " + hew.getMessage());
		CustomEventPublisher cep = (CustomEventPublisher) context.getBean("customEventPublisher");
		cep.publishCustomEvent();
		context.stop();
	}
}
