/**
 * 
 */
package com.sivalabs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
	 	.inMemoryAuthentication()
	 			.withUser("user").password("password").roles("USER").and()
	 			.withUser("admin").password("admin123").roles("USER", "ADMIN");

	}
}
