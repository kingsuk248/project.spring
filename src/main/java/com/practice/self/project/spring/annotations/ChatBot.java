package com.practice.self.project.spring.annotations;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class ChatBot {
	private ChatEngine chatEngine;
	@Autowired
	private Emoticons emoticons;
	
	public ChatEngine getChatEngine() {
		return chatEngine;
	}
	
	@Resource(name="chatEngine")
	public void setChatEngine(ChatEngine chatEngine) {
		this.chatEngine = chatEngine;
	}
	
	public void startEngine() {
		chatEngine.initialize();
	}
}