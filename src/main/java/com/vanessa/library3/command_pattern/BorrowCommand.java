package com.vanessa.library3.command_pattern;

import com.vanessa.library3.facade.Book;
import com.vanessa.library3.fluent_interfaces.Student;

public class BorrowCommand implements Command {
	private String document;
	private Student student;
	private Book book;

	public BorrowCommand(String document, Student student, Book book) {
		super();
		this.document = document;
		this.student = student;
		this.book = book;
	}

	public String execute() {
		if(book.getTotal() == 0) 
			return document.concat("\nEstamos sem exemplares do livro " + book.getName() + " para o(a) " + student.getName());
		
		student.getBorrowedBooks().add(book);
		book.copies(book.getTotal() - 1);
		return document.concat("\nO livro " + book.getName() + " foi emprestado por " + student.getName());
	}

	public String undo() {
		student.getBorrowedBooks().remove(book);
		book.copies(book.getTotal() + 1);
		return document;
	}
	
}
