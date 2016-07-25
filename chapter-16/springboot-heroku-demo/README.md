# SpringBoot : Learn By Example

### Chapter 16 : Deploying SpringBoot Applications

**springboot-heroku-demo**: This module demonstrates running SpringBoot application on Heroku platform and using Docker as well.

#### How to run locally?

springboot-heroku-demo> mvn spring-boot:run

## Running on Heroku

Just push the changes to Github which will be automatically deployed on to Heroku.

## Running on Docker container

Build the docker image

springboot-heroku-demo> docker build -t sivaprasadreddy/springboot-heroku-demo .


### Running Postgres and Application containers individually


*Run Postgres :*

docker run --name demo-postgres \
            -e POSTGRES_DB=demodb \
            -e POSTGRES_USER=postgres \
            -e POSTGRES_PASSWORD=secret123 \
            -d postgres

*Run application linking to demo-postgres container:*

docker run -d \
            --name springboot-heroku-demo \
            --link demo-postgres:postgres \
            -p 80:8080 \
            sivaprasadreddy/springboot-heroku-demo

### Running Postgres and Application using docker-compose


Navigate to the directory where docker-compose.yml file is there.

springboot-heroku-demo> docker-compose up
