package com.vanessa.library3.fluent_interfaces;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library3.facade.Book;

public class BookDAO {
	public static List<Book> books = new ArrayList<Book>();
	public static List<Editor> editors = new ArrayList<Editor>();

	public static void insertBooks() {
		Edition one = new Edition().numbered(1);
		Edition two = new Edition().numbered(2);
		Edition three = new Edition().numbered(3);

		Editor abc = new Editor().named("ABC Editora").specialty("Matemática");
		Editor az = new Editor().named("AZ Editora").specialty("Português");

		editors.add(abc);
		editors.add(az);

		books.add(new Book().named("CálculoI").edited(abc).editionNumber(one).published(1900).copies(2));
		books.add(new Book().named("CálculoII").edited(abc).editionNumber(two).published(1900).copies(4));
		books.add(new Book().named("PortuguesI").edited(az).editionNumber(one).published(1999).copies(1));
		books.add(new Book().named("PortuguesII").edited(az).editionNumber(two).published(2002).copies(5));
		books.add(new Book().named("PortuguesIII").edited(az).editionNumber(three).published(2005).copies(3));
	}

	public static void newBook(String book_name, int book_year, int copies, String editor, int edition) {
		Edition edition_number = new Edition().numbered(edition);

		books.add(new Book().named(book_name).edited(getEditor(editor)).editionNumber(edition_number)
				.published(book_year).copies(copies));
		System.out.println("Compra realizada com sucesso!");
	}

	public static Book getBook(String name) {
		for (Book book : books) {
			if (name.equalsIgnoreCase(book.getName()))
				return book;
		}
		return null;
	}

	public static void getBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public static Editor getEditor(String name) {
		for (Editor editor : editors) {
			if (name.equalsIgnoreCase(editor.getName()))
				return editor;
		}
		return null;
	}

	public static void printEditors() {
		for (Editor editor : editors) {
			System.out.println(editor);
		}
	}

}