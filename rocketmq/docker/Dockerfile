FROM ubuntu:16.04
MAINTAINER lc
USER root
WORKDIR rocketmq
#防止容器自动退出
RUN touch /var/log/1.txt
CMD "tail" "-f" "/var/log/1.txt"