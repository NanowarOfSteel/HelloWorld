# Step 1: Use an official Maven image to build the project
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the project files into the container
COPY . .

# Step 4: Build the project using Maven
RUN mvn clean package

# Step 5: Use a lightweight JDK image to run the application
FROM openjdk:17-jdk-slim

# Step 6: Set the working directory
WORKDIR /app

# Step 7: Copy the built JAR file from the Maven build stage
COPY --from=build /app/target/*.jar app.jar

# Step 8: Set the command to run the application
CMD ["java", "-jar", "app.jar"]
