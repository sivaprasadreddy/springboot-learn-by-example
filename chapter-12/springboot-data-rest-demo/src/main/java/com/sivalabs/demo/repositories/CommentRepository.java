package com.sivalabs.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.demo.entities.Comment;

/**
 * @author Siva
 * 
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>
{

}
