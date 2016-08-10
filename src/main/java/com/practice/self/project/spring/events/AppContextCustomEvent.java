package com.practice.self.project.spring.events;

import org.springframework.context.ApplicationListener;

public class AppContextCustomEvent implements ApplicationListener<CustomEvent>{

	public void onApplicationEvent(CustomEvent arg0) {
		System.out.println("Custom event handled");
	}

}
