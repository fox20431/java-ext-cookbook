FROM openjdk:17-bullseye

WORKDIR /opt

ENV KAFKA_VERSION=3.5.0
ENV SCALA_VERSION=2.13

ENV KRAFT_CONTAINER_HOST_NAME=default_host
ENV KRAFT_CREATE_TOPICS=default_topics
ENV KRAFT_PARTITIONS_PER_TOPIC=default_partitions

RUN apt update && \
    apt install -y --no-install-recommends wget

RUN wget https://downloads.apache.org/kafka/${KAFKA_VERSION}/kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz && \
    tar -xzf kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz -C /opt && \
    rm kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz

WORKDIR /opt/kafka_${SCALA_VERSION}-${KAFKA_VERSION}

#COPY ./config/kraft/server.properties ./config/kraft/server.properties

EXPOSE 9092 9093

RUN KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)" && \
    bin/kafka-storage.sh format -t $KAFKA_CLUSTER_ID -c config/kraft/server.properties

CMD ["bin/kafka-server-start.sh", "config/kraft/server.properties"]
