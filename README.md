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


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


    /**
     * Removing buses with their registration (eg: ABC-123)
     *
     * @param  delta   the amount the value should be incremented by
     * @return         the post-incremented value
     */
