package com.sivalabs.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.demo.entities.Post;

/**
 * @author Siva
 * 
 */
public interface PostRepository extends JpaRepository<Post, Integer>
{

}
