# Imagem oficial do Java 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o JAR buildado localmente
COPY target/financeiro-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]