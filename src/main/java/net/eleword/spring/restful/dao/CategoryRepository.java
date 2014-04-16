package net.eleword.spring.restful.dao;

import java.util.List;

import net.eleword.spring.restful.domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query
	Category findByName(String name);
	
	@Query("SELECT category.id, category.name FROM Category category JOIN category.posts post WHERE post.id=?1")
	List<Category> findCategoriesByPostId(Long id);
}
