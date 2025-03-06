FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/maven-sample-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
