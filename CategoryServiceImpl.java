package com.demo.book.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.book.dao.ICategoryDao;
import com.demo.book.entity.Category;
import com.demo.book.exception.CategoryFoundException;
import com.demo.book.exception.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	ICategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}
	
	@Override
	public Category getCategoryByCategoryId(int categoryId) throws CategoryNotFoundException {
		Optional<Category> category = categoryDao.findById(categoryId);
		if(!category.isPresent()) {
			throw new CategoryNotFoundException("Category not found with given categoryId "+categoryId);
		}
		return category.get();
	}

	@Override
	public Category addCategory(Category category) {
		Optional<Category> cr = categoryDao.findById(category.getCategoryId());
		if(cr.isPresent()) {
			throw new CategoryFoundException("Category already exists with given categoryId "+category.getCategoryId());
		}
		return categoryDao.save(category);
	}

	@Override
	public Category deleteCategoryByCategoryId(int categoryId) {
		Category category = categoryDao.findById(categoryId).get();
		categoryDao.deleteById(categoryId);
		return category;
	}

	@Override
	public Category updateCategory(int categoryId, Category category) {
		Category cat = categoryDao.findById(categoryId).get();
		cat.setCategoryName(category.getCategoryName());
		return categoryDao.save(cat) ;
	}

	

	@Override
	public void deleteCategoryByCategoryName(String categoryName) {
		categoryDao.deleteByCategoryName(categoryName);
		
	}

	@Override
	public Category updateCategoryName(int categoryId, String newCategoryName) {
		Category category = categoryDao.findById(categoryId).get();
		category.setCategoryName(newCategoryName);
		return categoryDao.save(category);
	}

	
	
    /*@Override
	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public void deleteCategory(int categoryId) {

	}

	@Override
	public Category updateCategory(int categoryId, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryByCategoryId(int categoryId) {
		return null;
	}*/
	
}
