/**
 * 
 */
package com.sivalabs.demo;

/**
 * @author Siva
 *
 */
public class User
{
	private Integer id;
	private String name;
	private String email;
	
	public User()
	{
	}

	public User(Integer id, String name, String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
}
