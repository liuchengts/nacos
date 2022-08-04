FROM ubuntu:16.04
MAINTAINER lc
USER root
ARG VERSION=4.7.0
ENV HOME=rocketmq-all-${VERSION}-bin-release
RUN apt-get update \
    && apt-get -y install wget unzip openjdk-8-jdk \
    && wget -O rocketmq.zip https://archive.apache.org/dist/rocketmq/${VERSION}/rocketmq-all-${VERSION}-bin-release.zip \
    && unzip rocketmq.zip \
    && rm -rf rocketmq.zip
EXPOSE 10911
EXPOSE 9876
CMD /${HOME}/bin/mqnamesrv && /${HOME}/bin/mqbroker -n localhost:9876 -D
#防止容器自动退出
#RUN touch /var/log/1.txt
#CMD "tail" "-f" "/var/log/1.txt"
# /bin/sh: 1: /rocketmq-all-4.7.0-bin-release/bin/mqnamesrv && /rocketmq-all-4.7.0-bin-release/bin/mqbroker -n localhost:9876 -D: not found
