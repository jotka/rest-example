Example Spring Boot REST Service

Quick start
-----------
1. `mvn package`
2. `java -jar target/example-spring-boot-rest-1.0-SNAPSHOT.jar`



curl -H "Content-Type: application/json" -X POST -d '{"id":"1","author":"Krochmalski", "title":"IDEA"}'  http://localhost:8080/books

