package com.demo.book.service;

import java.util.List;

import com.demo.book.entity.Category;

public interface ICategoryService {
	List<Category> getAllCategories();
	Category addCategory(Category category);
	void deleteCategory(int categoryId);
	Category updateCategory(int categoryId, Category category);
	Category getCategoryByCategoryId(int categoryId);

}
