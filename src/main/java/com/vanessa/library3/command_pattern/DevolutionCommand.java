package com.vanessa.library3.command_pattern;

import com.vanessa.library3.facade.Book;
import com.vanessa.library3.fluent_interfaces.Student;

public class DevolutionCommand implements Command {
	private String document;
	private Student student;
	private Book book;

	public DevolutionCommand(String document, Student student, Book book) {
		super();
		this.document = document;
		this.student = student;
		this.book = book;
	}

	public String execute() {
		student.getBorrowedBooks().remove(book);
		book.copies(book.getTotal() + 1);
		return document.concat("\nO(a) aluno(a) " + student.getName() + " devolveu o livro " + book.getName());
	}

	public String undo() {
		student.getBorrowedBooks().add(book);
		book.copies(book.getTotal() - 1);
		return document;
	}

}
