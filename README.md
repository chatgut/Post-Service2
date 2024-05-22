PostService2

This is a Spring Boot microservice for posting and retrieving messages. The service uses a MySQL database to store the messages.
Prerequisites

    Docker
    Docker Compose

Getting Started
Running with Docker Compose

    Create a docker-compose.yaml file:
    Create a file named docker-compose.yaml in your desired directory and add the following content:


version: '3.8'

services:
postservice:
image: aeldin/postservice2:1.0
container_name: postservice
ports:
- "8090:8080"
environment:
SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/messages
SPRING_DATASOURCE_USERNAME: root
SPRING_DATASOURCE_PASSWORD: secret
depends_on:
- mysql

mysql:
image: mysql:latest
restart: always
environment:
MYSQL_ROOT_PASSWORD: secret
MYSQL_DATABASE: messages
ports:
- "3306:3306"

Run the containers:


    docker-compose up

    This will pull the aeldin/postservice2:1.0 image from Docker Hub and start both postservice and mysql containers.

    Access the Service:
    The microservice will be available at http://localhost:8090.

Endpoints

    Post a Message:
        URL: http://localhost:8090/api/messages
        Method: POST
        Headers:
            Content-Type: application/json
            userid: <your-username>
        Body (example):

        json

        {
          "receiverUsername": "receiverUser",
          "message": "Hello, World!"
        }

    Get a Message by ID:
        URL: http://localhost:8090/api/messages/{id}
        Method: GET

Example Requests Using Insomnia

    POST Request:
        URL: http://localhost:8090/api/messages
        Method: POST
        Headers:
            Content-Type: application/json
            userid: someUserId
        Body:

        json

        {
          "receiverUsername": "receiverUser",
          "message": "Hello, World!"
        }

    GET Request:
        URL: http://localhost:8090/api/messages/{id}
        Method: GET

Stopping the Services

To stop the running containers, press CTRL+C in the terminal where docker-compose is running. Alternatively, you can run:


docker-compose down

Project Structure

    docker-compose.yaml: Docker Compose file to run the postservice and mysql containers.

Configuration

    The database connection details are specified in the docker-compose.yaml file.
    The application properties are configured in the Docker image.

Database

    Image: mysql:latest
    Database Name: messages
    Username: root
    Password: secret

The MySQL database is automatically initialized with the necessary schema when the containers are started.