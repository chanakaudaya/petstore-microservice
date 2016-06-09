## Create a new MSF4J starting with the Maven msf4j-microservice archetype

(1) 
```
mvn archetype:generate -DarchetypeGroupId=org.wso2.msf4j -DarchetypeArtifactId=msf4j-microservice -DarchetypeVersion=1.0.0 -DgroupId=org.example.msf4j -DartifactId=petstore -Dversion=1.0.0-SNAPSHOT -Dpackage=org.example.msf4j.petstore  -DserviceClass=PetService
```
(2) Create an IDE project;
``` 
mvn eclipse:eclipse
``` 
or 
```
mvn idea:idea
```
(3) Change the context from /service to /pet

(4) curl -v http://localhost:8080/pet


curl -v -X POST -d '{"id":"pet002","ageMonths":15,"details":"FirstPet","price":120.0,"dateAdded":1465389931656,"image":"image-002.jpg"}' -H "Content-Type:application/json"  http://localhost:8080/pet
