FROM maven:3.9.2-amazoncorretto-17 AS build
WORKDIR /app
COPY ./order-service /app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY --from=build /app/target/order-service-0.0.1-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]
