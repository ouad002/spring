# Simple Tutorial for Spring Boot Project

Welcome to the tutorial for the Spring Boot application. This guide will walk you through the steps to set up and run the application locally.

## Prerequisites

Before starting, ensure that you have the following tools installed:

- **Java 21** or later
- **Gradle** (or you can use the included Gradle wrapper)

## Step 1: Clone the Repository

First, clone the repository to your local machine:

`git clone https://github.com/ouad002/spring.git`<br><br>
`cd spring`

## Step 2: Build the Project

Next, build the project using Gradle. You can use the included Gradle wrapper to build the project:

`./gradlew build`

This will download the necessary dependencies, compile the project, and run the tests.

## Step 3: Run the Application

Once the build process is complete, you can run the application locally:

`./gradlew bootRun`

The application will start and be available at:

`http://localhost:8080`

## Step 4: Access the API Documentation

The API documentation for your project is automatically generated. Once the application is running, visit:

`http://localhost:8080/swagger-ui.html`

Here, you'll find interactive API documentation powered by OpenAPI.

## Step 5: Run Tests

To ensure everything works as expected, run the tests:

`./gradlew test`

## Step 7: Use the Pre-Commit Hook

This project includes a pre-commit hook that runs Checkstyle to ensure the code follows the style guidelines. To enable this feature, run:

`git config core.hooksPath .githooks`

This will configure Git to use the .githooks directory for hooks.

Conclusion
----------------

You have now successfully set up and run the Spring Boot application. You can explore the available endpoints, modify the project, or extend it with additional functionality.
