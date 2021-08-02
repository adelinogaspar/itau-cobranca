FROM  maven:3.6.3-adoptopenjdk-11-openj9 as build
COPY src /app/src

COPY pom.xml /app
ARG EXTRA_PROPERTIES=""
RUN mvn -f /app/pom.xml clean package

FROM openjdk:14-jdk
ARG APP_NAME=meli-foobar
COPY --from=build /app/docker/${APP_NAME}.jar /app/
COPY docker/entrypoint.sh /app/entrypoint.sh

EXPOSE 8080

#ENTRYPOINT ["java","-Dspring.profiles.active=DEV","-jar","/app/meli-orderbook.jar"]
CMD ["/bin/sh", "/app/entrypoint.sh"]