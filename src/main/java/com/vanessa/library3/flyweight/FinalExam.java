package com.vanessa.library3.flyweight;

import com.vanessa.library3.fluent_interfaces.Student;

public class FinalExam implements Document {
	private String docTitle;
	private Student student;
	
	public FinalExam(String docTitle, Student student) {
		super();
		this.docTitle = docTitle;
		this.student = student;
	}

	public void getDocument() {
		System.out.println("Trabalho de conclusão de curso - Título: " + docTitle + " | Aluno: " + student.getName());
	}

}
