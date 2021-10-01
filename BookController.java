package com.demo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book.entity.Book;
import com.demo.book.exception.BookNotFoundException;
import com.demo.book.service.IBookService;


@RestController
public class BookController {	
	@Autowired
	IBookService bookService;
	
	//get all books
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK); // 200 Ok
	}

	// Get book by bookId - GET
	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<Book> getBookByBookId(@PathVariable("bookId") int bookId) throws BookNotFoundException {
	 Book book = bookService.getBookByBookId(bookId);
	 return new ResponseEntity<>(book, HttpStatus.OK); // 200 Ok
		
	}
	
	// Get book by title - GET
	@GetMapping("/books/title/{bkTitle}")
	ResponseEntity<Book> getBookByTitle(@PathVariable("bkTitle") String title) {
		Book book = bookService.getBookByTitle(title);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	// Add new book - POST
	@PostMapping("/books")
	ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book bk = bookService.addBook(book);
		return new ResponseEntity<>(bk, HttpStatus.CREATED); // 201 created
	}
	
	// Delete book by BookId - DELETE
	@DeleteMapping("/books/{bookId}")
	ResponseEntity<Book> deleteBookByBookId(@PathVariable("bookId") int bookId) {
		Book book= bookService.deleteBookByBookId(bookId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	//Delete book by title
	@DeleteMapping("/books/delete/{title}")
	ResponseEntity<Void> deleteBook(@PathVariable("title") String title) {
		bookService.deleteBookByTitle(title);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Update book - PUT
	@PutMapping("/books/{bookId}")
	ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
	 Book bk = bookService.updateBook(bookId, book);
	 return new ResponseEntity<>(bk, HttpStatus.OK);
	}

	// update book title - PATCH
	@PatchMapping("/books/{bookId}")
	ResponseEntity<Book> updateBookTitle(@PathVariable("bookId") int bookId, @RequestBody String newTitle) {
		Book book = bookService.updateBookTitle(bookId, newTitle);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	

}
