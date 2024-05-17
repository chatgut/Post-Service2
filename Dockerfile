# Build stage
FROM maven:3.9.6-eclipse-temurin-22-alpine AS build
COPY src /app/src/
COPY pom.xml /app/
WORKDIR /app
RUN mvn clean package

# Run stage
FROM eclipse-temurin:22-jre-alpine
COPY --from=build /app/target/PostService2-0.0.1-SNAPSHOT.jar /app/PostService2-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/PostService2-0.0.1-SNAPSHOT.jar"]
