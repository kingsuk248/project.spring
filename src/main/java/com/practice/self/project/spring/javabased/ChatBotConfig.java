package com.practice.self.project.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GettingStartedConfig.class)
public class ChatBotConfig {
	@Bean
	public ChatBot chatBot() {
		return new ChatBot(chatEngine());
	}
	
	@Bean
	public ChatEngine chatEngine() {
		return new ChatEngine();
	}
	
	@Bean
	public Emoticons emoticons() {
		return new Emoticons();
	}
}
