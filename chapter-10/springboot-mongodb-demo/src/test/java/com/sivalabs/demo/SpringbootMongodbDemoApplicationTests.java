package com.sivalabs.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Siva
 *
 */

@RunWith(SpringRunner.class)
@DataMongoTest
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
