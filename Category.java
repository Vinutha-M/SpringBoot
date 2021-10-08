package com.demo.book.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@OneToMany(targetEntity=Book.class, cascade=CascadeType.ALL)
	@JoinColumn(name="Category_fk", referencedColumnName = "categoryId")
	private List<Book> book = new ArrayList<>();

}
