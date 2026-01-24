# =========================
# Stage 1: Build do JAR
# =========================
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/financeiro-0.0.1-SNAPSHOT.jar app.jar

CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
