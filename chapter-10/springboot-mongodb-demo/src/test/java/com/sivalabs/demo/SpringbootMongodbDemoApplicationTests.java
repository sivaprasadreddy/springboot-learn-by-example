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

/**
 * @author Siva
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootMongodbDemoApplication.class)
public class SpringbootMongodbDemoApplicationTests
{

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findAllUsers()  {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
		
	}
	
	@Test
	public void findUserById()  {
		User user = userRepository.findOne(1);
		assertNotNull(user);
	}
	
	@Test
	public void createUser() {
		User user = new User(3, "SivaPrasad", "SivaPrasad@gmail.com");
		User savedUser = userRepository.save(user);
		User newUser = userRepository.findOne(savedUser.getId());
		assertEquals("SivaPrasad", newUser.getName());
		assertEquals("SivaPrasad@gmail.com", newUser.getEmail());
	}
}
