FROM gradle:7.4-jdk17 AS build
WORKDIR /app-build
COPY --chown=gradle:gradle . .
RUN gradle clean build -x test

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app-build/build/libs/demo-tester-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
