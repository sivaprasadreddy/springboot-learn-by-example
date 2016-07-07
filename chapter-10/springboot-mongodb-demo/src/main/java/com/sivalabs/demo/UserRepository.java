/**
 * 
 */
package com.sivalabs.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Siva
 *
 */
public interface UserRepository extends MongoRepository<User, Integer>
{

}
