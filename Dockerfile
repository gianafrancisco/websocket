FROM java:8-jre

COPY jetty /opt/jetty

WORKDIR /opt/jetty

EXPOSE 8080/tcp

CMD ["java", "-jar", "start.jar"]