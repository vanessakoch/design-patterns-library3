package com.vanessa.library3.dao;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library3.entities.Book;
import com.vanessa.library3.entities.Edition;
import com.vanessa.library3.entities.Editor;

public class BookDAO {
	public static List<Book> books = new ArrayList<Book>();

	public static void insertBooks() {
		
		Edition one = new Edition().numbered(1);
		Edition two = new Edition().numbered(2);
		Edition three = new Edition().numbered(3);
		
		Editor abc = new Editor().named("ABC Editora").specialty("Matemática");
		Editor az = new Editor().named("AZ Editora").specialty("Português");
		
		books.add(new Book().named("CálculoI").edited(abc).editionNumber(one).published(1900).copies(2));
		books.add(new Book().named("CálculoII").edited(abc).editionNumber(two).published(1900).copies(4));
		books.add(new Book().named("Português I").edited(az).editionNumber(one).published(1999).copies(1));
		books.add(new Book().named("Português II").edited(az).editionNumber(two).published(2002).copies(5));
		books.add(new Book().named("Português III").edited(az).editionNumber(three).published(2005).copies(3));
		
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