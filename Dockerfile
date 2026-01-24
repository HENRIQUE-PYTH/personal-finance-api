# Stage 1: build
FROM maven:3.9.6-eclipse-temurin-20 AS build
WORKDIR /app

# Copia o pom e o código
COPY pom.xml .
COPY src ./src

# Builda o JAR
RUN mvn clean package -DskipTests

# Stage 2: run
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia o JAR do build stage
COPY --from=build /app/target/financeiro-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
