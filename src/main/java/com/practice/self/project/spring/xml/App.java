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
    	app.checkParentChildScope();
    	context.registerShutdownHook();
    }
    
    public void evaluateSheets() {
    	SheetEvaluator sheetEvaluator = (SheetEvaluator)context.getBean("sheetEvaluator");
    	Sheet sheet = sheetEvaluator.getSheet();
    	System.out.println("Evaluation: " + sheetEvaluator.evaluate(sheet));
    }
    
    public void checkParentChildScope() {
    	A a1 = (A) context.getBean("a");
    	A a2 = (A) context.getBean("a");
    	B b1 = (B) context.getBean("b");
    	B b2 = (B) context.getBean("b");
    	System.out.println(a1.hashCode());
    	System.out.println(a2.hashCode());
    	System.out.println(b1.hashCode());
    	System.out.println(b2.hashCode());
    }
}
