FROM openjdk:8-jre-slim

WORKDIR /var/lib

RUN apt-get update && apt-get install -y wget\
    && wget https://github.com/int128/httpstub/releases/download/1.4/httpstub.jar

EXPOSE 8080
ENTRYPOINT /usr/local/openjdk-8/bin/java -jar httpstub.jar