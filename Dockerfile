FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} task-tracker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "task-tracker.jar"]