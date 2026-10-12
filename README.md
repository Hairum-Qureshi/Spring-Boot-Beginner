# Spring Boot Learning Project

A personal backend development project built with **Java, Spring Boot, and PostgreSQL**.

This repository serves as a learning environment for exploring the Spring Boot ecosystem, RESTful API development, database integration, and object-oriented programming.

The project is primarily intended for experimentation and hands-on learning rather than production use.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Primary programming language |
| Spring Boot | Backend application framework |
| Spring Web MVC | REST API development |
| Spring Data JPA | Database persistence |
| Hibernate | Object-relational mapping (ORM) |
| PostgreSQL | Relational database |
| Neon | Serverless PostgreSQL hosting |
| TSID Creator | Time-sorted unique identifier generation |
| Maven | Dependency management and build automation |
| Postman | API endpoint testing |

Spring Boot DevTools is also included for development convenience.

## Getting Started

### Prerequisites

Before running the application, ensure you have:

- Java JDK compatible with the project's configured Java version
- IntelliJ IDEA
- Maven or the Maven Wrapper included with the project
- A Neon account for PostgreSQL hosting
- Postman (optional, for testing API endpoints)

### 1. Clone the Repository

Clone this repository to your local machine using Git:

```bash
git clone <repository-url>
```

Navigate into the cloned project directory and open it in IntelliJ IDEA.

Allow IntelliJ to import the Maven project and download its dependencies.

### 2. Create a PostgreSQL Database with Neon

This application uses PostgreSQL hosted on [Neon](https://neon.com/).

1. Visit the [Neon Console](https://console.neon.tech/) and sign in or create an account.
2. Create a new Neon project.
3. Choose your preferred PostgreSQL version and hosting region.
4. Select a database name or use the default `neondb`.
5. Create the project.

Once the project is created, Neon will provision a PostgreSQL database.

### 3. Obtain the Neon Java Connection String

From your Neon project dashboard:

1. Click **Connect** to open the database connection details.
2. Select the appropriate database, branch, and role.
3. Locate the connection string options and select **Java/JDBC**, if available.
4. Copy the generated JDBC connection string.

Your connection string should resemble:

```text
jdbc:postgresql://YOUR_HOST/YOUR_DATABASE?user=YOUR_USERNAME&password=YOUR_PASSWORD&sslmode=require&channelBinding=require
```

Replace the placeholders with the connection details provided by Neon.

**Important:** Use the Java-compatible JDBC connection string beginning with `jdbc:postgresql://`, rather than the standard PostgreSQL URI beginning with `postgresql://`.

Keep your connection string private, as it contains database credentials.

### 4. Configure the Database Environment Variable in IntelliJ IDEA

For security, this application uses an environment variable named `DATABASE_URL` rather than storing database credentials directly in `application.properties`.

Follow these steps to configure the environment variable:

1. Open **IntelliJ IDEA**.
2. Navigate to **Run → Edit Configurations**.
3. Click the **+** button to add a new run configuration.
4. Select **Application** as the configuration type.
5. Give the configuration a name, such as `Spring Boot Application`.
6. Under **Main class**, select your Spring Boot application's entry-point class. This is the class annotated with `@SpringBootApplication` that contains the `main()` method.
7. Select the appropriate project module or classpath if IntelliJ has not automatically configured it.
8. Locate the **Environment variables** field. If it is not visible, enable it through **Modify options → Environment variables**.
9. Enter the following environment variable, replacing the placeholders with your Neon connection details:

```text
DATABASE_URL=jdbc:postgresql://YOUR_HOST/YOUR_DATABASE?user=YOUR_USERNAME&password=YOUR_PASSWORD&sslmode=require&channelBinding=require
```

10. Click **Apply**, followed by **OK**, to save the configuration.

IntelliJ will now provide the `DATABASE_URL` environment variable whenever the application is launched through this run configuration.

Ensure that any locally saved configuration containing credentials is not committed to version control.

### 5. Application Configuration

Spring Boot reads application configuration from:

```text
src/main/resources/application.properties
```

The project uses the following configuration:

```properties
spring.datasource.url=${DATABASE_URL}
spring.jpa.hibernate.ddl-auto=update
```

**Configuration Explanation:**

- `spring.datasource.url=${DATABASE_URL}` — Instructs Spring Boot to retrieve the PostgreSQL JDBC connection string from the `DATABASE_URL` environment variable.
- `spring.jpa.hibernate.ddl-auto=update` — Allows Hibernate to update the database schema based on the application's mapped JPA entities.

The `update` setting is useful during development and experimentation. Production applications generally use dedicated database migration tools such as Flyway or Liquibase.

### 6. Run the Application

After configuring the environment variable:

1. Open the Spring Boot project in IntelliJ IDEA.
2. Select the **Application** run configuration created earlier.
3. Click the **Run** button.
4. Wait for Spring Boot to initialize and establish a database connection.

By default, the application starts at:

```text
http://localhost:8080
```

If the application starts successfully, you can access its endpoints through your browser or Postman.

## API Endpoints

The application currently provides a greeting endpoint and basic CRUD operations for managing people.

| Method | Endpoint | Description |
|---|---|---|
| GET | `/` | Returns a simple greeting message |
| POST | `/people/add` | Creates a new person and returns their data as a JSON object |
| GET | `/people/all` | Returns a JSON array of all existing people |
| GET | `/people/find/{id}` | Returns a JSON object of the person matching the provided ID |
| PUT | `/people/edit/{id}` | Updates an existing person and returns the updated data as JSON |
| DELETE | `/people/delete/{id}` | Deletes a person and returns a JSON response confirming the deletion |

### Example Request

```http
GET http://localhost:8080/
```

**Response:**

```text
Hello, Hairum!
```

You can test the endpoint by navigating to the URL in your browser or sending a GET request through Postman.

For the remaining endpoints, use Postman to send requests with the appropriate HTTP methods, parameters, and request bodies.

Additional endpoints may be introduced as development progresses.

## Database Integration

This project uses **Spring Data JPA** and **Hibernate** for database persistence, with **Neon PostgreSQL** providing the hosted relational database.

The PostgreSQL JDBC driver handles communication between the Spring Boot application and the database.

The project also includes **TSID Creator**, a Java library for generating time-sorted unique identifiers.

Database models, repositories, and relationships may evolve as new Spring Boot concepts are explored.

## Learning Objectives

The purpose of this project is to develop a better understanding of:

- Java fundamentals and object-oriented programming
- Spring Boot application structure and configuration
- Controllers, services, and dependency injection
- RESTful API design and HTTP request handling
- Spring Data JPA repositories
- Hibernate and entity mapping
- PostgreSQL integration
- Database relationships and persistence
- Maven dependency management
- Environment variables and externalized configuration
- Backend application development using the Spring ecosystem

## Project Status

**Work in Progress — Educational Project**

This project is actively used for learning and experimentation. Features, architecture, and implementation details are subject to change as I become more familiar with Spring Boot.

The repository is not intended to represent a production-ready application.