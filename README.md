# Microservices_JWT_Authentication_Authorization_Spring-Boot-3

[![Spring Boot 3.1.1](https://img.shields.io/badge/Spring%20Boot-3.1.1-green.svg?logo=spring-boot)](https://spring.io/blog/2023/06/22/spring-boot-3-1-1-available-now)
[![Spring Security 5](https://img.shields.io/badge/Spring%20Security-5-green.svg?logo=spring)](https://docs.spring.io/spring-security/reference/index.html)
[![Spring Cloud 2022](https://img.shields.io/badge/Spring%20Cloud-v2022.0.3-green.svg?logo=spring)](https://docs.spring.io/spring-security/reference/index.html)
[![PostgreSQL 14](https://img.shields.io/badge/PostgreSQL-v14-blue.svg?logo=postgresql)](https://www.postgresql.org/)
[![Java 17](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Maven 4](https://img.shields.io/badge/Maven-4.0-orange.svg?logo=maven)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()

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
    $ apt install git
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
  - To create a database you can do _"Right Click" > "Create" > "Database"_ in the PgAdmin 4 (_PostgreSQL_) application on Windows.
  - Especially for `auth-service` database in the **roles** table in PgAdmin4 (_PostgreSQL_). Add the following SQL query for the 
    _authorization_ function to run according to the role you want in the `/model/ERole.java` file :
    ```sql
    INSERT INTO roles(name) VALUES('ROLE_USER');
    INSERT INTO roles(name) VALUES('ROLE_ADMIN');
    ```
  - Then, run each services in the **Intelij IDE**. Make sure you run **Eureka Server** with the default port 8761 `localhost:8761` 
    and also make sure that all services are connected via the eureka server display.
    
- **On Ubuntu Server:**
  - Running Spring Boot Applications can use `systemd` on ubuntu server. **Systemd** is the successor of the System V init system 
    and is now being used by many modern Linux distributions. Before making each service have `systemd`, first set up the 
    **_PostgreSQL_** database for each service on ubuntu server.
  - Make sure you have installed _PostgreSQL_ at the installation stage, now you can run command below :
    ```bash
    $ sudo -u postgres psql
    ```
    If the above command doesn't work, it's usually the case with recent versions of `Ubuntu-Server-22.04.2` and above. To fix it 
    you can run the following command, to see if the cluster on PostgreSQL is running or not : (_Optional_)
    ```bash
    $ sudo pg_ctlcluster
    ```
    Or you can run the command directly cluster on PostgreSQL : (_Optional_)
    ```bash
    $ sudo pg_ctlcluster 14 main start
    ```
    Adjust the command above with your PostgreSQL version `psql --version` and run the command again.
  - If you are already in PostgreSQL from the command :
    ```bash
    $ sudo -u postgres psql
    ```
  - Run the command below, according to the username and password on `application.properties` file :
    ```sql
    # Create username and password
    CREATE USER auth WITH PASSWORD 'veduser';

    # Create database
    CREATE DATABASE "auth-service";
    
    # Give access permissions to users on the database
    GRANT ALL PRIVILEGES ON DATABASE "auth-service" TO auth;
    ```
  - Especially for `auth-service` database in the **roles** table in _PostgreSQL_ `psql`. Run the command below to go to the `auth-service` database on `psql`:
    ```sql
    \c auth-service
    ```
  - To check you are already in the auth-service database. Run the command below :
    ```sql
    SELECT * FROM roles;
    ```
  - If the **roles** table is empty, Add the following SQL query for the _authorization_ function to run according to the role you 
    want 
    in the `/model/ERole.java` file :
    ```sql
    INSERT INTO roles(name) VALUES('ROLE_USER');
    ```
    ```sql
    INSERT INTO roles(name) VALUES('ROLE_ADMIN');
    ```
  - Then, clone repository and go to the folder service. _Example_ `auth-service` :
    ```bash
    $ sudo su git clone https://github.com/d4v-id/Microservices_JWT_Authentication_Authorization_Spring_Boot_3.git
    $ cd Microservices_JWT_Authentication_Authorization_Spring_Boot_3
    $ cd auth-service
    ```
  - Make sure there is a `POM.xml` in the folder use `ls` to check and run the following command to build package the maven project 
    so it can be used later on `systemd` :
    ```bash
    $ sudo su
    $ mvn clean package
    ```
    > **[NOTE]** Make sure the "_BUILD SUCCESS_", if not try to check again on the `application.properties` file and the PostgreSQL 
    `psql` database has the correct naming including.
  - Go to _target_ folder. Every time you build a maven project, the build results will be in the _target_  folder service with the 
    name `SNAPSHOT` with the `.jar` extension :
    ```bash
    $ cd target
    ```
  - Check that SNAPSHOT.jar is already in the _target_ folder with the `ls` command _(Example: `demo-0.0.1-SNAPSHOT.jar`)_ . Then, 
    give permission to the file so that it can be executed and run. By running the command below :
    ```bash
    $ sudo su
    $ chmod +x demo-0.0.1-SNAPSHOT.jar
    $ chown -R ubuntuusername:ubuntuusername /home/ubuntuusername/auth-service
    $ chmod -R 755 /home/ubuntuusername/auth-service
    ```
  - Now, make `systemd` from the maven build that has been made so that it can run on the **Ubuntu Server**. Go to path
    `/etc/systemd/system` :
    ```bash
    $ cd /etc/systemd/system
    $ nano auth.service
    ```
    ```bash
    [Unit]
    Description=Auth Spring Boot Application
    After=syslog.target

    [Service]
    User=root
    WorkingDirectory=/home/ubuntuusername/auth-service/target/
    ExecStart=/usr/bin/java -jar /home/ubuntuusername/auth-service/target/demo-0.0.1-SNAPSHOT.jar
    SuccessExitStatus=143

    [Install]
    WantedBy=multi-user.target
    ```
    Adjust the directory in the [Service] section in `WorkingDirectory` and `ExecStart` with the service Spring Boot Application 
    project path. You can check which directory is in the target folder with the `pwd` command, then set it back on `nano 
    auth.service` file.
  - The last step, To run the `systemd` that has been created, run the command below :
    ```bash
    $ sudo su
    $ systemctl daemon-reload
    $ systemctl restart auth.service
    $ systemctl status auth.service
    ```
    Wait a few seconds to make sure the service is running and run it again `systemctl status auth.service`.
    > **[NOTE]** If status is inactive and still failed when running `systemctl status auth.service`. Try change the `[Service]`          section in `User` **_root_** with ubuntu username in nano `auth.service`
    
    > **IMPORTANT]** Do the same from the steps above for each service including the `eureka-server`. For example, in the case of 
      each ubuntu server, it can only have 2 services with different ports and eureka-server can stand alone in one ubuntu-server .
  - Final step, give access to each firewall port so that it can be accessed from an external system with command `ufw allow 
    <port>`:
    ```bash
    $ sudo su
    $ ufw allow 8761
    $ ufw allow 8099
    $ etc...
    ```
## Run Test 
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
After all the steps have been completed, try running the API server (Spring Boot Applications) externally in a browser with `http://<YOUR-IP-UBUNTU-SERVER>:<YOUR-PORT>`. _Example `http://192.168.67.101:8761`_

If you do it in **VirtualMachine** (VirtualBox) with `NAT` network type you can set the port to be accessible externally by following the steps below:
 1. Go to "Settings" on your VM.
 2. Click "Advanced" and then "Port Forwarding".
 3. Add rules with **_"Add Port Forwarding Rules"_** on right section, then set `Host Port` and `Guest Port` with port for each service in the Spring Boot Applications.
 4. Save with, _OK_

You can also test the API using [Postman](https://www.postman.com/downloads/) / [Testmace](https://testmace.com/).

## Need Help ?
Email me: `d4vbusiness@gmail.com`
