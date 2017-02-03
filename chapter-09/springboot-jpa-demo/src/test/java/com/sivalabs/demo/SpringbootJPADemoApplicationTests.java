package com.sivalabs.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Siva
 *
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringbootJPADemoApplicationTests
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
		User user = new User(0, "SivaPrasad", "sivaprasad@gmail.com");
		User savedUser = userRepository.save(user);
		User newUser = userRepository.findOne(savedUser.getId());
		assertEquals("SivaPrasad", newUser.getName());
		assertEquals("sivaprasad@gmail.com", newUser.getEmail());
	}
	
	@Test
	public void getUsersSortByName() {
		Sort sort = new Sort(Direction.ASC, "name");
		List<User> users = userRepository.findAll(sort);
		assertNotNull(users);
	}
	
	@Test
	public void getUsersSortByNameAscAndIdDesc() {		
		Order order1 = new Order(Direction.ASC, "name");
		Order order2 = new Order(Direction.DESC, "id");
		Sort sort = new Sort(order1, order2);
		List<User> users = userRepository.findAll(sort);
		assertNotNull(users);
	}
	
	@Test
	public void getUsersByPage() {
		Sort sort = new Sort(Direction.ASC, "name");
		int size = 25;
		int page = 0; //zero-based page index.
		Pageable pageable = new PageRequest(page, size, sort);
		Page<User> usersPage = userRepository.findAll(pageable);
		System.out.println(usersPage.getTotalElements()); //Returns the total amount of elements.
		System.out.println(usersPage.getTotalPages());//Returns the number of total pages.
		System.out.println(usersPage.hasNext());
		System.out.println(usersPage.hasPrevious());
		List<User> usersList = usersPage.getContent();
		assertNotNull(usersList);
	}
}
