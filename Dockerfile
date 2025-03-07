# Use a base image with Java 23
FROM openjdk:23-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Use OpenJDK to run the application
FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/target/splitify-backend-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]ar", "app.jar" ]