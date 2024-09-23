# Cookie Authentication

This repository contains the backend implementation of the Cookie Authentication project, built with Java, Spring Boot and Maven.
The application demonstrates secure user authentication using cookies and sessions.

## Frontend Repository

The frontend implementation is available at [cookie-auth-frontend](https://github.com/renefatuaki/cookie-auth-frontend).

## Docker Setup

Docker is used to containerize the application and manage the MongoDB database.

Start Docker MongoDB Container:

```shell
docker-compose up -d
```

### Connecting to MongoDB

Connect to the Dockerized MongoDB instance using the URI:

`mongodb://root:secret@localhost:27017/auth?authSource=admin`

## Security Configuration

### Filter Chain

The `SecurityFilterChain` in the `SecurityConfig` class configures:

- **CSRF Protection**: Stores CSRF tokens in cookies  `HttpOnly: false` using CsrfTokenRequestAttributeHandler.
- **Authorization**: `/api/hello` requires authentication, other requests are permitted.
- **Session Management**: Sessions are always created.
- **Authentication**: Both HTTP Basic and form-based login are enabled.

### Password Encryption

Passwords are hashed using **Argon2** via Argon2PasswordEncoder in SecurityConfig.

### Session Management

Sessions are managed securely with a policy to always create sessions and are invalidated upon logout to prevent session fixation attacks.
