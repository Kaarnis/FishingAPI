# Fishing Tracker API

## Overview
The Fishing Tracker API is a RESTful web service developed using Java and Spring Boot. This API allows users to log and manage their fishing catches, tracking the details of each catch. The application is designed to be easily deployable using Docker.

## Features
- **Catch Logging**: Record fishing catches, including details like species, weight, and location.
- **Catch Retrieval**: Fetch individual or all fishing catches.

## Prerequisites
Before you start, ensure you have the following installed:
- **Java 17+**
- **Maven**
- **Docker**

## Getting Started

### Clone the Repository

git clone https://github.com/yourusername/fishing-tracker-api.git
cd fishing-tracker-api

## Build the Project
Use Maven to build the project:
mvn clean install

## Running the Application Locally
You can run the application using Maven:
mvn spring-boot:run

The API will be available at http://localhost:8080.

## Running the Application with Docker
The application is Dockerized for easy setup. To run it in a Docker container:

1. Build the Docker Image: docker build -t fishing-tracker-api .
2. Run the Docker Container: docker run -d -p 8080:8080 fishing-tracker-api

