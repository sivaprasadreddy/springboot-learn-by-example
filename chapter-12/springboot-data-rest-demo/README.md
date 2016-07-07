# SpringBoot : Learn By Example


### Chapter 12 : Building REST API using SpringBoot

**springboot-data-rest-demo**: This module demonstrates how to build RESTful WebServices using Spring Data REST.

#### How to run?

You can run the server and test REST endpoints using RestTemplate by running tests.

springboot-data-rest-demo> mvn test


You can start the server and use tools like Postman to invoke REST Endpoints as follows:

springboot-data-rest-demo> mvn spring-boot:run

Example 1 : Invoke GET http://localhost:8080/api/posts

Example 2 : Invoke GET http://localhost:8080/api/posts/1

Example 3 : Invoke POST http://localhost:8080/api/posts

RequestBody:

{
	"title": "My New Post",
	"content": "This is my new post"	
}

