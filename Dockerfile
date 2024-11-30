FROM openjdk:21-jdk-slim AS builder

WORKDIR /labriel

COPY /src ./src
COPY /gradle ./gradle

COPY gradlew .
COPY build.gradle.kts .
COPY gradle.properties .
COPY settings.gradle.kts .

RUN ./gradlew shadowJar --no-daemon

FROM openjdk:21-jdk-slim

COPY --from=builder /labriel/build/libs/labriel.jar /labriel.jar

ENTRYPOINT ["java", "-jar", "labriel.jar"]
