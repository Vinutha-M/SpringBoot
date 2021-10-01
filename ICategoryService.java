package com.demo.book.service;

import java.util.List;

import com.demo.book.entity.Category;
import com.demo.book.exception.CategoryNotFoundException;

public interface ICategoryService {
	List<Category> getAllCategories();
	Category addCategory(Category category);
	Category deleteCategoryByCategoryId(int categoryId);
	Category updateCategory(int categoryId, Category category);
	Category getCategoryByCategoryId(int categoryId) throws CategoryNotFoundException;
	void deleteCategoryByCategoryName(String categoryName);
	Category updateCategoryName(int categoryId, String newCategoryName);

}
