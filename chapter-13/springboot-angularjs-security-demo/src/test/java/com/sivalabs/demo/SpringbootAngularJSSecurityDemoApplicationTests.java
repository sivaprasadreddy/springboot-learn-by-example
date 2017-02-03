/**
 * 
 */
package com.sivalabs.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sivalabs.demo.entities.Post;
import com.sivalabs.demo.rest.model.PostsRequestDTO;
import com.sivalabs.demo.services.BlogService;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootAngularJSSecurityDemoApplication.class)
@WebAppConfiguration
public class SpringbootAngularJSSecurityDemoApplicationTests {

	@Autowired
	private BlogService blogService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void test_findPosts() {
		PostsRequestDTO postsRequest = new PostsRequestDTO();
		Page<Post> posts = blogService.findPosts(postsRequest );
		System.out.println(posts);
	}
}
