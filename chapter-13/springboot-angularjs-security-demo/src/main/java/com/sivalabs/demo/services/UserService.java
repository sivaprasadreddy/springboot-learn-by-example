/**
 * 
 */
package com.sivalabs.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.demo.entities.User;
import com.sivalabs.demo.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService {
	
	@Autowired UserRepository userRepository;
	
	public User login(String email, String password)
	{
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
}
