/**
 * 
 */
package com.sivalabs.demo;

import com.sivalabs.demo.entities.Post;
import com.sivalabs.demo.rest.model.PostsRequestDTO;
import com.sivalabs.demo.services.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Siva
 *
 */
@RunWith(SpringRunner.class)
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
