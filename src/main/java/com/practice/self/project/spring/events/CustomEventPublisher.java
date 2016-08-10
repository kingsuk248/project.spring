package com.practice.self.project.spring.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware{
	private ApplicationEventPublisher applicationEventPublisher;
	
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void publishCustomEvent(){
		CustomEvent ce = new CustomEvent(this);
		applicationEventPublisher.publishEvent(ce);
	}
}
