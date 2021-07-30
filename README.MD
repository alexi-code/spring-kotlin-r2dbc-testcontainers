# Reactive Matcher Server

## Kotlin + Spring Boot + R2DBC + Liquibase + Testcontainers

Sample of simple matching service with REST API.
The general logic is to match the customer request with seller's store of certificates and return the results.

- Controller, service, repository and tests implemented in a non-blocking manner.
- Integration tests cover possible use cases by deploying PostgreSQL in a temporary test docker container, being similar to production.

## Components

- Kotlin 1.5.20
- Spring Boot 2.5.2
- Spring WebFlux
- Spring Data R2DBC + PostgreSQL
- Liquibase (R2DBC doesn't create DDLs yet)
- Swagger (as we don't implement web GUI)
- MapStruct

Additionally, for the test purposes:

- Testcontainers

## Comments

Since Spring Data R2DBC doesn't support a lot of Hibernate features yet, the UUID key generation is on the hands of PostgreSQL.

## Why is it reactive? 

[Performance of relational database drivers. R2DBC vs JDBC](https://technology.amis.nl/software-development/performance-and-tuning/spring-blocking-vs-non-blocking-r2dbc-vs-jdbc-and-webflux-vs-web-mvc/)

[Spring: Blocking vs non-blocking: R2DBC vs JDBC and WebFlux vs Web MVC](https://technology.amis.nl/software-development/performance-and-tuning/performance-of-relational-database-drivers-r2dbc-vs-jdbc/)

[Official documentation from Spring about R2DBC Repositories](https://docs.spring.io/spring-data/r2dbc/docs/current/reference/html/#r2dbc.repositories)

## Local deploy

- To deploy PostgreSQL run ```docker-compose.yaml``` with ```docker-compose up```


- Build app: ```./gradlew build```


- Run app: ```./gradlew run```


## How to test

- SwaggerUI entry point: http://localhost:8080/swagger-ui.html


- Run tests: ```./gradlew test```

## Credentials

:hammer: Created by [Alex Antukhov](https://www.linkedin.com/in/antukhov/)
