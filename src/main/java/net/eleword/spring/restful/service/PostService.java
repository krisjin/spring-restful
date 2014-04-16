package net.eleword.spring.restful.service;

import java.util.List;

import net.eleword.spring.restful.dao.PostRepository;
import net.eleword.spring.restful.domain.Author;
import net.eleword.spring.restful.domain.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void create(Post post) {		
		postRepository.saveAndFlush(post);
	}
	
	@Transactional
	public void update(Post post) {		
		postRepository.saveAndFlush(post);
	}
	
	@Transactional
	public void delete(Long id) {
		postRepository.delete(id);
	}
	
	public List<Post> find() {
		return postRepository.findAll();
	}
	
	public Post findById(Long id ) {
		return postRepository.findOne(id);
	}
	
	public Author findPostAuthor(Long id) {
		return postRepository.findPostAuthor(id);
	}
	
	public List<Post> findPostsByCategoryId(Long id) {
		return postRepository.findPostsByCategoryId(id);
	}
	
}
