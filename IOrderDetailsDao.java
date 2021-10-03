package com.demo.book.dao;

import java.time.LocalDate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.book.entity.OrderDetails;

@Repository
public interface IOrderDetailsDao extends JpaRepository<OrderDetails, Integer>{
	
	OrderDetails findByquantity(int quantity);

	Optional<OrderDetails> findByQuantity(int quantity);

	void deleteByQuantity(int quantity);
	
	
	// Native Query method
			//@Query(value="delete from bookOrder where orderdate=:date", nativeQuery=true)
			//void deleteByorderDate(@Param("id") LocalDate orderDate);

}