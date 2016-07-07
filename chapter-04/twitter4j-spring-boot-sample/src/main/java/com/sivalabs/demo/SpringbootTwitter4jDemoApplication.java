/**
 * 
 */
package com.sivalabs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;

/**
 * @author Siva
 *
 */
@SpringBootApplication
public class SpringbootTwitter4jDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTwitter4jDemoApplication.class, args);
	}

	@Autowired
	private Twitter twitter;
	
	@Override
	public void run(String... arg0) throws Exception {
		ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
		for (Status status : homeTimeline) {
			System.err.println(status.getText());
		}
	}

}
