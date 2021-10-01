package com.demo.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.book.dao.ICategoryDao;
import com.demo.book.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	ICategoryDao categoryDao;

	@Override
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
		return null;
	}

	@Override
	public Category getCategoryByCategoryId(int categoryId) {
		return categoryDao.findById(categoryId).get();
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
