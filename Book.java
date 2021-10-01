package com.demo.book.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {
	
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name="title")
	@NotEmpty
	@Size(min=3, message="book title should have atleast 3 char")
	private String title;
	@Column(name="author")
	private String author;
	@Column(name="description")
	private String description;
	@Column(name="isbn")
	private String isbn;
	private double price;
	LocalDate publishDate;
	LocalDate lastUpdatedOn;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_fk")
	Category category;
	
	// Constructors
		public Book() {}
		public Book(int bookId, @NotEmpty
				@Size(min=3, message="book title should have atleast 3 char") String title, String author, String description, String isbn, double price, LocalDate publishDate, LocalDate lastUpdatedOn, Category category ) {
			super();
			this.bookId = bookId;
			this.title = title;
			this.author = author;
			this.description = description;
			this.isbn = isbn;
			this.price = price;
			this.publishDate = publishDate;
			this.lastUpdatedOn = lastUpdatedOn;
			this.category = category;
			}
		
		// getters & setter
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public LocalDate getPublishDate() {
			return publishDate;
		}
		public void setPublishDate(LocalDate publishDate) {
			this.publishDate = publishDate;
		}
		public LocalDate getLastUpdatedOn() {
			return lastUpdatedOn;
		}
		public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
			this.lastUpdatedOn = lastUpdatedOn;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		
		
		// toString
		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", description=" + description + ", isbn=" + isbn + ", price=" + price + ", publishDate="
					+ publishDate + ", lastUpdatedOn=" + lastUpdatedOn + ", category=" + category +"]";
		}
		
}
	
