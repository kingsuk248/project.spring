package com.practice.self.project.spring.xml;

public class SheetEvaluator {
	private EvaluatorEngine engine;
	private Sheet sheet;
	
	public SheetEvaluator(EvaluatorEngine engine) {
		this.engine = engine;
	}
	
	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}
	
	public boolean evaluate(Sheet sheet) {
		return sheet.hasSpellingErrors(sheet);
	}
	
	public void initialize() {
		engine.initialize();
	}
}
