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
public class SpringbootEssentialsApplication implements CommandLineRunner
{
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootEssentialsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.err.println(dataSourceConfig);
	}
}
