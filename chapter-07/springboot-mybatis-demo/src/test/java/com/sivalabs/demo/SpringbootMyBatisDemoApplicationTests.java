package com.sivalabs.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.demo.domain.User;
import com.sivalabs.demo.mappers.UserMapper;

/**
 * @author Siva
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootMyBatisDemoApplication.class)
public class SpringbootMyBatisDemoApplicationTests
{

	@Autowired private UserMapper userMapper;
	//@Autowired private UserAnnotationMapper userMapper;
	
	@Test
	public void findAllUsers()  {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
		
	}
	
	@Test
	public void findUserById()  {
		User user = userMapper.findUserById(1);
		assertNotNull(user);
	}
	
	@Test
	public void createUser() {
		User user = new User(0, "Siva", "siva@gmail.com");
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("Siva", newUser.getName());
		assertEquals("siva@gmail.com", newUser.getEmail());
	}
}
