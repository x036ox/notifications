FROM openjdk:21-jdk-slim
WORKDIR /notifications
COPY /target/notifications-1.0.0.jar /notifications
CMD ["java", "-jar", "notifications-1.0.0.jar"]