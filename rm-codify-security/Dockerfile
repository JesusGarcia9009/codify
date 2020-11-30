FROM adoptopenjdk/openjdk11:alpine-jre

#ANTES DE COMPIAR DEBE SER EJECUTADO EN EL RUNNER.
ARG JAR_FILE=target/rm-codify-security-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app

COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]