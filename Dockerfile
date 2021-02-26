FROM openjdk:8
EXPOSE 8080
ADD target/creditcardsystem-0.0.1-SNAPSHOT.jar creditcardsystem-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java", "-jar", "/creditcardsystem-0.0.1-SNAPSHOT.jar"]