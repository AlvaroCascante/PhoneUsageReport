# Phone Usage Report

This project contains some endpoint to read info form csv files.  Also a PDF report is going to be generate from the files

## Create new java project using [Spring Initializr](https://start.spring.io/)

Details:
* Maven Project
* Spring Boot 2.5.4
* Packing Jar
* Java 8
* Dependencies
    * Lombok
    * Spring Web

## Used Dependencies

* Open CSV: To read csv files and convert them in Java Objects
```
<dependency>
    <groupId>com.opencsv</groupId>
    <artifactId>opencsv</artifactId>
    <version>5.5.1</version>
</dependency>
```

## Project Structure
* Model: Business Objects
* Repository: Objects in change of get the data (DAO's)
* Service: API's endpoints
* Util: Utils and common functions

## Resources
CSV Files
* CellPhone.csv
* CellPhoneUsageByMonth.csv

## Notes
* The CellPhoneUsageByMonth.csv have a typo on the first column "emplyeeId", this is solved using the CsvBindByName 
  annotation on the model class
  
## Test Using Postman
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5067618-b0027d85-97e2-463d-814f-d59cbc91c9cc?action=collection%2Ffork&collection-url=entityId%3D5067618-b0027d85-97e2-463d-814f-d59cbc91c9cc%26entityType%3Dcollection%26workspaceId%3D2b71f34f-6219-4f97-b31f-f2a398de0033#?env%5BLocal%5D=W3sia2V5IjoiaG9zdCIsInZhbHVlIjoibG9jYWxob3N0IiwiZW5hYmxlZCI6dHJ1ZX0seyJrZXkiOiJwb3J0IiwidmFsdWUiOiI4MDgwIiwiZW5hYmxlZCI6dHJ1ZX1d)