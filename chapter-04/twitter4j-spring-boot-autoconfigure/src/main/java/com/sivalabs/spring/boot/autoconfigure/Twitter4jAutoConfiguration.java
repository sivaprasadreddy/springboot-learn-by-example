/**
 * 
 */
package com.sivalabs.spring.boot.autoconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Siva
 *
 */
@Configuration
@ConditionalOnClass({ TwitterFactory.class, Twitter.class })
@EnableConfigurationProperties(Twitter4jProperties.class)
public class Twitter4jAutoConfiguration {

	private static Log log = LogFactory.getLog(Twitter4jAutoConfiguration.class);
	
	@Autowired
	private Twitter4jProperties properties;
	
	@Bean
	@ConditionalOnMissingBean
	public TwitterFactory twitterFactory(){
		
		if (this.properties.getOauth().getConsumerKey() == null
			|| this.properties.getOauth().getConsumerSecret() == null
			|| this.properties.getOauth().getAccessToken() == null
			|| this.properties.getOauth().getAccessTokenSecret() == null) 
		{
			log.error("Twitter4j properties not configured properly. Please check twitter4j.* properties settings in configuration file.");
			throw new RuntimeException("Twitter4j properties not configured properly. Please check twitter4j.* properties settings in configuration file.");
		}
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(properties.getDebug())
		  .setOAuthConsumerKey(properties.getOauth().getConsumerKey())
		  .setOAuthConsumerSecret(properties.getOauth().getConsumerSecret())
		  .setOAuthAccessToken(properties.getOauth().getAccessToken())
		  .setOAuthAccessTokenSecret(properties.getOauth().getAccessTokenSecret());
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public Twitter twitter(TwitterFactory twitterFactory){
		return twitterFactory.getInstance();
	}
	
}
