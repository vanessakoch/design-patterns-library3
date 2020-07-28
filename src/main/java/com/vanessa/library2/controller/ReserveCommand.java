package com.vanessa.library2.controller;

import com.vanessa.library2.entities.Book;
import com.vanessa.library2.entities.Student;

public class ReserveCommand implements Command {
	private String document;
	private Student student;
	private Book book;

	public ReserveCommand(String document, Student student, Book book) {
		super();
		this.document = document;
		this.student = student;
		this.book = book;
	}

	public String execute() {
		student.getReservedBooks().add(book);
		return document.concat("\nO(a) aluno(a) " + student.getName() + " reservou o livro " + book.getName());
	}

	public String undo() {
		student.getReservedBooks().remove(book);
		return document;
	}

}
