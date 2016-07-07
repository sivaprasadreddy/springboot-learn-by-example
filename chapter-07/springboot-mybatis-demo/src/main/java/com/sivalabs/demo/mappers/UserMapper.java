/**
 * 
 */
package com.sivalabs.demo.mappers;

import java.util.List;

import com.sivalabs.demo.domain.User;

/**
 * @author Siva
 *
 */
public interface UserMapper
{

	void insertUser(User user);

	User findUserById(Integer id);

	List<User> findAllUsers();
	
}
