package com.demo.book.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.book.dao.IBookDao;
import com.demo.book.entity.Book;
import com.demo.book.exception.BookFoundException;
import com.demo.book.exception.BookNotFoundException;


@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	IBookDao bookDao;

	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}
	
	@Override
	public Book getBookByBookId(int bookId) throws BookNotFoundException {
		Optional<Book> book = bookDao.findById(bookId);
		if(!book.isPresent()) {
			throw new BookNotFoundException("Book not found with given BookId "+bookId);
		}
		return book.get();
	}

	@Override
	public Book addBook(Book book) {
		Optional<Book> bk = bookDao.findById(book.getBookId());
		if(bk.isPresent()) {
			throw new BookFoundException("Book already exists with given bookId "+book.getBookId());
		}
		return bookDao.save(book);
	}

	@Override
	public Book updateBook(int bookId, Book book) {
		Book bk = bookDao.findById(bookId).get();
		bk.setTitle(book.getTitle());
		bk.setAuthor(book.getAuthor());
		bk.setDescription(book.getDescription());
		bk.setIsbn(book.getIsbn());
		bk.setPrice(book.getPrice());
		bk.setPublishDate(book.getPublishDate());
		bk.setLastUpdatedOn(book.getLastUpdatedOn());
		return bookDao.save(bk) ;
	}

	@Override
	public Book deleteBookByBookId(int bookId) {
		Book bk = bookDao.findById(bookId).get();
		bookDao.deleteById(bookId);
		return bk;
	}

	@Override
	public Book updateBookTitle(int bookId, String newTitle) {
		Book bk = bookDao.findById(bookId).get();
		bk.setTitle(newTitle);
		return bookDao.save(bk);
	}

	@Override
	public Book getBookByTitle(String title) {
		Book book = bookDao.findByTitle(title);
		return book;
	}

	@Override
	public void deleteBookByTitle(String title) {
		bookDao.deleteByTitle(title);	
	}

}
