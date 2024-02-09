FROM openjdk:17

ADD target/LoginWeb-0.0.1-SNAPSHOT.jar /app/

WORKDIR /app

ENTRYPOINT ["java","-jar LoginWeb-0.0.1-SNAPSHOT.jar"]