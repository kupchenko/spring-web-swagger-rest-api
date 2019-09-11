################################################
#             JAVA MICROSERVICE IMAGE          #
################################################
FROM openjdk:8

COPY target/spring-swagger-rest-api.jar /app/service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "service.jar"]
