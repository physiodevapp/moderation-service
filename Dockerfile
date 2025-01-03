FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/moderation-service-0.0.1-SNAPSHOT.jar /app/moderation-service.jar

EXPOSE 8080

CMD ["java", "-jar", "moderation-service.jar"]

