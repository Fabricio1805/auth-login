# Usando uma imagem base do OpenJDK
FROM openjdk:21.0.5-jdk-slim AS builder

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado para o contêiner
COPY target/*.jar app.jar

# Expor a porta que a aplicação vai rodar (por padrão, o Spring Boot usa a porta 8080)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
