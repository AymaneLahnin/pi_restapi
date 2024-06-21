FROM  openjdk:17-jdk-alpine
LABEL authors="Aymane Lahnin"
EXPOSE 8080

COPY target/moviesBackend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
