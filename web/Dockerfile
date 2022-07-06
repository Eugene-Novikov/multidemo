FROM openjdk:11-jre-slim

WORKDIR /app

COPY ./target/web-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /app/app.jar
