# Microservices_JWT_Authentication_Authorization_Spring-Boot-3

[![Spring Boot 3.1.1](https://img.shields.io/badge/Spring%20Boot-3.1.1-green.svg?logo=spring-boot)](https://spring.io/blog/2023/06/22/spring-boot-3-1-1-available-now)
[![Spring Security 5](https://img.shields.io/badge/Spring%20Security-5-green.svg?logo=spring)](https://docs.spring.io/spring-security/reference/index.html)
[![Spring Cloud 2022](https://img.shields.io/badge/Spring%20Cloud-v2022.0.3-green.svg?logo=spring)](https://docs.spring.io/spring-security/reference/index.html)
[![PostgreSQL 14](https://img.shields.io/badge/PostgreSQL-v14-blue.svg?logo=postgresql)](https://www.postgresql.org/)
[![Java 17](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Maven 4](https://img.shields.io/badge/Maven-4.0-orange.svg?logo=maven)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

This project implements microservices for the API backend using Authentication & Authorization security. With each service having its own database for microservices. PostgresSQL database used in this project and uses **Spring Boot** Maven. 

## Installation
You can install this Spring Boot Applications locally or on a server/cloud. Installation via the cloud such as: AWS, Azure, Google Cloud, and etc. You can visit the steps from this link [Deploying Spring Boot Applications on Cloud](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html#deployment.cloud). For this installation, I only did a local installation and on an Ubuntu server/VM.

- **On local (Windows):**
  - Install [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
  - Install [PostgreSQL](https://www.postgresql.org/download/windows/)
  - Install [IDE Intellij](https://www.jetbrains.com/idea/download/?section=windows)
    
- **On Ubuntu Server/VM:**
  - ```bash
    $ sudo su
    $ apt update
    $ apt install maven
    $ apt install openjdk-17-jdk
    $ apt install postgresql postgresql-contrib
    ```
  - To ensure the "JAVA_HOME" environment variable on the ubuntu server operating system can find and use the right Java JDK version. You can run the command below:
     ```bash
     $ export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
     ```

## How To Run
- **On local (Windows):**
  - Set the username and password corresponding to PostgreSQL/pgAdmin as well as the port and database name file 
    `application.properties` in each project service.
    ```bash
    spring.datasource.url= jdbc:postgresql://localhost:5432/auth-service  
    spring.datasource.username= auth
    spring.datasource.password= veduser

    #spring.datasource.url= jdbc:postgresql://localhost:5432/auth-service
    # Default of the PostgreSQL database is postgres (Ex: jdbc:postgresql://localhost:5432/postgres)   
    #spring.datasource.username= <Your Username PostgteSQL>
    #spring.datasource.password= <Your Password PostgteSQL>
    ```
  - To create a database you can do _"Right Click" > "Create" > "Database"_ in the PgAdmin 4 (PostgreSQL) application on Windows.
  - Especially for `auth-service` database in the **roles** table in PgAdmin4 (PostgreSQL). Add the following SQL query for the 
    _authorization_ function to run according to the role you want in the `/model/ERole.java` file :
    ```sql
    INSERT INTO roles(name) VALUES('ROLE_USER');
    INSERT INTO roles(name) VALUES('ROLE_ADMIN');
    ```
  - Then, run each services in the **Intelij IDE**. Make sure you run **Eureka Server** with the default port 8761 `localhost:8761` 
    and also make sure that all services are connected via the eureka server display.
    
- **On Ubuntu Server:**
