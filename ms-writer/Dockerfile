FROM amazoncorretto:22.0.2-alpine
LABEL authors="DannyLopez"

WORKDIR /usr/src/storyshelf
COPY . .

RUN chmod +x mvnw 
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

WORKDIR /usr/src/storyshelf/target

ENTRYPOINT ["java", "-jar", "ms-writer-0.0.1.jar"]

# WORKDIR /usr/src/storyshelf
# COPY target/ms-writer-0.0.1.jar app.jar

# EXPOSE 8080
# #EXPOSE 443

# ENTRYPOINT ["java", "-jar", "app.jar"]