/**
 * 
 */
package com.sivalabs.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.demo.entities.Post;
import com.sivalabs.demo.repositories.PostRepository;
import com.sivalabs.demo.rest.model.PostsRequestDTO;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BlogService 
{
	@Autowired PostRepository postRepository;
	
	public Page<Post> findPosts(PostsRequestDTO postsRequest) 
	{
		Sort sort = new Sort(Direction.DESC, "createdOn");
		if(postsRequest.getPageNo() < 0){
			postsRequest.setPageNo(0);
		}
		if(postsRequest.getPageSize() < 1) {
			postsRequest.setPageSize(5);
		}
		Pageable pageable = new PageRequest(postsRequest.getPageNo(), postsRequest.getPageSize(), sort);
		Page<Post> pageData = postRepository.findAll(pageable);
		
		return pageData;
	}
	
	public Post findPostById(int postId) {
		return postRepository.findOne(postId);
	}
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
		
	public void deletePost(Integer postId)
	{
		postRepository.delete(postId);
	}


}
