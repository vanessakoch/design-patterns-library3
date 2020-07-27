package com.vanessa.library2.dao;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library2.entities.Book;
import com.vanessa.library2.entities.Edition;
import com.vanessa.library2.entities.Editor;

public class BookDAO {
	public static List<Book> books = new ArrayList<Book>();

	public static void insertBooks() {
		
		Edition one = new Edition().numbered(1);
		Edition two = new Edition().numbered(2);
		Edition three = new Edition().numbered(3);
		
		Editor abc = new Editor().named("ABC Editora").specialtyOf("Matemática");
		Editor az = new Editor().named("AZ Editora").specialtyOf("Português");
		
		books.add(new Book().named("Cálculo I").editedBy(abc).editionNumber(one).publicationYear(1900));
		books.add(new Book().named("Cálculo II").editedBy(abc).editionNumber(two).publicationYear(1900));
		books.add(new Book().named("Português I").editedBy(az).editionNumber(one).publicationYear(1999));
		books.add(new Book().named("Português II").editedBy(az).editionNumber(two).publicationYear(2002));
		books.add(new Book().named("Português III").editedBy(az).editionNumber(three).publicationYear(2005));
		
	}

	public static Book getBook(String name) {
		for (Book book : books) {
			if (name.equalsIgnoreCase(book.getName()))
				return book;
		}
		return null;
	}
	
	public static void getBooks() {
		for(Book book : books) {
			System.out.println(book);
		}
	}
}