/**
 * 
 */
package com.sivalabs.demo.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.demo.security.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{
	
}

