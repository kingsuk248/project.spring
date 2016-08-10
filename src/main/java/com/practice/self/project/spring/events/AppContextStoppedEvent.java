package com.practice.self.project.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class AppContextStoppedEvent implements ApplicationListener<ContextStoppedEvent>{
	public void onApplicationEvent(ContextStoppedEvent arg0) {
		System.out.println("Context stopped...");
	}
}
