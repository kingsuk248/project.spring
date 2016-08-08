package com.practice.self.project.spring.xml;

public class HereWeGo {
	private String message;
	private int counter;
	
	public HereWeGo(String message, int counter) {
		this.message = message;
		this.counter = counter;
	}
	
	public void go() throws InterruptedException {
		for (int i = 0; i < counter; i++) {
			System.out.print((i + 1) + " ");
			Thread.sleep(1000);
		}
		System.out.println(message);
		Thread.sleep(1000);
	}
}
