# Use a base image with JDK to run the Spring Boot app
FROM amazoncorretto:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the host machine to the container
COPY target/spring-security-basic-1.0.0.jar spring-security-docker.jar

# Expose the port that the application will run on
EXPOSE 8090

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar","spring-security-docker.jar"]