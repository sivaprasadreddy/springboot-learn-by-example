package com.sivalabs.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Siva
 *
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringbootEssentialsApplication.class)
public class SpringbootEssentialsApplicationTest
{
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	@Test
	public void testContextLoads()
	{
		System.out.println(dataSourceConfig);
	}

}
