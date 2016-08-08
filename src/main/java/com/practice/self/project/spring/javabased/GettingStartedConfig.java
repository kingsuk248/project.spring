package com.practice.self.project.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GettingStartedConfig {
	
	@Bean(initMethod="initialize")
	public GettingStarted gettingStarted() {
		return new GettingStarted();
	}
	
	@Bean
	public HereWeGo hereWeGo() {
		return new HereWeGo();
	}
}
