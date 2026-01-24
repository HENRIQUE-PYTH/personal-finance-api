# =========================
# Stage 1: Build do JAR
# =========================
FROM maven:3.9.6-eclipse-temurin-20 AS build

WORKDIR /app

# Copia arquivos do projeto
COPY pom.xml .
COPY src ./src

# Builda o JAR sem testes
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Rodar a aplicação
# =========================
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o JAR gerado no build stage
COPY --from=build /app/target/financeiro-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta do Spring Boot (Render usa variável PORT)
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
