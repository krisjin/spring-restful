package net.eleword.spring.restful.dao;

import net.eleword.spring.restful.domain.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	@Query
	Author findByUsername(String username);
	
	@Query
	Author findByUsernameAndPassword(String username, String password);
}
