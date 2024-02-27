FROM gradle:8.2-jdk17 AS builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /home/gradle/src/build/libs /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/test-containers-0.0.1-SNAPSHOT.jar"]