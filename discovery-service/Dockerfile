FROM maven:3.5-jdk-8-alpine AS build

WORKDIR /discovery-service

COPY pom.xml /discovery-service/pom.xml
#RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
COPY ["src/main", "/discovery-service/src/main"]
RUN ["mvn", "clean", "package"]

FROM openjdk:8-jre-alpine

COPY --from=build /discovery-service/target/discovery-service.jar /
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/hello-service.jar"]
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/discovery-service.jar"]
#CMD ["web", "java -Djava.security.egd=file:/dev/./urandom -jar /hello-service.jar $JAVA_OPTS"]

EXPOSE 8761
# set a health check
#HEALTHCHECK --interval=5s \
#            --timeout=5s \
#            CMD curl -f http://127.0.0.1:8888 || exit 1