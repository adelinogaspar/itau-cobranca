FROM  maven:3.6.3-adoptopenjdk-11-openj9 as build
WORKDIR /app

COPY pom.xml /app
ARG EXTRA_PROPERTIES=""
RUN mvn dependency:go-offline
RUN mvn dependency:resolve

COPY src /app/src
RUN mvn clean package


FROM openjdk:14-jdk
ARG APP_NAME=cobrancaNotificaEmail
COPY --from=build /app/target/${APP_NAME}.jar /app/
COPY docker/entrypoint.sh /app/entrypoint.sh

EXPOSE 8080

#ENTRYPOINT ["java","-Dspring.profiles.active=DEV","-jar","/app/meli-orderbook.jar"]
CMD ["/bin/sh", "/app/entrypoint.sh"]