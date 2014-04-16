package net.eleword.spring.restful.controller;

import java.util.List;

import net.eleword.spring.restful.domain.Author;
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
@RequestMapping("/resources/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)	
	public void create(@RequestBody Post post) {
		
		postService.create(post);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Post post) {
		
		postService.update(post);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	public void delete(@PathVariable("id") Long id) {
		
		postService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)	
	public @ResponseBody List<Post> find() {
		
		return postService.find();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public @ResponseBody Post findPost(@PathVariable("id") Long id ) {
		
		return postService.findById(id);
	}
	
	@RequestMapping(value = "/{id}/author", method = RequestMethod.GET)
	public @ResponseBody Author getPostAuthor(@PathVariable("id") Long id) {
		
		return postService.findPostAuthor(id);
	}
	
	@RequestMapping(value = "/{id}/category", method = RequestMethod.GET)	
	public @ResponseBody List<Category> findPostCategories(@PathVariable("id") Long id ) {
		
		return categoryService.findCategoriesByPostId(id);
	}
	
}
