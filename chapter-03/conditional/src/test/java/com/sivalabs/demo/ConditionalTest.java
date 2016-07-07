/**
 * 
 */
package com.sivalabs.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class ConditionalTest
{
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void test_get_all_usernames()
	{
		List<String> userNames = userDAO.getAllUserNames();
		System.err.println(userNames);
	}
}
