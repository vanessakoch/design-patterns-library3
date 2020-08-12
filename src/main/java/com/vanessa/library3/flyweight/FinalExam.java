package com.vanessa.library3.flyweight;

import com.vanessa.library3.fluent_interfaces.Student;

public class FinalExam implements Document {
	private String docTitle;
	private Student student;
	private String mentorName;
	
	public FinalExam(String docTitle) {
		super();
		this.docTitle = docTitle;
	}

	public void getDocument() {
		System.out.println("Trabalho de conclusão de curso - Título: " + docTitle );
	}

}
