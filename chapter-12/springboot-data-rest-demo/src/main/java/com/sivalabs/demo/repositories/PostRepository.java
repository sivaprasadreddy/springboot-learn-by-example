package com.sivalabs.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.demo.entities.Post;

/**
 * @author Siva
 * 
 */
public interface PostRepository extends JpaRepository<Post, Integer>
{
	List<Post> findByTitleLike(String query);
}
