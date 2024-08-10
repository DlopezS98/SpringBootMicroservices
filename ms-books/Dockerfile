FROM amazoncorretto:22.0.2-alpine
LABEL authors="DannyLopez"

# RUN ./mvnw install

WORKDIR /usr/src/storyshelf
COPY target/ms-books-0.0.1.jar app.jar

EXPOSE 8080
#EXPOSE 443

ENTRYPOINT ["java", "-jar", "app.jar"]
