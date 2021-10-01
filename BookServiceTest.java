package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.book.entity.Book;
import com.demo.book.entity.Category;

@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	IBookService bookService;
	
	@Test
	@Disabled
	void testGetAllBooks() {
		List<Book> books = bookService.getAllBooks(); 
		assertEquals(23, books.size());
		assertEquals("A Smile in the Mind", books.get(1).getTitle());
	}
	
	@Test
	@Disabled
	void testAddBook() {
		Category category = new Category();
		category.setCategoryName("book");
		Book book = new Book(57,"The Sea","Martin", "The Fictional Book","567856785",118,LocalDate.of(2015,5,8), LocalDate.of(2021,1,1), category);
		Book newBook= bookService.addBook(book);
		assertEquals(57, newBook.getBookId());
		assertEquals("The Sea", newBook.getTitle());
		assertEquals("Martin", newBook.getAuthor());
		assertEquals("The Fictional Book", newBook.getDescription());
		assertEquals("567856785", newBook.getIsbn());
		assertEquals(118, newBook.getPrice());
		assertEquals(LocalDate.of(2015,5,8), newBook.getPublishDate());
		assertEquals(LocalDate.of(2021,1,1), newBook.getLastUpdatedOn());
		assertEquals("book", newBook.getCategory().getCategoryName());
	}
	
	@Test
	//@Disabled
	void testDeleteBookByBookId() {
		Book book = bookService.deleteBookByBookId(53);
		assertEquals("Emma", book.getTitle());	
	}
	
	@Test
	@Disabled
	void testUpdateBook() {
		Category category = new Category();
		Book book = new Book(57,"The Moon","Martin", "The Fictional Book","567856897",180,LocalDate.of(2015,5,8), LocalDate.of(2021,1,12), category);
		Book updatedBook = bookService.updateBook(57, book);
		assertEquals("The Moon", updatedBook.getTitle());
	}
}
