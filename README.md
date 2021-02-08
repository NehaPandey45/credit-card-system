# credit-card-system
This system will accept credit card related data, will apply luhn validation and create the account details of user. It also provides get all customers Data API that is helpful to retrieve the data.

This is a spring-boot application that uses in-memory Database H2 to store and retrieve the Data.

Pre-requisites
1) maven
2) Java 8 or higher
3) docker
4) IDE like IntelliJ/Eclipse

Run the Project
#Option 1:

1) clone the repository on your system
2) run mvn clean: install to install all the dependencies
3) Go to Application.java and start the application.
4) In order to run through maven use mvn spring-boot:run
5) In order to check the application is up and running click on /actuator/health API. You can use browser or postman or below curl command (for example: on localhost) hit the below command:
   curl --location --request GET 'http://localhost:8080/actuator/health'


#Option 2:

This application image "creditcard-jib-image" has been published to docker hub at below repo:
https://hub.docker.com/repository/docker/npand45/creditcard-jib-image

In order to access and install this image on your local, please use below docker command:

1) docker run -it -p 8080:8080 npand45/creditcard-jib-image
2) Once the image is installed, do "docker ps" on your terminal to check if the image is up and running 
3) Check the health endpoint using below URL;
   GET 'http://<hostname>:8080/actuator/health
  

#In order to access swagger documentation please run below endpoint on your browser:
http://<hostname>:8080/swagger-ui.html
   
Please refer test cases for sample data to be passed in POST request.

On localhost, you can use:
http://localhost:8080/swagger-ui.html

Further, this application provides additional functionalities as mentioned below:

#Prometheus 

In order to check the Prometheus graph and metrics please follow below steps:

1) Install prometheus image on your local using below command:
docker pull prom/prometheus

For further documentation please refer below link:
https://prometheus.io/docs/prometheus/latest/installation/

In order to read the prometheus.yml file given in this project and in order to link prometheus with this application, please use below command:
docker run \
    -p 9090:9090 \
    -v <path of your workspace>/credit-card-system/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus
  
  2) Once the image is downloaded and up and running, you can access Prometheus UI using below link on your localhost:
  http://localhost:9090/graph
  http://localhost:9090/status
  
  Please replace <localhost> with server IP, in order to run on Server.
  
 #To Format the Code we have used "fmt-maven-plugin". 
 
 #You can also generate the code coverage report for which we have used "Jacoco plugin"
 
 1) In order to generate Jacoco report for test coverage, please use below command:
     mvn clean verify
     
 2) The Jacoco reports will be available in below path:
    target -> site -> jacoco -> index.html


