FROM java:8
MAINTAINER Vincent ARROCENA <varrocen@gmail.com>

# See for notes https://spring.io/guides/gs/spring-boot-docker/#_containerize_it

VOLUME /tmp
ADD target/mower-1.0.0.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]