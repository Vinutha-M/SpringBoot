package com.demo.book.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue
	private int categoryId;	
	private String categoryName;
	
	@JsonIgnore
	@OneToOne(mappedBy="category",cascade= CascadeType.ALL)
	Book book;

}
