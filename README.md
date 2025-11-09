# pulse-RestWebServices

Use postgresql for database

JavaFX for frontend (+css)

Junit5 for testing.

## Branching strategy:

- frontend
- database 1 for each service.
- database integration.
- testing for each branch.
- JSON communication test (API)

## Dependencies Explained

This project implements a local prototype of LTU’s *“Administration of Study Results”* process, following EA and SOA principles.  
Each dependency below supports a specific architectural layer or development activity.

### Frontend (JavaFX)
- **`org.openjfx:javafx-controls` / `javafx-fxml`**  
  Provide the graphical user interface (GUI). Used to build the *Pulse EduDataIntegrator* desktop app that interacts with backend REST services.

### Database Access
- **`org.postgresql:postgresql`**  
  JDBC driver for connecting Java applications to a PostgreSQL database (used for the three local schemas Epok, StudentITS and Ladok).  
- **`com.zaxxer:HikariCP`**  
  High-performance connection pool that efficiently manages concurrent database access.  
- **`jakarta.persistence:jakarta.persistence-api`**  
  Standard API (JPA) for defining how Java objects map to database tables.  
- **`org.hibernate.orm:hibernate-core` / `hibernate-hikaricp`**  
  Implements the JPA API; handles object-relational mapping and SQL generation automatically.

### REST and Integration (SOA Layer)
- **`org.glassfish.jersey.*` (server, grizzly2-http, json-jackson, bean-validation, hk2)**  
  Jersey is the framework used to build REST web services.  
  - `jersey-server` — core JAX-RS engine that defines endpoints.  
  - `jersey-container-grizzly2-http` — runs the REST API in a lightweight embedded server.  
  - `jersey-media-json-jackson` — auto-converts Java objects ⇄ JSON.  
  - `jersey-bean-validation` — validates incoming data automatically.  
  - `jersey-hk2` — provides dependency injection for REST resources.
- **`com.fasterxml.jackson.datatype:jackson-datatype-jsr310`**  
  Adds JSON support for Java 8+ date/time types (e.g. `LocalDate`).

### Validation
- **`jakarta.validation:jakarta.validation-api`** / **`org.hibernate.validator:hibernate-validator`**  
  Define and execute validation annotations such as `@NotNull` and `@Email` on DTOs before data reaches the database.  
- **`org.glassfish:jakarta.el`**  
  Required by the validator for expression-based checks.

### Logging and Security
- **`org.slf4j:slf4j-api`** and **`ch.qos.logback:logback-classic`**  
  Unified, configurable logging for all project layers.  
- **`at.favre.lib:bcrypt`**  
  Optional library for securely hashing sensitive data like passwords.

### Database Migrations
- **`org.flywaydb:flyway-core`**  
  Manages SQL migrations and keeps the three local schemas synchronized.  
  Also used by the Maven Flyway Plugin profile (`-Pdb`).

### Testing
- **`org.junit.jupiter:junit-jupiter`**  
  Core unit-testing framework for Java 21.  
- **`org.testfx:*` (core, junit5)**  
  Automates JavaFX GUI tests.  
- **`io.rest-assured:rest-assured`**  
  Simplifies integration testing of REST endpoints with JSON assertions.

### Build and Enforcement Plugins
- **Maven Compiler Plugin** — compiles sources to Java 21.  
- **Maven Surefire / Failsafe Plugins** — run unit and integration tests separately.  
- **Maven Enforcer Plugin** — ensures correct Java and Maven versions.  
- **JavaFX Maven Plugin** — runs the GUI via `mvn javafx:run`.  
- **Maven Jar / Dependency Plugins** — package the project and copy required runtime JARs.  
- **Flyway Maven Plugin** — applies SQL migrations through the `db` profile.

