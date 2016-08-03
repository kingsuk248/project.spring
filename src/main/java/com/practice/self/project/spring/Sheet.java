package com.practice.self.project.spring;

public class Sheet {
	private Dictionary dictionary;

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public boolean hasSpellingErrors(Sheet sheet) {
		return dictionary.isWordExists(sheet);
	}

}
