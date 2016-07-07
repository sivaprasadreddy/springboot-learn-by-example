package com.sivalabs.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 *
 */
@Component
@ConfigurationProperties(prefix="jdbc")
public class DataSourceConfig
{
	private String driver;
	private String url;
	private String username;
	private String password;
	
	@Override
	public String toString()
	{
		return "DataSourceConfig [driver=" + driver + ", url=" + url + ", username=" + username + "]";
	}
	public String getDriver()
	{
		return driver;
	}
	public void setDriver(String driver)
	{
		this.driver = driver;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

}
