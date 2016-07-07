/**
 * 
 */
package com.sivalabs.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Siva
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{   
	
	@Autowired
    private MessageSource messageSource;

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }
	
    //https://spring.io/blog/2015/06/08/cors-support-in-spring-framework
    //https://spring.io/understanding/CORS
    //https://spring.io/guides/gs/rest-service-cors/
    
    @Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")
			;
	}
    
    /*@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedOrigins("http://domain2.com")
			.allowedMethods("PUT", "DELETE")
			.allowedHeaders("header1", "header2", "header3")
			.exposedHeaders("header1", "header2")
			.allowCredentials(false).maxAge(3600);
	}*/
}
