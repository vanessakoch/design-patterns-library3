package com.vanessa.library3.entities;

import java.util.Scanner;

import com.vanessa.library3.dao.BookDAO;

public class Book implements Management {
	static Scanner t = new Scanner(System.in);

	private String name;
	private int year;
	private Edition edition;
	private Editor editor;
	private int total;
	
	public Book named(String name) {
		this.name = name;
		return this;
	}
	
	public Book published(int year) {
		this.year = year;
		return this;
	}
	
	public Book editionNumber(Edition edition) {
		this.edition = edition;
		return this;
	}
	
	public Book edited(Editor editor) {
		this.editor = editor;
		return this;
	}
	
	public Book copies(int total) {
		this.total = total;
		return this;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public Edition getEdition() {
		return edition;
	}

	public Editor getEditor() {
		return editor;
	}
	
	public int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", year=" + year + ", edition=" + edition + ", editor=" + editor + ", copies=" + total + "]";
	}

	public void shop() {
		BookDAO.printEditors();
		System.out.println("Digite o nome de uma editora existente: ");
		String editor = t.next();
		
		System.out.println("Digite o número da edição do livro: ");
		int edition = t.nextInt();
		
		System.out.println("Digite o nome do livro: ");
		String book_name = t.next();
		
		System.out.println("Digite o ano de publicação do livro: ");
		int book_year = t.nextInt();
		
		System.out.println("Digite a quantidade de cópias: ");
		int book_copies = t.nextInt();
		
		BookDAO.newBook(book_name, book_year, book_copies, editor, edition);

	}

	public void maintenance() { 
		System.out.println("Digite o nome do livro para manutenção: ");
		String maintenance_book = t.next();
		if (BookDAO.getBook(maintenance_book) != null) {
			BookDAO.books.remove(BookDAO.getBook(maintenance_book));
			System.out.println("Livro foi para manutenção, foi removido da lista de empréstimos!");
		} else {
			System.out.println("Livro não existe nesta biblioteca");
		}
	}
	
}
