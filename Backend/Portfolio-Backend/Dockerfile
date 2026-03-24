# Use Maven to build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a lightweight JRE to run the app
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose the port your app runs on (update if not 8085)
EXPOSE 8085

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]