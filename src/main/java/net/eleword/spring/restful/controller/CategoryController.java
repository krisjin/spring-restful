package net.eleword.spring.restful.controller;

import java.util.List;

import net.eleword.spring.restful.domain.Category;
import net.eleword.spring.restful.domain.Post;
import net.eleword.spring.restful.service.CategoryService;
import net.eleword.spring.restful.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/resources/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody Category entity) {
		
		categoryService.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Category entity) {
		
		categoryService.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		
		categoryService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/xml")
	public @ResponseBody List<Category> find() {
		
		return categoryService.find();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Category findCategory(@PathVariable("id") Long id ) {
		
		return categoryService.findById(id);
	}
	
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public @ResponseBody List<Post> findCategoryPosts(@PathVariable("id") Long id ) {
		
		return postService.findPostsByCategoryId(id);
	}
}
