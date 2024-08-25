# FROM maven:3.9.7-amazoncorretto-22.0.2-alpine AS build
FROM maven:3.9.7-eclipse-temurin-22-alpine AS build

# WORKDIR /usr/src/storyshelf
COPY . /usr/src/storyshelf
RUN mvn -f /usr/src/storyshelf/pom.xml clean package -DskipTests

FROM amazoncorretto:22.0.2-alpine
COPY --from=build /usr/src/storyshelf/target/ms-writer-0.0.1.jar /usr/app/storyshelf-writer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/app/storyshelf-writer.jar"]