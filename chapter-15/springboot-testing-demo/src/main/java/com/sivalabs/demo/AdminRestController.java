package com.sivalabs.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Siva
 *
 */
@RestController
public class AdminRestController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/ping")
	public String ping()
	{
		return "Up & Running...."+new Date();
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Integer userId)
	{
		userService.deleteUser(userId);
	}
}
