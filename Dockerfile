# Use a imagem oficial do OpenJDK
FROM eclipse-temurin:21-jdk

# Diretório dentro do container
WORKDIR /app

# Copia apenas o JAR já buildado
COPY target/financeiro-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o Spring Boot vai usar
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]