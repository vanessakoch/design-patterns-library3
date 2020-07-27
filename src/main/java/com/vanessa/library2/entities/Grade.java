package com.vanessa.library2.entities;

public class Grade {
	private String stage;
	
	public Grade educationalStage(String stage) {
		this.stage = stage;
		return this;
	}

	@Override
	public String toString() {
		return "" + stage + "]";
	}
	
}
