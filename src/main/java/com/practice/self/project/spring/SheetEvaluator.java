package com.practice.self.project.spring;

public class SheetEvaluator {
	private Sheet sheet;

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}
	
	public boolean evaluate(Sheet sheet) {
		return sheet.hasSpellingErrors(sheet);
	}
}
