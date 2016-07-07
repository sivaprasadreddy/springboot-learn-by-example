/**
 * 
 */
package com.sivalabs.demo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Siva
 *
 */
public class MongoUserDAO implements UserDAO
{

	@Override
	public List<String> getAllUserNames()
	{
		System.out.println("**** Getting usernames from MongoDB *****");
		return Arrays.asList("Bond","James","Bond");
	}

}
