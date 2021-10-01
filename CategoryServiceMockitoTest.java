package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.book.dao.ICategoryDao;
import com.demo.book.entity.Category;
import com.demo.book.entity.Book;
import com.demo.book.exception.CategoryNotFoundException;

@ExtendWith(SpringExtension.class)
public class CategoryServiceMockitoTest {
	
		// @InjectMock - Creates instance of a class and injects mocks that are created
				// with @Mock

				@InjectMocks
				CategoryServiceImpl categoryService;
				
				// @MockBean - Creates Mock of a class or interface

				@MockBean
				ICategoryDao categoryDao;

				// Initialization of mock objects
				@BeforeEach
				void init() {
					MockitoAnnotations.openMocks(this);
				}
				
				@Test
				void testGetCategoryByCategoryId() throws CategoryNotFoundException {
					
					Category category = new Category();
					category.setCategoryId(17);
					category.setCategoryName("comedy");
					Mockito.when(categoryDao.findById(17)).thenReturn(Optional.of(category));
					Category cat = categoryService.getCategoryByCategoryId(17);
					assertEquals(17, cat.getCategoryId());
					assertEquals("comedy", cat.getCategoryName());
				}
				
				@Test
				void testGetAllBooks() {
					Category category1 = new Category();
					category1.setCategoryId(42);
					category1.setCategoryName("Comics");
					Category category2 = new Category();
					category2.setCategoryId(44);
					category2.setCategoryName("Horror Fiction");
					List<Category> categoryList = new ArrayList<>();
					categoryList.add(category1);
			        categoryList.add(category2);
					Mockito.when(categoryDao.findAll()).thenReturn(categoryList);
					List<Category> categories = categoryService.getAllCategories();
					assertEquals(22, categories.size());
					assertEquals(42, category1.getCategoryId());
					assertEquals("Comics", category1.getCategoryName());
					assertEquals(44, category1.getCategoryId());
					assertEquals("Horror Fiction", category1.getCategoryName());

				}
				
				@Test
				void testAddCategory() {
					Category category = new Category();
					category.setCategoryId(99);
					category.setCategoryName("Biography");
					Mockito.when(categoryDao.save(category)).thenReturn(category);
					Category newCategory = categoryService.addCategory(category);
					assertEquals(99, newCategory.getCategoryId());
				}
				
				/*
				 * Verify update book by Description method
				 */
				@Test
				void testUpdateCategory() {
					Category category = new Category();
					category.setCategoryId(99);
					category.setCategoryName("Biography");
					Mockito.when(categoryDao.findById(99)).thenReturn(Optional.of(category));
					Mockito.when(categoryDao.save(category)).thenReturn(category);
					Category updatedCategory = categoryService.updateCategory(99, category);
					assertEquals("Biography", updatedCategory.getCategoryName());
				}
				
				/*
				 * Verify delete book by description.
				 */
				@Test
				void testDeleteCategory() {
					Category category = new Category();
					category.setCategoryId(46);
					category.setCategoryName("Fiction");
					Mockito.when(categoryDao.findById(46)).thenReturn(Optional.of(category));
					categoryDao.deleteById(46);
					Category cat = categoryService.deleteCategoryByCategoryId(46);
					assertEquals("Fiction", cat.getCategoryName());
				}


}
