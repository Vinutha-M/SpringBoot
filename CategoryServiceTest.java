package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.demo.book.entity.Category;
import com.demo.book.exception.CategoryNotFoundException;

@SpringBootTest
public class CategoryServiceTest {
	@Autowired
	ICategoryService categoryService;

	@Test
	void testGetCategoryByCategoryId() throws CategoryNotFoundException {
		
		Category cr= categoryService.getCategoryByCategoryId(29);
		assertEquals(99, cr.getCategoryId());
		assertEquals("Jokes", cr.getCategoryName());
	}
	
	@Test
	//@Disabled
	void testGetAllCategories() {
		
		List<Category> categories = categoryService.getAllCategories();
		assertEquals(18, categories.size());
		assertEquals("Horror", categories.get(3).getCategoryName());
	}
	
	@Test
	//@Disabled
	void testAddCategory() {
		Category category = new Category();
		category.setCategoryId(70);
		category.setCategoryName("Action");
		Category newCategory = categoryService.addCategory(category);
		
		assertEquals(70, newCategory.getCategoryId());
		assertEquals("Action", newCategory.getCategoryName());
		
	}
	
	@Test
	//@Disabled
	void testUpdateCategory() {
		Category category=new Category();
		category.setCategoryId(70);
		category.setCategoryName("Comedy");
		
		Category updatedCategory = categoryService.updateCategory(68, category);
		assertEquals("Comedy", updatedCategory.getCategoryName());
	}
	
	@Test
	//@Disabled
	void testDeleteCategoryByCategoryId() {
		Category category = categoryService.deleteCategoryByCategoryId(54);
		assertEquals("Emotional", category.getCategoryName());	
	}
	
	
}
	
	
