FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml mvnw mvnw.cmd ./
COPY .mvn .mvn
COPY src ./src

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "./target/coworkings-0.0.1-SNAPSHOT.jar"]
