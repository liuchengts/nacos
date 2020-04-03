FROM ubuntu:16.04
MAINTAINER lc
USER root
WORKDIR rocketmq
ARG VERSION=4.7.0
ARG HOME=rocketmq-all-${VERSION}-bin-release
RUN apt-get update \
    && apt-get -y install wget unzip openjdk-8-jdk \
    && wget -O /tmp/rocketmq.zip https://mirror.bit.edu.cn/apache/rocketmq/${VERSION}/rocketmq-all-${VERSION}-bin-release.zip \
    && echo ${WORKDIR} \
    && unzip -d /${WORKDIR} /tmp/rocketmq.zip
#    && rm -rf /tmp/rocketmq.zip
EXPOSE 10911
#ENTRYPOINT [ "sh", "bin/mqnamesrv" ]
#ENTRYPOINT [ "sh", "bin/mqbroker -n localhost:9876" ]
#防止容器自动退出
RUN touch /var/log/1.txt
CMD "tail" "-f" "/var/log/1.txt"