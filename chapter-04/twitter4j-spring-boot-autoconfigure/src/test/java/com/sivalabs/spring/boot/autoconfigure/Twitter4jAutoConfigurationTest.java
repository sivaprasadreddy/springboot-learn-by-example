/**
 * 
 */
package com.sivalabs.spring.boot.autoconfigure;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * @author Siva
 *
 */
public class Twitter4jAutoConfigurationTest {
	private AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		this.context = new AnnotationConfigApplicationContext();
	}

	@After
	public void closeContext() {
		if (this.context != null) {
			this.context.close();
		}
	}
	
	@Test
	public void testWithTwitter4jProperties(){
				
		EnvironmentTestUtils.addEnvironment(this.context,
				"twitter4j.oauth.consumer-key:consumer-key-value-here",
				"twitter4j.oauth.consumer-secret:consumer-secret-value-here",
				"twitter4j.oauth.access-token:access-token-value-here",
				"twitter4j.oauth.access-token-secret:access-token-secret-value-here"
				);
		this.context.register(
							  PropertyPlaceholderAutoConfiguration.class,
							  Twitter4jAutoConfiguration.class
							  );
		this.context.refresh();
		assertEquals(1, this.context.getBeanNamesForType(TwitterFactory.class).length);
		assertEquals(1, this.context.getBeanNamesForType(Twitter.class).length);
	}
	
	
}
