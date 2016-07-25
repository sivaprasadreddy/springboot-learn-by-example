FROM java:8
ADD springboot-mysql-docker-demo.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]