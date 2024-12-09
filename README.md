Spring Boot Project
===================

This project is a simple Spring Boot application demonstrating the use of Spring Web, Spring Data JPA, and Spring Security. It also integrates H2 for an in-memory database and generates API documentation using OpenAPI.

Table of Contents
-----------------

-   [Requirements](#requirements)
-   [Project Structure](#project-structure)
-   [How to Build the Project](#how-to-build-the-project)
-   [How to Run the Project](#how-to-run-the-project)
-   [How to Test the Project](#how-to-test-the-project)
-   [API Documentation](#api-documentation)
-   [Additional Notes](#additional-notes)

Requirements
------------

To build and run this project, ensure that you have the following tools installed on your system:

-   **Java 21**
-   **Gradle** (or use the included Gradle wrapper)

Project Structure
-----------------

The project uses the following dependencies:

-   `spring-boot-starter-web`: To create web applications.
-   `spring-boot-starter-data-jpa`: For database persistence using JPA.
-   `h2`: An in-memory database for testing purposes.
-   `springdoc-openapi`: For generating API documentation.
-   `spring-boot-starter-security`: To provide security features.
-   `junit-platform-launcher`: For running unit tests.

How to Build the Project
------------------------

To build the project, run the following command:

`./gradlew build`

This will:

-   Download the required dependencies.
-   Compile the project.
-   Run all the tests.
-   Package the application as a JAR file.

How to Run the Project
----------------------

To start the Spring Boot application locally, use:

`./gradlew bootRun`

Once the application is running, you can access it at:

`http://localhost:8080`

How to Test the Project
-----------------------

Run the test suite using the following command:

`./gradlew test`

This will execute all unit tests configured in the project.

How to Configure and Run Checkstyle
-----------------------------------

### Step 1: Add Checkstyle Plugin to the `build.gradle`

To integrate Checkstyle into my project, include the Checkstyle plugin in my `build.gradle` file. Specify the tool version and the path to my `checkstyle.xml` configuration file. we can also configure the reports to be generated in HTML format for easier viewing.

### Step 2: Create the Checkstyle Configuration

Create a Checkstyle configuration file  `checkstyle.xml`in a specified directory  `config/checkstyle/`. This file will contain the rules for checking your code style.

### Step 3: Run Checkstyle

Once Checkstyle is configured, run the following Gradle command to check your main code:


`./gradlew checkstyleMain`


API Documentation
-----------------

Once the application is up and running, you can access the automatically generated API documentation at:

`http://localhost:8080/swagger-ui.html`

Additional Notes
----------------

-   **Database**: The application uses an H2 in-memory database, which is ideal for testing and development. You can view the H2 console at `/h2-console` once the application is running.
-   **Security**: Basic security features are configured with Spring Security. Additional settings can be modified in the application configuration if needed.


