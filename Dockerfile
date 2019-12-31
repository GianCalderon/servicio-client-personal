FROM openjdk:8
VOLUME /tmp
EXPOSE 8001
ADD ./target/springboot-servicio-clientPersona-0.0.1-SNAPSHOT.jar client-personal.jar
ENTRYPOINT ["java","-jar","/client-personal.jar"]
