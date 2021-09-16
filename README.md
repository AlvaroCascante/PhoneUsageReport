# Phone Usage Report

In order to generate the pdf report use this URL [PDF Report](localhost:8080/pdfReport) localhost:8080/pdfReport

This project also contains some endpoints used just to verify that the reading from the CSV files 
works fine.

## Steps to create the project
I follow the next steps in order to create the project

### Create new java project using [Spring Initializr](https://start.spring.io/)

Details:
* Maven Project
* Spring Boot 2.5.4
* Packing Jar
* Java 8
* Dependencies
    * Lombok
    * Spring Web

### Used Dependencies

* Open CSV: To read csv files and convert them in Java Objects
```
<dependency>
    <groupId>com.opencsv</groupId>
    <artifactId>opencsv</artifactId>
    <version>5.5.1</version>
</dependency>
```
* Jasper Reports: Generate PDF file
```
<dependency>
    <groupId>net.sf.jasperreports</groupId>
    <artifactId>jasperreports</artifactId>
    <version>6.17.0</version>
</dependency>
<dependency>
    <groupId>net.sf.jasperreports</groupId>
    <artifactId>jasperreports-functions</artifactId>
    <version>6.16.0</version>
</dependency>
```
### Project Structure
* Model: Business Objects
* Repository: Objects in change of get the data (DAO's)
* Service: API's endpoints
* Util: Utils and common functions

### Resources
CSV Files
* CellPhone.csv
* CellPhoneUsageByMonth.csv
* CellPhoneAdapter.xml: Adapter to read from CSV file
* CellPhoneUsageAdapter.xml: Adapter to read from CSV file
* MainReport.jrxml: Main PDF report
* SubReport.jrxml: Sub report for details

## Notes
* The CellPhoneUsageByMonth.csv have a typo on the first column "emplyeeId", this is solved using the CsvBindByName 
  annotation on the model class.
* I'm not clear in how the report should be display for the group by month because of the different years data, 
  right now is just displaying all data order by date group by employee, 
  but extra reports and adjustments could be done according to the client requirements.
* In the last commit I added a group by month/year also
## Test Using Postman
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5067618-b0027d85-97e2-463d-814f-d59cbc91c9cc?action=collection%2Ffork&collection-url=entityId%3D5067618-b0027d85-97e2-463d-814f-d59cbc91c9cc%26entityType%3Dcollection%26workspaceId%3D2b71f34f-6219-4f97-b31f-f2a398de0033#?env%5BLocal%5D=W3sia2V5IjoiaG9zdCIsInZhbHVlIjoibG9jYWxob3N0IiwiZW5hYmxlZCI6dHJ1ZX0seyJrZXkiOiJwb3J0IiwidmFsdWUiOiI4MDgwIiwiZW5hYmxlZCI6dHJ1ZX1d)
