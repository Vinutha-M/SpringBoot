package com.demo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book.entity.Category;
import com.demo.book.exception.CategoryNotFoundException;
import com.demo.book.service.ICategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	ICategoryService categoryService;
	
	
	@GetMapping("/categories")
	ResponseEntity<List<Category>> getAllCategories() {
		
		return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
	}
    
	//Get Categories by category id -GET
	@GetMapping("/categories/categoryId/{categoryId}")
	ResponseEntity<Category> getCategoryByCategoryId(@PathVariable("categoryId") int categoryId) throws CategoryNotFoundException {
	 Category category = categoryService.getCategoryByCategoryId(categoryId);
	 return new ResponseEntity<>(category, HttpStatus.OK); // 200 Ok
		
	}
	
	//Add new category POST
	@PostMapping("/categories")
	ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category cr =categoryService.addCategory(category);
		return new ResponseEntity<>(cr,HttpStatus.CREATED); //201 Created
	}
	
	// Delete category by categoryId - DELETE
			@DeleteMapping("/categories/{categoryId}")
			ResponseEntity<Category> deleteCategoryByCategoryId(@PathVariable("categoryId") int categoryId) {
				Category category= categoryService.deleteCategoryByCategoryId(categoryId);
				return new ResponseEntity<>(category, HttpStatus.OK);
			}
			
			//Delete category by name
			@DeleteMapping("/categories/delete/{categoryName}")
			ResponseEntity<Void> deleteCategory(@PathVariable("categoryName") String categoryName) {
			categoryService.deleteCategoryByCategoryName(categoryName);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			// Update category - PUT
			@PutMapping("/categories/{categoryId}")
			ResponseEntity<Category> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category) {
			 Category cat = categoryService.updateCategory(categoryId, category);
			 return new ResponseEntity<>(cat, HttpStatus.OK);
			}
			
			// update category name - PATCH
			@PatchMapping("/categories/{categoryId}")
			ResponseEntity<Category> updateCategoryName(@PathVariable("categoryId") int categoryId, @RequestBody String newCategoryName) {
				Category category = categoryService.updateCategoryName(categoryId, newCategoryName);
				return new ResponseEntity<>(category, HttpStatus.OK);
			}

}
