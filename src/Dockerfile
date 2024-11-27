# Usando uma imagem base do OpenJDK
FROM openjdk:21-jdk-alpine

WORKDIR "/home"

COPY . .

RUN apk add maven

WORKDIR "/home/demo"

RUN mvn clean package

EXPOSE 8080

CMD [ "java", "-jar",  "/home/demo/target/demo-0.0.1-SNAPSHOT.jar"]
