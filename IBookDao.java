package com.demo.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.book.entity.Book;


@Repository
public interface IBookDao extends JpaRepository<Book, Integer> {
	
	// Custom methods
			Book findByTitle(String title);
			
			
			// Native Query method
			@Query(value="delete from book where title=:title", nativeQuery=true)
			void deleteByTitle(@Param("title") String title);

}
