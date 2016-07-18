

Running MySQL and Application containers individually
======================================================

*Run mysql :*

docker run -d --name demo-mysql -e MYSQL_ROOT_PASSWORD=secret123 -e MYSQL_DATABASE=demo -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=secret mysql:latest

*Run application linking to demo-mysql container:*

docker run -d --name springboot-docker-demo --link demo-mysql:mysql -p 8080:8080 sivaprasadreddy/springboot-docker-demo


Running MySQL and Application using docker-compose
==================================================

Navigate to the directory where docker-compose.yml file is there.

src/main/docker> docker-compose up