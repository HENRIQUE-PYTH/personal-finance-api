# Imagem do Maven + JDK 21
FROM maven:3.9.3-eclipse-temurin-21 AS build

WORKDIR /app

# Copia os arquivos do projeto
COPY pom.xml .
COPY src ./src

# Build do JAR
RUN mvn clean package -DskipTests

# Segunda fase: rodar o JAR
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o JAR da fase de build
COPY --from=build /app/target/financeiro-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]