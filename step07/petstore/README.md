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

Update pet
curl -v -X PUT -d '{"id":"pet002","ageMonths":15,"details":"FirstPet-updated","price":120.0,"dateAdded":1465389931656,"image":"image-002.jpg"}' -H "Content-Type:application/json"  http://localhost:8080/pet

Delete the pet
curl -v -X DELETE http://localhost:8080/pet/pet002



Here we use WSO2 Identity server as the authorization server.

1) Download and unzip the latest version of the WSO2 Identity Server from http://wso2.com/products/identity-server.

2) Copy resources/introspect.war to wso2is-5.1.0/repository/deployment/server/webapps directory.

3) Create a Service Provider by following the instructions in the this document
 [https://docs.wso2.com/display/IS510/Configuring+a+Service+Provider]
 (https://docs.wso2.com/display/IS510/Configuring+a+Service+Provider)

4) Then under the "configure inbound authentication" section, create an OAuth2 application which represents your
client application. Instructions are available in the above documentation link. 

For "Callback Url", provide "https://localhost:9443/oauth2/token"

Once the OAuth2 application is created,
you will get a pair of keys called OAuth Client Key and OAuth Client Secret.

5) Execute following command from the installation directory to start the server.  e.g. /home/user/wso2is-5.1.0/


 ```
 sh bin/wso2server.sh
 ```

6) Execute the following command using OAuth Client Key and OAuth Client Secret.
This command should return with a JSON response which contains the access token.

 ```
 `
 ```

 ```
 {"access_token":"ded91567bbc7573d5c47e77e700f62ac","token_type":"Bearer","expires_in":3600}
 ```

Note the access_token value.




