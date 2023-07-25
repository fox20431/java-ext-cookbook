---
title: ELK
date: 2023-07-25

---

# ELK



## What is ELK

There is [a official introduce](https://www.elastic.co/what-is/elk-stack).

ELK stands for:

1. Elasticsearch: A distributed, RESTful search and analytics engine capable of storing and indexing large volumes of data in real-time.
2. Logstash: A data processing pipeline that ingests data from various sources, transforms it, and sends it to Elasticsearch for indexing and analysis.
3. Kibana:  A web-based user interface that allows users to visualize and interact with the data stored in Elasticsearch.

## Docker Compose

Create the pipeline that path is `./docker/logstash/config/logstash.conf` for `logstash` container to accept the data source:

```json
input {
    tcp{
        port => 5000
    }
}

output {
  elasticsearch {
    hosts => "elasticsearch:9200"
  }
}
```

The docker compose content is:

```yaml
version: '3.7'
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.17.11
    container_name: elasticsearch
    ports:
      - "9200:9200"
    environment:
      - discovery.type=single-node

  logstash:
    image: docker.elastic.co/logstash/logstash:7.17.11
    container_name: logstash
    ports:
      - "5000:5000"
    volumes:
      - ./docker/logstash/config:/usr/share/logstash/pipeline
    depends_on:
      - elasticsearch
    environment:
      - ELASTICSEARCH_HOST=elasticsearch
      - ELASTICSEARCH_PORT=9200

  kibana:
    image: docker.elastic.co/kibana/kibana:7.17.11
    container_name: kibana
    ports:
      - "5601:5601"
    depends_on:
      - elasticsearch
    environment:
      - ELASTICSEARCH_HOSTS=http://elasticsearch:9200

```

## Access Kibana

http://localhost:5601

Obviously, there on data in the Elasticsearch. We need to add the data firstly.

## Add the Data

There are many ways to add the data into Elasticsearch.

**command**

```shell
echo "Hi" | nc 127.0.0.1 5000
```

**java**

add the dependencies:

```java
implementation("net.logstash.logback:logstash-logback-encoder:7.4")
```

set the logback configuration `main/resources/logback.xml`:

```xml
<configuration>
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
        <destination>127.0.0.1:5000</destination>
        <encoder class="net.logstash.logback.encoder.LogstashEncoder">
            <customFields>${logback.customFields}</customFields>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="LOGSTASH"/>
    </root>
</configuration>
```

