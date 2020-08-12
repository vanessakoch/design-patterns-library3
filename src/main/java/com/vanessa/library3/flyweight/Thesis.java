package com.vanessa.library3.flyweight;

import com.vanessa.library3.fluent_interfaces.Student;

public class Thesis implements Document {
	private String docTitle;
	private Student student;
	
	public Thesis(String docTitle) {
		super();
		this.docTitle = docTitle;
	}

	public void getDocument() {
		System.out.println("Tese - Título: " + docTitle );
	}
	
}
