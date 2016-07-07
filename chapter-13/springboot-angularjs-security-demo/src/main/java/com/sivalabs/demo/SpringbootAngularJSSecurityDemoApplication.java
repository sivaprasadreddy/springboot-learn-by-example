/**
 * 
 */
package com.sivalabs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Siva
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootAngularJSSecurityDemoApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAngularJSSecurityDemoApplication.class, args);
	}
}

