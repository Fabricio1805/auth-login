FROM openjdk:21.0.5-jdk-alpine

WORKDIR "/home"

COPY . .

RUN apk add maven

WORKDIR "/home/auth-login"

RUN mvn clean package

EXPOSE 8080

CMD [ "java", "-jar",  "/home/auth-login/target/auth-login-0.0.1-SNAPSHOT.jar"]