package com.demo.book.service;

import java.util.List;


import com.demo.book.entity.Book;
import com.demo.book.exception.BookNotFoundException;

public interface IBookService {
		
		List<Book> getAllBooks();
		Book getBookByBookId(int bookId) throws BookNotFoundException;
		Book addBook(Book book);
		Book updateBook(int bookId, Book book);
		Book deleteBookByBookId(int bookId);
		Book updateBookTitle(int bookId, String newTitle);
		Book getBookByTitle(String title);
		void deleteBookByTitle(String title);
	}
