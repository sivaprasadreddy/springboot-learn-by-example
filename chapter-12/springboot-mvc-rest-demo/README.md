# SpringBoot : Learn By Example


### Chapter 12 : Building REST API using SpringBoot

**springboot-mvc-rest-demo**: This module demonstrates how to build RESTful WebServices using SpringMVC.

#### How to run?

You can run the server and test REST endpoints using RestTemplate by running tests.

springboot-mvc-rest-demo> mvn test


You can start the server and use tools like Postman to invoke REST Endpoints as follows:

springboot-mvc-rest-demo> mvn spring-boot:run

Example 1 : Invoke GET http://localhost:8080/posts

Example 2 : Invoke GET http://localhost:8080/posts/1

Example 3 : Invoke POST http://localhost:8080/posts

RequestBody:

{
	"title": "My New Post",
	"content": "This is my new post"	
}

