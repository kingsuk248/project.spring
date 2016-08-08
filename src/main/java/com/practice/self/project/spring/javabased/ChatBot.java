package com.practice.self.project.spring.javabased;

import org.springframework.beans.factory.annotation.Autowired;

public class ChatBot {
	private ChatEngine chatEngine;
	public ChatBot(ChatEngine chatEngine) {
		this.chatEngine = chatEngine;
	}
	
	@Autowired
	private Emoticons emoticons;
	
	public void startEngine() {
		chatEngine.initialize();
	}
}