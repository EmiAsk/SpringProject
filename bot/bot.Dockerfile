FROM openjdk:17

COPY target/bot-1.0-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]