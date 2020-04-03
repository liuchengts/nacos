FROM styletang/rocketmq-console-ng
MAINTAINER lc
USER root
COPY config /tmp
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Drocketmq.config.loginRequired=true -Drocketmq.config.dataPath=/tmp","-jar","/app.jar"]
