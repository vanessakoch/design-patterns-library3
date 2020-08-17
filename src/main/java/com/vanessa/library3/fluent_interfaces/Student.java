package com.vanessa.library3.fluent_interfaces;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library3.facade.Book;

public class Student {

	private String name;
	private String birthDate;
	private Grade grade;
	private List<Book> borrowedBooks = new ArrayList<Book>();
	private List<Book> reservedBooks = new ArrayList<Book>();
	
	public Student named(String name) {
		this.name = name;
		return this;
	}

	public Student bornIn(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public Student enrolledIn(Grade grade) {
		this.grade = grade;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public Grade getGrade() {
		return grade;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	
	public List<Book> getReservedBooks() {
		return reservedBooks;
	}
	
	public void printBorrowedBooks() {
		System.out.println("Empréstimos:");
		if (borrowedBooks.size() == 0)
			System.out.println("Nenhum empréstimo ainda.");
		for(Book book : borrowedBooks) {
			System.out.println(book);
		}
	}
	
	public void printReservedBooks() {
		System.out.println("\nReservas:");
		if (reservedBooks.size() == 0)
			System.out.println("Nenhuma reserva ainda.");
		for(Book book : reservedBooks) {
			System.out.println(book);
		}
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", birthDate=" + birthDate + ", grade=" + grade + "]";
	}
}
