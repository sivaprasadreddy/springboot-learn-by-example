package com.sivalabs.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.demo.orders.entities.Order;
import com.sivalabs.demo.orders.repositories.OrderRepository;
import com.sivalabs.demo.security.entities.User;
import com.sivalabs.demo.security.repositories.UserRepository;

/**
 * @author Siva
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootMultipleDSDemoApplication.class)
public class SpringbootMultipleDSDemoApplicationTests
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void findAllUsers()  {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
		
	}
	
	@Test
	public void findAllOrders()  {
		List<Order> orders = orderRepository.findAll();
		assertNotNull(orders);
		assertTrue(!orders.isEmpty());
		
	}

}
