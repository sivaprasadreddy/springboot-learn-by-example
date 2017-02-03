package com.sivalabs.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * @author Siva
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestingDemoApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationRestTests
{

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testPing()
	{
		String resp = restTemplate.withBasicAuth("admin","admin123")
				.getForObject("http://localhost:"+port+"/ping", String.class);
		assertTrue(resp.contains("Up & Running"));
	}
	
	@Test
	public void testGetUsers()
	{
		ResponseEntity<PagedResources<User>> responseEntity =
				restTemplate.withBasicAuth("admin","admin123")
						.exchange("http://localhost:"+port+"/users",
						        HttpMethod.GET, 
						        null, 
						        new ParameterizedTypeReference<PagedResources<User>>()
						        {}, 
						        Collections.emptyMap()
						        );
		assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
		PagedResources<User> userResource = responseEntity.getBody();
		Collection<User> users = userResource.getContent();
		assertNotNull(users);
		assertEquals(3, users.size());
	}

}
