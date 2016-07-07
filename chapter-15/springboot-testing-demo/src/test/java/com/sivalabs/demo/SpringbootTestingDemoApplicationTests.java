package com.sivalabs.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootTestingDemoApplication.class)
public class SpringbootTestingDemoApplicationTests
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicationContext context;

	private Authentication authentication;
	
	@Before
	public void init() {
		AuthenticationManager authenticationManager = this.context
				.getBean(AuthenticationManager.class);
		this.authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken("admin", "admin123")
				//new UsernamePasswordAuthenticationToken("user", "password")
				);
	}

	@After
	public void close() {
		SecurityContextHolder.clearContext();
	}
	
	@Test
	public void testGetUsers() {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertEquals(3, users.size());
	}
	
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void deleteUserUnauthenticated() {
		userService.deleteUser(3);
	}
	
	@Test
	public void deleteUserAuthenticated() {
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		userService.deleteUser(3);
	}
	
	@Test
	@WithMockUser//(username="admin")
	public void createUserWithMockUser() {
		User user = new User();
		user.setName("Yosin");
		user.setEmail("yosin@gmail.com");
		user.setPassword("yosin123");
		
		userService.createUser(user);
	}
	
	@Test
	@WithMockUser
	public void updateUserWithMockUser() {
		User user = userRepository.findOne(1);
		user.setName("Yo");
		userService.updateUser(user);
	}
	
	@Test
	@WithMockUser(username="admin",roles={"USER","ADMIN"})
	//@WithUserDetails(value="admin")
	public void deleteUserAuthenticatedWithMockUser() {
		userService.deleteUser(2);
	}

}
