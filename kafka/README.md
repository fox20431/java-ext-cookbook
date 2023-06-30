## Get Start

`docker-compose.yaml` will start a Kafka server with the default configuration. The server will be accessible at localhost:9092. The server will be accessible at localhost:9092.

Add the necessary topics to make the program run successfully.

**for Windows**

```shell
.\kafka-topics.bat --create --topic input-topic --bootstrap-server localhost:9092
.\kafka-topics.bat --create --topic output-topic --bootstrap-server localhost:9092
```

**For Linux**

```shell
.\kafka-topics.sh --create --topic input-topic --bootstrap-server localhost:9092
.\kafka-topics.sh --create --topic output-topic --bootstrap-server localhost:9092
```

Next, run `KafkaWordProducer`, `KafkaWordStream`, and `KafkaWordConsumer`.

`KafkaWordProducer` will produce the content in `input-topic`;

`KafkaWordStream` will handle `input-topic` content transmit the result to `output-topic`;

`KafkaWordConsumer` will resolve the `output-topic` content.

You can input string in the console of `KafkaWordProducer`.