FROM openjdk:8-jre-slim
VOLUME /tmp
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE prod
ARG JAR_FILE
COPY ${JAR_FILE} /var/app/epion-t3-targetapp-rest.jar
ENTRYPOINT ["java", "-jar", "/var/app/epion-t3-targetapp-rest.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]
