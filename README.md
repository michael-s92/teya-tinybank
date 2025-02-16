# Teya TinyBank

## Overview

Teya TinyBank is a lightweight banking service built using [Spring Boot](https://spring.io/projects/spring-boot).

## Prerequisites

Before running the application, ensure you have the following installed on your system:

- [Java 23](https://jdk.java.net/23/) (required to run the application)
- [Maven](https://maven.apache.org/) (for building and managing the project)

## Installation

1. **Clone the repository** to your local machine:

    ```bash
    git clone https://github.com/michael-s92/teya-tinybank.git
    cd teya-tinybank
    ```

2. **Build the project** by running the following command:

    ```bash
    mvn clean install
    ```

   If you encounter any issues with dependencies or require an update to your local dependencies, you can force Maven to update them using:

    ```bash
    mvn clean install -U
    ```

   This will force Maven to check for the latest versions of all dependencies.

## Running the Application

Once the project is built, you can start the application by running:

```bash
    mvn spring-boot:run -pl api-service
```

## View API Documentation in UI

If you want to see the API documentation in a user-friendly UI, you can access Swagger UI after starting the application:

- Open a web browser and go to `http://localhost:8080/swagger-ui/index.html`.
- This page provides a graphical interface to view the API endpoints, and it allows you to interact with the API directly from the browser.

## How to use API

To get started with the API, first run a `GET` request to `http://localhost:8080/setup/random` to populate the in-memory data structures with some sample data. This will allow you to see something when you interact with the API.

To check the current balance, you can make a `GET` request to `http://localhost:8080/balance/view`.

To view the history of all executed transactions, simply make a `GET` request to `http://localhost:8080/transaction/history`.

If you’d like to perform a new transaction, you can send a `POST` request to either `http://localhost:8080/transaction/deposit` or `http://localhost:8080/transaction/withdraw`. For the request body, just include the amount for the transaction.
