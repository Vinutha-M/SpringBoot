package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.book.dao.IBookDao;
import com.demo.book.entity.Book;
import com.demo.book.entity.Category;
import com.demo.book.exception.BookNotFoundException;

@ExtendWith(SpringExtension.class)
public class BookServiceMockitoTest {
	// @InjectMock - Creates instance of a class and injects mocks that are created
			// with @Mock

			@InjectMocks
			BookServiceImpl bookService;
			
			// @MockBean - Creates Mock of a class or interface

			@MockBean
			IBookDao bookDao;

			// Initialization of mock objects
			@BeforeEach
			void init() {
				MockitoAnnotations.openMocks(this);
			}
			
			@Test
			void testGetBookByBookId() throws BookNotFoundException {
				Category category = new Category();
				
				Book book = new Book(57,"The Sea","Martin", "The Fictional Book","567856785",118,LocalDate.of(2015,5,8), LocalDate.of(2021,1,1), category);
				Mockito.when(bookDao.findById(57)).thenReturn(Optional.of(book));
				Book bk= bookService.getBookByBookId(57);
				assertEquals(57, bk.getBookId());
				assertEquals("The Sea", bk.getTitle());
				assertEquals("Martin", bk.getAuthor());
				assertEquals("The Fictional Book", bk.getDescription());
				assertEquals("567856785", bk.getIsbn());
				assertEquals(118, bk.getPrice());
				assertEquals(LocalDate.of(2015,5,8), bk.getPublishDate());
				assertEquals(LocalDate.of(2021,1,1), bk.getLastUpdatedOn());
				assertEquals("book", bk.getCategory().getCategoryName());
			}
			
			@Test
			void testGetAllBooks() {
				Category category1 = new Category();
				Category category2 = new Category();
				Book bk1 = new Book(57,"The Sea","Martin", "The Fictional Book","567856785",118,LocalDate.of(2015,5,8), LocalDate.of(2021,1,1), category1);
				Book bk2 = new Book(77,"Money","Matt John", "The Heroitic Book"," 187657897",500,LocalDate.of(2021,6,6), LocalDate.of(2003,6,6), category2);
				List<Book> bookList = new ArrayList<>();
				bookList.add(bk1);
				bookList.add(bk2);
				Mockito.when(bookDao.findAll()).thenReturn(bookList);
				List<Book> books = bookService.getAllBooks();
				assertEquals(2, books.size());
				assertEquals(57, bk1.getBookId());
				assertEquals("The Sea", bk1.getTitle());
				assertEquals("Martin", bk1.getAuthor());
				assertEquals("The Fictional Book", bk1.getDescription());
				assertEquals("567856785", bk1.getIsbn());
				assertEquals(118, bk1.getPrice());
				assertEquals(LocalDate.of(2015,5,8), bk1.getPublishDate());
				assertEquals(LocalDate.of(2021,1,1), bk1.getLastUpdatedOn());
				assertEquals("book", bk1.getCategory().getCategoryName());
				assertEquals(77, bk2.getBookId());
				assertEquals("Money", bk2.getTitle());
				assertEquals("Matt John", bk2.getAuthor());
				assertEquals("The Heroitic Book", bk2.getDescription());
				assertEquals("187657897", bk2.getIsbn());
				assertEquals(500, bk2.getPrice());
				assertEquals(LocalDate.of(2021,6,6), bk2.getPublishDate());
				assertEquals(LocalDate.of(2003,6,6), bk2.getLastUpdatedOn());
				assertEquals("book", bk2.getCategory().getCategoryName());


			}
			
			@Test
			void testAddStudent() {
				Category category = new Category();
				Book book = new Book(87,"The Star","Mary Jim", "The Children Book","768546789",180,LocalDate.of(2018,8,8), LocalDate.of(2021,8,8), category);
				Mockito.when(bookDao.save(book)).thenReturn(book);
				Book newBook = bookService.addBook(book);
				assertEquals(87, newBook.getBookId());
				assertEquals("The Star", newBook.getTitle());
				assertEquals("Mary Jim", newBook.getAuthor());
				assertEquals("The Children Book", newBook.getDescription());
				assertEquals("768546789", newBook.getIsbn());
				assertEquals(180, newBook.getPrice());
				assertEquals(LocalDate.of(2018,8,8), newBook.getPublishDate());
				assertEquals(LocalDate.of(2003,8,8), newBook.getLastUpdatedOn());
				assertEquals("book", newBook.getCategory().getCategoryName());
			}
			
			/*
			 * Verify update book by Description method
			 */
			@Test
			void testUpdateBook() {
				Category category = new Category();
				Book book = new Book(77,"Money","Matt John", "The Filmy Book"," 187657897",500,LocalDate.of(2021,6,6), LocalDate.of(2003,6,6), category);
				Mockito.when(bookDao.findById(77)).thenReturn(Optional.of(book));
				Mockito.when(bookDao.save(book)).thenReturn(book);
				Book updatedBook = bookService.updateBook(77, book);
				assertEquals("The Filmy Book", updatedBook.getDescription());
			}
			
			/*
			 * Verify delete book by description.
			 */
			@Test
			void testDeleteBook() {
				Category category = new Category();
				Book book = new Book(77,"Money","Matt John", "The Filmy Book"," 187657897",500,LocalDate.of(2021,6,6), LocalDate.of(2003,6,6), category);
				Mockito.when(bookDao.findById(77)).thenReturn(Optional.of(book));
				bookDao.deleteById(77);
				Book bk = bookService.deleteBookByBookId(77);
				assertEquals("The Filmy Book", bk.getDescription());
			}


}
