package com.sivalabs.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootWarDemoApplication.class)
@WebAppConfiguration
public class SpringbootWarDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
