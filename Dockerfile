# 1. Build stage
FROM gradle:8.1.1-jdk17 AS build

WORKDIR /gateway_service

# Copy the rest of the source code
COPY . .

# Build the application
RUN gradle build --no-daemon

# 2. Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /gateway_service

COPY --from=build /gateway_service/build/libs/gateway-service-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "gateway-service-0.0.1-SNAPSHOT.jar"]
