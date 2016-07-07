/**
 * 
 */
package com.sivalabs.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan
public class AppConfig
{
	
	// The following 2 beans registers MYSQL or MONGODB implementation of UserDAO 
	// based on System Property dbType.
	@Bean
	@Conditional(MySQLDatabaseTypeCondition.class)
	public UserDAO jdbcUserDAO(){
		return new JdbcUserDAO();
	}
	
	@Bean
	@Conditional(MongoDBDatabaseTypeCondition.class)
	public UserDAO mongoUserDAO(){
		return new MongoUserDAO();
	}
	
	// The following 2 beans registers MYSQL or MONGODB implementation of UserDAO 
	// based on whether MongoDriver class present or not.
	/*
	@Bean
	@Conditional(MongoDriverNotPresentsCondition.class)
	public UserDAO jdbcUserDAO(){
		return new JdbcUserDAO();
	}
	
	@Bean
	@Conditional(MongoDriverPresentsCondition.class)
	public UserDAO mongoUserDAO(){
		return new MongoUserDAO();
	}
	*/
	
	// The following 2 beans registers MYSQL or MONGODB implementation of UserDAO 
	// based on System Property dbType.
	
	/*
	@Bean
	@DatabaseType("MYSQL")
	public UserDAO jdbcUserDAO(){
		return new JdbcUserDAO();
	}
	
	@Bean
	@DatabaseType("MONGO")
	public UserDAO mongoUserDAO(){
		return new MongoUserDAO();
	}
	*/
}
