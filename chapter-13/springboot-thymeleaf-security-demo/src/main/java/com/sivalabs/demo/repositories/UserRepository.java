/**
 * 
 */
package com.sivalabs.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.demo.entities.User;


/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
