package com.demo.book.dao;

import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.book.entity.BookOrder;

@Repository
public interface IBookOrderDao extends JpaRepository<BookOrder, Integer>{
	
	BookOrder findByOrderId(String orderId);
	
	
	// Native Query method
			//@Query(value="delete from bookOrder where orderdate=:date", nativeQuery=true)
			//void deleteByorderDate(@Param("id") LocalDate orderDate);

}
