package com.practice.self.project.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class AppContextStartedEvent implements ApplicationListener<ContextStartedEvent>{
	public void onApplicationEvent(ContextStartedEvent arg0) {
		System.out.println("Context started...");
	}
}
