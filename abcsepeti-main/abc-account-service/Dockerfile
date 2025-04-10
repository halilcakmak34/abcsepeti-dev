FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE

ENV CONSUL_HOST 10.10.34.14
ENV CONSUL_IN_PORT 8500
ENV POSTGRES_FULL_URL jdbc:postgresql://10.10.34.17:5432/abcdev
ENV POSTGRES_URL http://10.10.34.17:5432
ENV POSTGRES_HOST 10.10.34.17
ENV POSTGRES_PORT 5432
ENV ZIPKIN_FULL_URL http://10.10.34.21:9411
ENV INFLUXDB_FULL_URL http://10.10.34.15:8086
ENV SPRING_PROFILES_ACTIVE postgresql
ENV SERVER_PORT 4001

COPY target/abc-account-service-1.0.0.jar account-service.jar

#Using Dokerize to check whether db is up, if it is then start this service.
COPY dockerize dockerize

CMD ./dockerize java -Djava.security.egd=file:/dev/./urandom -jar /account-service.jar