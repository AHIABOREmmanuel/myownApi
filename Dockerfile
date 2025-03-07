# Use Maven to build application
FROM maven:3.9.8-amazoncorretto-23-al2023 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK to run the application
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/target/admin-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]