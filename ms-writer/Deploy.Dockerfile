FROM amazoncorretto:22.0.2-alpine
WORKDIR /usr/src/storyshelf
COPY . .

RUN chmod +x mvnw 
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

WORKDIR /usr/src/storyshelf/target

ENTRYPOINT ["java", "-jar", "ms-writer-0.0.1.jar"]