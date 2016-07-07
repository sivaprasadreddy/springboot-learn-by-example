package com.sivalabs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Siva
 *
 */

@SpringBootApplication
public class SpringbootMongodbDemoApplication implements CommandLineRunner
{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootMongodbDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		userRepository.save(new User(1, "Siva","siva@gmail.com"));
		userRepository.save(new User(2, "prasad","prasad@gmail.com"));
		
	}

}
