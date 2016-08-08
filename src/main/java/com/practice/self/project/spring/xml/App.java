package com.practice.self.project.spring.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	private static AbstractApplicationContext context;
    public static void main( String[] args ) throws InterruptedException {
    	context = new ClassPathXmlApplicationContext("springXml.xml");
    	GettingStarted gs = (GettingStarted) context.getBean("gettingStarted");
    	System.out.println(gs.getMessage());
    	HereWeGo hwg = (HereWeGo) context.getBean("hereWeGo");
    	//System.out.println(hwg.getMessage());
    	hwg.go();
    	App app = new App();
    	app.evaluateSheets();
    	context.registerShutdownHook();
    }
    
    public void evaluateSheets() {
    	SheetEvaluator sheetEvaluator = (SheetEvaluator)context.getBean("sheetEvaluator");
    	Sheet sheet = sheetEvaluator.getSheet();
    	System.out.println("Evaluation: " + sheetEvaluator.evaluate(sheet));
    }
}