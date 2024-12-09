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
-   [How to Configure and Run Checkstyle](#How-to-Configure-and-Run-Checkstyle)
-   [Pre-Commit Hook for Static Code Analysis](#Pre-Commit-Hook-for-Static-Code-Analysis)
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

Pre-Commit Hook for Static Code Analysis
-----------------------------------

This project uses a pre-commit hook to automate static code analysis with Checkstyle. The hook ensures that code follows the project's style and quality standards before a commit is made. It runs Checkstyle on staged files and reports any violations, but does not block the commit even if violations are found.

### How to Use the Pre-Commit Hook
When you clone this repository, you'll need to configure Git to use the custom pre-commit hook. 
### Configure Git to Use the Custom Hooks Directory

To tell Git to use the `.githooks` directory for hooks instead of the default `.git/hooks` directory, run the following command:

`git config core.hooksPath .githooks`

### Verify that the hook is set up

To ensure that Git is using the `.githooks` directory, you can check the configuration with the following command:

`git config --get core.hooksPath`

### Commit as usual

After setting up the pre-commit hook, continue making commits as usual. The pre-commit hook will automatically run Checkstyle on staged files before each commit and report any violations in the terminal. Note that the commit will not be blocked if violations are found.



API Documentation
-----------------

Once the application is up and running, you can access the automatically generated API documentation at:

`http://localhost:8080/swagger-ui.html`

Additional Notes
----------------

-   **Database**: The application uses an H2 in-memory database, which is ideal for testing and development. You can view the H2 console at `/h2-console` once the application is running.
-   **Security**: Basic security features are configured with Spring Security. Additional settings can be modified in the application configuration if needed.


