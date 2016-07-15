
package com.sivalabs.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.demo.orders.entities.Order;
import com.sivalabs.demo.orders.repositories.OrderRepository;
import com.sivalabs.demo.security.entities.User;
import com.sivalabs.demo.security.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
public class UserOrdersService
{
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(transactionManager="securityTransactionManager")
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}
	
	@Transactional(transactionManager="ordersTransactionManager")
	public List<Order> getOrders()
	{
		return orderRepository.findAll();
	}
}
