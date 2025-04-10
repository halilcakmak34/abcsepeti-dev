FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

ENV CONSUL_HOST 10.10.34.14
ENV CONSUL_IN_PORT 8500
ENV POSTGRES_HOST http://10.10.34.17:5432
ENV ZIPKIN_FULL_URL http://10.10.34.21:9411
ENV INFLUXDB_FULL_URL http://10.10.34.15:8086
ENV SPRING_PROFILES_ACTIVE postgresql
ENV SERVER_PORT 8765
COPY target/abc-gateway-server-1.0.0.jar gateway-server.jar

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-server.jar"]

#Using Dokerize to check whether db is up, if it is then start this service.
COPY dockerize dockerize

CMD ./dockerize java  -Djava.security.egd=file:/dev/./urandom -jar /gateway-server.jar

