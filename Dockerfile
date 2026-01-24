# Use a imagem oficial do OpenJDK
FROM openjdk:21-jdk-slim

# Diretório dentro do container
WORKDIR /app

# Copia o pom.xml e os arquivos do projeto
COPY pom.xml .
COPY src ./src

# Builda o projeto usando Maven
RUN ./mvnw clean package -DskipTests

# Expõe a porta que o Spring Boot vai usar
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "target/personal-finance-api-0.0.1-SNAPSHOT.jar"]