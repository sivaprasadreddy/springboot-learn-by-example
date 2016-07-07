/**
 * 
 */
package com.sivalabs.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.sivalabs.demo.entities.User;

/**
 * @author Siva
 *
 */

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
    }
}

