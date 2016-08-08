package com.practice.self.project.spring.javabased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.register(GettingStartedConfig.class);
		context.register(ChatBotConfig.class);
		context.refresh();
		GettingStarted gs = (GettingStarted)context.getBean("gettingStarted");
		gs.setMessage("Getting Started...");
		System.out.println(gs.getMessage());
		ChatBot cb = (ChatBot) context.getBean("chatBot");
		cb.startEngine();
	}
}
