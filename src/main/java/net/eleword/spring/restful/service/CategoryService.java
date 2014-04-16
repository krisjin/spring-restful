package net.eleword.spring.restful.service;

import java.util.List;

import net.eleword.spring.restful.dao.CategoryRepository;
import net.eleword.spring.restful.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Transactional
	public void create(Category category) {		
		categoryRepository.saveAndFlush(category);
	}
	
	@Transactional
	public void update(Category category) {		
		categoryRepository.saveAndFlush(category);
	}
	
	@Transactional
	public void delete(Long id) {
		categoryRepository.delete(id);
	}
	
	public List<Category> find() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		return categoryRepository.findOne(id);
	}
	
	public List<Category> findCategoriesByPostId(Long id) {
		return categoryRepository.findCategoriesByPostId(id);
	}
}
