FROM openjdk:22-ea-21-jdk
WORKDIR /app
COPY target/production.jar /app/
EXPOSE 8080
CMD ["java", "-jar", "production.jar"]
