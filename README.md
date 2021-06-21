# Welcome to the BioImageArchiveDemo wiki!

# About the application. 

This BioImageArchiveDemo is a REST application to store and retrieve metadata of images, developed using Java 1.8 and Spring Boot Framework. We'll store the image metadata object in an H2 in-memory database, and access them via Java Persistence API (JPA).

Note:
* To Access the in-memory H2 database use this [link](http://localhost:8080/h2-console). Credentials are stored in the [application.properties](https://github.com/avinash28196/BioImageArchiveDemo/blob/main/BioImageArchiveAPI/src/main/resources/application.properties) file. 
* To Access the main [method](https://github.com/avinash28196/BioImageArchiveDemo/blob/main/BioImageArchiveAPI/src/main/java/com/bioimage/archive/demo/BioImageArchiveApplication.java). 
* To Access [test ](https://github.com/avinash28196/BioImageArchiveDemo/blob/main/BioImageArchiveAPI/src/test/java/com/bioimage/archive/demo/BioImageArchiveApplicationTests.java)cases


# Installation

1. JDK 1.8 or later
2. Maven 3.2+
3. IntelliJ IDEA 
4. Docker 
5. Git CLI 


# Running the application.

1. Download and unzip the source repository for this guide, or clone it using Git:
```
git clone avinash28196/BioImageArchiveDemo
```

## Running the application using docker.

1. Open a terminal and navigate to the project folder ` cd BioImageArchiveAPI/`
2. By doing ls you should be able to see the Dockerfile
3. Or you can pull the docker image form docker hub using this command `docker pull nextbitgeek/bio-image-archive:latest` 
4. Make sure Docker is running in your OS.
5. Using the terminal and given command build a docker image `docker build -t nextbitgeek/bio-image-archive .`
```\Sending build context to Docker daemon  40.31MB
Step 1/4 : FROM openjdk:8-jdk-alpine
 ---> a3562aa0b991
Step 2/4 : ARG JAR_FILE=target/*.jar
 ---> Using cache
 ---> 5f7378ec581a
Step 3/4 : COPY ${JAR_FILE} app.jar
 ---> 5dc5707143a1
Step 4/4 : ENTRYPOINT ["java","-jar","/app.jar"]
 ---> Running in 0372da73eff2
Removing intermediate container 0372da73eff2
 ---> 618768468c08
Successfully built 618768468c08
Successfully tagged springio/bio-image-archive:latest
```
6. Once the docker image is built, using the following command run the application `docker run -p 8080:8080 springio/bio-image-archive`


## Running the application using maven. 

1. Navigate inside the project folder where ` cd BioImageArchiveAPI/` 
2. By doing ls you should be able to see the mvnw file.
3. Make sure Maven is installed in your OS.
4. Using the terminal and given command build the jar file `mvn clean install`
```
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ demo ---
[INFO] Installing to C:\Users\elfxo\.m2\repository\com\bioimage\archive\demo\0.0.1-SNAPSHOT\demo-0.0.1-SNAPSHOT.jar
[INFO] Installing  C:\Users\elfxo\.m2\repository\com\bioimage\archive\demo\0.0.1-SNAPSHOT\demo-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  22.974 s
[INFO] Finished at: 2021-06-21T11:25:40+05:30
[INFO] ------------------------------------------------------------------------

```

5. Once the build is successful run the application using the following command `mvn spring-boot:run`.


# Testing the endpoints using a Browser/Postman tool/cURL.

1. http://localhost:8080/images returns a list of accession IDs as JSON. 
![](https://github.com/avinash28196/BioImageArchiveDemo/blob/main/Images/Ids.PNG) 

***

2. http://localhost:8080/accessions/BIA-01/metadata returns all attributes associated with a particular accession as JSON.
![](https://github.com/avinash28196/BioImageArchiveDemo/blob/main/Images/Metadata.PNG)

***

3. http://localhost:8080/accessions/BIA-02/imagesize returns the total size in bytes of an accession. 
 This is the product of its dimensions and the voxel_size_bytes attribute.
![](https://github.com/avinash28196/BioImageArchiveDemo/blob/main/Images/ImageSize.PNG)


