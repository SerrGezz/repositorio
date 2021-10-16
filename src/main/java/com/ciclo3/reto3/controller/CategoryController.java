package com.ciclo3.reto3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.reto3.model.Category;
import com.ciclo3.reto3.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
		@Autowired
		private CategoryService categoryService;
				
		@GetMapping("/all")
		public List<Category> getCategory(){
			return categoryService.viewAll();
		}
		
		@PostMapping("/save")
		public void postCategory(@RequestBody Category category) {
			categoryService.save(category);
		}
		
		@PutMapping("/update")
		public void putCategory(@RequestBody Category category) {
			categoryService.update(category);
		}
		
		@DeleteMapping("delete/{id}")
		public void deleteCategory(@PathVariable("id") Integer id) {
			categoryService.delete(id);
		} 
}
