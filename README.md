
# Project Title

Bus system

### Description

This is the Simple Api for Bus System.
Use HTTP client Application to test (Ex:Postman)

### Project Setup

* Create a local git repository (git init <my local repo>) and clone the project.  
* git clone <Path> Then import to intellij Idea.

### Executing program

Application

* Go to the Command Line select the project path and execute 
```
mvn spring-boot:run
```
Database

* http://localhost:8080/h2/
* Set JDBC URL 

```
jdbc:h2:mem:SpeedCoBus
```
*You can change or view user name and password by application.property file in project resources.

### Test
    Sample test JSON attached to the project
