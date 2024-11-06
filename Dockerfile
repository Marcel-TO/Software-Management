FROM openjdk:23-slim

COPY build/libs/bswe-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080/tcp

CMD ["java", "-jar", "/app.jar"]
# use docker build --tag bswe:latest . to build the image
# use docker run -p 8080:8080 bswe:latest to run the container
