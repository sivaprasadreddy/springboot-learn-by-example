# SpringBoot : Learn By Example


### Chapter 11 : Web Applications with SpringBoot

**springboot-jetty-undertow-demo**: This module is a basic SpringBoot web application demonstrating how to use Jetty or Undertow Servlet containers instead of default Tomcat container.

#### How to run?

Cuurently spring-boot-starter-undertow is configured to use Undertow container.

springboot-jetty-undertow-demo> mvn spring-boot:run

If you want to use **Jetty**, uncomment **spring-boot-starter-jetty** and comment out **spring-boot-starter-undertow** starter in pom.xml.

Go to http://localhost:8080/