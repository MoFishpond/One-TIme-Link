FROM openjdk:8-jdk-slim
ADD ./backend/target/one-time-link-0.0.1-SNAPSHOT.jar one-time-link.jar
CMD ["java", "-jar", "one-time-link.jar"]