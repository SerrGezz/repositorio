package com.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Category;
import com.ciclo3.reto3.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAll(){
		return categoryRepository.getAll();
	}
	
	public Optional<Category> getCategory(int id){
		return categoryRepository.getCategory(id);
	}
	
	public Category save(Category category) {
		if(category.getId()==null) {
			return categoryRepository.save(category);
		}else {
			Optional<Category> categoryOptional=categoryRepository.getCategory(category.getId());
			if(categoryOptional.isEmpty()) {
				return categoryRepository.save(category);
			}else {
				return category;
			}
		}
	}	
}
