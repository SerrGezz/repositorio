package com.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.model.Category;
import com.ciclo3.reto3.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	public void update(Category category) {
		categoryRepository.save(category);
	}
	
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	public List<Category> viewAll(){
			return categoryRepository.findAll();
	}
}
