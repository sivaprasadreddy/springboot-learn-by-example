package com.sivalabs.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Siva
 *
 */

@SpringBootApplication
@MapperScan("com.sivalabs.demo.mappers")
public class SpringbootMyBatisDemoApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootMyBatisDemoApplication.class, args);
	}

}
