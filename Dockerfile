FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/auth-login-1.0.0.jar auth-login-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "auth-login-1.0.0.jar"]