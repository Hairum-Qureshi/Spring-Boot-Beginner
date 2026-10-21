# Spring Boot & Spring Security Learning Project

A personal backend development project built with **Java, Spring Boot, Spring Security, and PostgreSQL**.

This project originally started as a way to learn Spring Boot fundamentals, including RESTful API development, database integration, and backend application architecture. As development progressed, the focus shifted toward learning **Spring Security**, particularly user authentication, account registration, and email verification.

The application currently implements basic **sign-up, sign-in, and email verification using verification codes**, with Spring Security handling authentication and Resend providing email delivery.

**This is not intended to be a production-ready application.** It is simply a personal project for experimenting with Spring Boot, Spring Security, and related backend technologies through hands-on development.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Primary programming language |
| Spring Boot | Backend application framework |
| Spring Security | Authentication and security |
| Spring Web MVC | REST API development |
| Spring Data JPA | Database persistence |
| Hibernate | Object-relational mapping (ORM) |
| PostgreSQL | Relational database |
| Neon | Serverless PostgreSQL hosting |
| JWT | Token-based authentication |
| Resend | Email delivery for verification codes |
| TSID Creator | Time-sorted unique identifier generation |
| Lombok | Reducing boilerplate code |
| Maven | Dependency management and build automation |
| Postman | API testing |

Spring Boot DevTools is also included for development convenience.

## Implemented Features

The project currently includes the following authentication features:

- **User Registration:** Basic account creation using a sign-up process.
- **User Sign-In:** Authentication using Spring Security.
- **Email Verification:** Verification codes sent to users through email to verify their accounts.
- **JWT Authentication:** Token-based authentication for managing authenticated requests.
- **Database Persistence:** Storage and management of application data using Spring Data JPA, Hibernate, and PostgreSQL.

These features were implemented primarily to understand how authentication and security work within the Spring ecosystem, rather than to build a complete authentication solution for production.

## Getting Started

### Prerequisites

Before running the application, ensure you have:

- Java JDK compatible with the project's configured Java version
- IntelliJ IDEA (recommended)
- Maven or the Maven Wrapper included with the project
- A [Neon](https://neon.com/) account for PostgreSQL hosting
- A [Resend](https://resend.com/) account for sending verification emails
- Postman (optional, for testing API requests)

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone <repository-url>
```

Navigate into the cloned project directory and open it in IntelliJ IDEA.

Allow IntelliJ to import the Maven project and download its dependencies.

### 2. Set Up a PostgreSQL Database with Neon

This application uses PostgreSQL hosted on [Neon](https://neon.com/).

1. Visit the [Neon Console](https://console.neon.tech/) and sign in or create an account.
2. Create a new Neon project.
3. Select your preferred PostgreSQL version and hosting region.
4. Choose a database name or use the default `neondb`.
5. Create the project.

Once the database has been provisioned, open the project's connection details.

Select the **Java/JDBC** connection string format, if available.

The connection string should resemble:

```text
jdbc:postgresql://YOUR_HOST/YOUR_DATABASE?user=YOUR_USERNAME&password=YOUR_PASSWORD&sslmode=require&channelBinding=require
```

Replace the placeholders with your actual Neon connection details.

**Important:** The application expects a JDBC connection string beginning with `jdbc:postgresql://`, not the standard PostgreSQL URI beginning with `postgresql://`.

Keep your database credentials private.

### 3. Configure Resend for Email Verification

The application uses **Resend** to send email verification codes during the authentication process.

To enable email verification, you must create a Resend account, obtain an API key, and configure an email address for sending messages.

#### Create a Resend Account

1. Visit [Resend](https://resend.com/).
2. Create an account or sign in.
3. Open the [Resend Dashboard](https://resend.com/overview).

#### Generate an API Key

1. Navigate to [API Keys](https://resend.com/api-keys) in the Resend dashboard.
2. Click **Create API Key**.
3. Give the key a descriptive name, such as `spring-boot-learning`.
4. Select **Sending access** as the permission, since the application only needs to send emails.
5. If applicable, restrict the key to the domain you intend to use.
6. Create the API key and copy it.

The API key should resemble:

```text
re_xxxxxxxxxxxxxxxxxxxxxxxxx
```

This key will be assigned to the `RESEND_API_KEY` environment variable.

**Important:** Keep your API key private. Never commit it to Git or expose it in a public repository.

#### Configure a Sending Email Address

Resend requires an authorized sending address to deliver emails.

For sending verification emails to arbitrary recipients, you will generally need to verify a domain that you own.

1. In the Resend dashboard, navigate to [Domains](https://resend.com/domains).
2. Click **Add Domain**.
3. Enter a domain you own, such as `example.com`.
4. Add the DNS records provided by Resend to your domain's DNS configuration.
5. Wait for the records to propagate and for Resend to verify the domain.

After verification, you can use an email address associated with that domain, such as:

```text
support@example.com
```

This address should be assigned to the `SUPPORT_EMAIL` environment variable, which the application uses as its configured email address for sending verification messages.

**Note:** Resend provides limited testing capabilities without requiring a verified custom domain. However, sending emails to arbitrary recipients generally requires domain verification. Refer to the [Resend documentation](https://resend.com/docs) for details.

### 4. Configure Environment Variables

The application uses environment variables to manage database credentials, authentication secrets, email configuration, and application URLs.

The following environment variables are required:

| Variable | Description |
|---|---|
| `DATABASE_URL` | PostgreSQL JDBC connection string obtained from Neon |
| `DEPLOYED_URL` | Public URL of the deployed backend application |
| `DEVELOPMENT_URL` | URL of the backend application during local development |
| `JWT_SECRET_KEY` | Secret key used for JWT signing and validation |
| `RESEND_API_KEY` | API key obtained from Resend for sending emails |
| `SUPPORT_EMAIL` | Configured sender email address for verification messages |

For local development, the environment variables can be configured as follows:

```dotenv
DATABASE_URL=jdbc:postgresql://YOUR_HOST/YOUR_DATABASE?user=YOUR_USERNAME&password=YOUR_PASSWORD&sslmode=require&channelBinding=require
DEPLOYED_URL=http://localhost:8080
DEVELOPMENT_URL=http://localhost:8080
JWT_SECRET_KEY=YOUR_SECURE_RANDOM_SECRET_KEY
RESEND_API_KEY=re_YOUR_RESEND_API_KEY
SUPPORT_EMAIL=support@your-verified-domain.com
```

**Additional notes:**

- `DEPLOYED_URL` is set to `http://localhost:8080` for local testing. If deploying the backend, replace it with the actual publicly accessible backend URL.
- `DEVELOPMENT_URL` is set to `http://localhost:8080` because the application runs locally on port `8080` by default.
- `JWT_SECRET_KEY` should be a securely generated random secret with sufficient length for the JWT signing algorithm used by the application. Do not use the example placeholder as an actual secret.
- `RESEND_API_KEY` must contain the API key generated from your Resend account.
- `SUPPORT_EMAIL` should be an email address authorized for sending through Resend.

#### Set Environment Variables in IntelliJ IDEA

To configure the environment variables in IntelliJ IDEA:

1. Open the project in **IntelliJ IDEA**.
2. Navigate to **Run → Edit Configurations**.
3. Create a new **Application** run configuration if one does not already exist.
4. Select the application's main class annotated with `@SpringBootApplication`.
5. Select the appropriate project module or classpath.
6. Locate the **Environment variables** field. If it is not visible, enable it through **Modify options → Environment variables**.
7. Add all six environment variables with their respective values.
8. Click **Apply**, followed by **OK**, to save the configuration.

IntelliJ will provide these variables to the application whenever it is launched using this run configuration.

Make sure that credentials and secrets stored in local configuration files are not committed to version control.

### 5. Application Configuration

Spring Boot reads application configuration from:

```text
src/main/resources/application.properties
```

The database configuration uses the `DATABASE_URL` environment variable:

```properties
spring.datasource.url=${DATABASE_URL}
spring.jpa.hibernate.ddl-auto=update
```

**Configuration Explanation:**

- `spring.datasource.url=${DATABASE_URL}` — Retrieves the PostgreSQL JDBC connection string from the environment.
- `spring.jpa.hibernate.ddl-auto=update` — Allows Hibernate to update the database schema based on the application's mapped JPA entities.

The `update` setting is convenient for learning and experimentation. Production applications typically use dedicated database migration tools such as Flyway or Liquibase.

Other application settings are configured using the environment variables described above.

### 6. Run the Application

After setting up Neon, Resend, and the required environment variables:

1. Open the project in IntelliJ IDEA.
2. Select the configured application run configuration.
3. Click **Run**.
4. Allow Spring Boot to initialize and establish its database connection.

By default, the application runs at:

```text
http://localhost:8080
```

Once the application starts, you can use Postman or another API client to test the authentication functionality.

For example, you can experiment with registering an account, signing in, and completing email verification using the code delivered through Resend.

## Authentication and Email Verification

The main focus of the project is exploring authentication using **Spring Security**.

The application implements a basic authentication process consisting of account registration, sign-in, and email verification.

During email verification, the application uses Resend to send a verification code to the user's email address. The user can then submit that code to complete the verification process.

JWT is used for token-based authentication.

Implementing these features provides hands-on experience with authentication workflows, security configuration, and integrating an external email service into a Spring Boot backend.

The implementation is intentionally focused on learning and should not be considered a complete or production-hardened authentication system.

## Database Integration

The application uses **Spring Data JPA** and **Hibernate** for database persistence, with **Neon PostgreSQL** providing the hosted relational database.

The PostgreSQL JDBC driver handles communication between the application and the database.

The project also uses **TSID Creator** for generating time-sorted unique identifiers.

Working with these technologies provides experience with entity mapping, database persistence, repository abstractions, and integrating a relational database into a Spring Boot application.

## Learning Objectives

This project was created to develop a better understanding of backend development using the Spring ecosystem.

The original learning objectives focused on Spring Boot fundamentals, including:

- Java and object-oriented programming
- Spring Boot application structure and configuration
- Controllers, services, and dependency injection
- RESTful API design and HTTP request handling
- Spring Data JPA repositories
- Hibernate and entity mapping
- PostgreSQL integration and database persistence
- Maven dependency management
- Environment variables and externalized configuration

As the project progressed, the focus expanded toward **Spring Security and authentication**, including:

- Understanding Spring Security fundamentals
- Implementing user registration and sign-in
- Working with authentication and security configuration
- Understanding JWT-based authentication
- Implementing email verification using verification codes
- Integrating Resend for transactional email delivery
- Handling authentication-related requests and responses
- Understanding how different components of an authentication system work together

## Disclaimer

**This project is strictly for educational purposes.**

It was originally created to learn Spring Boot and later evolved into an opportunity to explore Spring Security and authentication.

The code and architecture are intended for experimentation, practice, and understanding backend development concepts.

It is not designed, audited, or maintained as a production-ready application, and its authentication implementation should not be assumed to provide all the security protections required for a real-world system.