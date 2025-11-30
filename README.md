# api-testing

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen)
![SOAP](https://img.shields.io/badge/SOAP-1.2-lightgrey)
![Gradle](https://img.shields.io/badge/Gradle-8-green)
![JUnit](https://img.shields.io/badge/JUnit-5.9.3-purple)
![Mockito](https://img.shields.io/badge/Mockito-5.3.1-orange)
![RestAssured](https://img.shields.io/badge/RestAssured-5.4.0-blueviolet)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status: Completed](https://img.shields.io/badge/Status-Completed-brightgreen)

This repository contains two separate modules covering **SOAP and REST API testing**, including exercises and homework from the Kodilla "Automated Tester" Java course.  
Both modules were developed in **Java 21** using **IntelliJ IDEA** as part of the learning path for future QA/Test Automation Engineers.

---

## Module 1: SOAP API Testing (Spring Web Services)

This module demonstrates building a **SOAP Web Service** using **Spring Web Services (Spring-WS)**, **XML Schema Definition (XSD)**, and **JAXB-generated classes**.  
It also contains **XML exercises** and **SoapUI test projects**.

### Description

- **SOAP Web Service**
  - Endpoint: `GetCourseRequest → GetCourseResponse`
  - Based on XML Schema: `kodilla.xsd`
  - JAXB classes generated in `build/generated-sources/jaxb`
  - Spring-WS configuration: `WebServiceConfig`
  - Endpoint implementation: `CourseEndpoint`
  - In-memory repository: `CoursesRepository`

- **XML Exercises**
  - Located in `XML-exercises/`
  - Includes XSD validation exercises (`samochod.xsd`) and XML instance documents (`samochod.xml`)
  - Learning purpose: practicing XML validation and XSD design

- **SoapUI Test Projects**
  - Located in `SoapUI-tests/`
  - Full functional tests for SOAP service
  - Verifies WSDL bindings, schema validation, correct responses and SOAP faults

- **Sample Requests**
  - Folder `sample/` contains request/response XMLs for manual testing

### Project Structure
```
kodilla-soap-xml/
├── build.gradle
├── gradlew / gradlew.bat
├── LICENSE
├── README.md
├── src/main/java/com/kodilla/soap/
│ ├── SoapApplication.java
│ ├── repository/CoursesRepository.java
│ └── ws/
│ ├── CourseEndpoint.java
│ └── WebServiceConfig.java
├── src/main/resources/
│ ├── application.properties
│ └── kodilla.xsd
├── build/generated-sources/jaxb/
├── SoapUI-tests/
└── XML-exercises/
```
### Getting Started

**Requirements:**
- Java 21
- Gradle (wrapper included)
- IntelliJ IDEA

**Run the SOAP Service:**
**Linux/macOS**
```
./gradlew bootRun
```

**Windows**
```
gradlew bootRun
```

**The SOAP service will be available at:**
```bash
http://localhost:8080/ws
```

**WSDL is exposed at:**
```bash
http://localhost:8080/ws/courses.wsdl
```

**Build Commands**
```
./gradlew build
./gradlew bootJar
./gradlew clean
```
---

## Test Suites Overview
**SoapUI Functional Tests**
- Verifying SOAP request/response correctness
- Schema (XSD) validation
- Correct responses for existing course IDs
- SOAP Fault verification for invalid IDs
  
**XML Exercises**
- Practicing XML validation and XSD design

---

## Module 2: REST API Testing (Spring Boot + Postman/JSON)

This module covers **REST API development**, testing, JSON exercises, and bonus email automation with Node.js (MailHog).  
Developed in **Java 21** using **IntelliJ IDEA** as part of the learning path for future QA/Test Automation Engineers.

### Description

- **Spring Boot REST API**
  - Book-management API with endpoints:
    - `GET /books`
    - `POST /books`
    - `PUT /books/{title}`
    - `DELETE /books/{title}`
  - Architecture:
    - `BookController`
    - `BookService`
    - `BookDto`

- **REST API Testing**
  - Tools: JUnit 5, Mockito, Spring MockMvc, RestAssured
  - Tests verify HTTP status codes, JSON structure, controller-service interactions
  - Test classes:
    - `BookControllerMvcTest`
    - `BookControllerTest`
    - `BookControllerRestAssuredTest`
    - `ExternalApiRestAssuredTest`
    - `ExternalApiTestOfUpdatingAPost`

- **JSON Exercises**
  - Folder: `postman-json/Kodilla-homework/`
  - JSON structure tasks, Postman screenshots, formatting exercises

- **Postman Collections**
  - Folder: `postman-json/Postman-exercises/`
  - Includes JSONPlaceholder, HTTPBin automation, and course collections

- **MailHog Email Automation Script (Node.js)**
  - Folder: `mail-mailhog/`
  - Example script to send test emails using nodemailer

### Project Structure
```
kodilla-rest-api-postman-json/
├── build.gradle
├── gradlew / gradlew.bat
├── LICENSE
├── README.md
├── src/main/java/com/kodilla/rest/
│ ├── KodillaRestApiApplication.java
│ ├── controller/BookController.java
│ ├── domain/BookDto.java
│ └── service/BookService.java
├── src/test/java/com/kodilla/rest/controller/
│ ├── BookControllerMvcTest.java
│ ├── BookControllerRestAssuredTest.java
│ ├── BookControllerTest.java
│ ├── ExternalApiRestAssuredTest.java
│ └── ExternalApiTestOfUpdatingAPost.java
├── postman-json/
│ ├── Kodilla-homework/
│ └── Postman-exercises/
└── mail-mailhog/
```
### Getting Started

**Requirements:**
- Java 21
- Gradle (wrapper included)
- IntelliJ IDEA
- Spring Boot 3.2.5
- Node.js (for MailHog script — optional)

**Run the REST API:**
**Linux/macOS**
```
./gradlew clean build
```
**Windows**
```
gradlew clean build
```

## Dependencies (Gradle)
```
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.5'
    id 'io.spring.dependency-management' version '1.1.4'
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'

    testImplementation 'io.rest-assured:rest-assured:5.4.0'
    testImplementation 'io.rest-assured:spring-mock-mvc:5.4.0'
    testImplementation 'com.google.code.gson:gson:2.8.9'
    testImplementation 'org.springframework.boot:spring-boot-starter-test' {
        exclude group: 'io.rest-assured'
    }
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

test {
    useJUnitPlatform()
}
```
---

## Test Suites Overview

### Controller Unit Tests
- **Purpose:** Verify controller behavior without starting the full server.
- **Checks performed:**
  - Correct JSON responses
  - Returned lists match expectations
  - HTTP status codes (200, 201, 404)
  - Interaction between Controller and Service
- **Files:**
  - `BookControllerMvcTest`
  - `BookControllerTest`

### REST Integration Tests (RestAssured)
- **Purpose:** Test endpoints with real HTTP requests.
- **Checks performed:**
  - Response validation (JSON structure, content)
  - Correct behavior of endpoints (GET, POST, PUT, DELETE)
  - Integration with Spring context
- **File:**
  - `BookControllerRestAssuredTest`

### External API Tests
- **Purpose:** Verify handling of external APIs using RestAssured.
- **Checks performed:**
  - GET requests to public APIs
  - PUT requests (updating posts)
  - JSON structure and content validation
- **Files:**
  - `ExternalApiRestAssuredTest`
  - `ExternalApiTestOfUpdatingAPost`

**All tests use:**
- JUnit 5 (Jupiter)
- Spring MockMvc (for unit tests)
- RestAssured (for integration and external API tests)
- Mocking with Mockito where needed

**Goal:** Ensure full coverage of REST API behavior, both internal and external, including correct HTTP responses and JSON payloads.

---

## Authors

Created by:

**Joanna Kamińska**  
GitHub: [https://github.com/joanna-kaminska-qa](https://github.com/joanna-kaminska-qa)

---

## Version History

- **0.2** – README added, improved structure  
- **0.1** – Initial upload  

---

## License

This project is licensed under the MIT License.  
See the LICENSE file for details.

---

## Acknowledgments

- Kodilla Automated Tester Java course
- Spring Web Services documentation
- JAXB (Jakarta XML Binding)
- SoapUI
- XML & XSD W3C documentation
- Spring Boot documentation
- RestAssured documentation
- JSONPlaceholder API
- Postman Learning Center
- MailHog project
