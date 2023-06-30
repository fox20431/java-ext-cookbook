package com.hihusky.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Properties;

public class KafkaWordStream {
    public static void main(String[] args) {
        // config Kafka
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-streams");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // create Kafka Streams builder
        StreamsBuilder builder = new StreamsBuilder();

        // create input stream from topic
        KStream<String, String> inputStream = builder.stream("input-topic", Consumed.with(Serdes.String(), Serdes.String()));

        // create word count stream
        KTable<String, Long> wordCounts = inputStream
                .flatMapValues(line -> {
                    System.out.println("The string to be handle: " + line.toString());
                    return Arrays.asList(line.toLowerCase().split(" "));
                })
                .groupBy((keyIgnored, word) -> word)
                .count();

        // Which topic to write to
        wordCounts.toStream().to("output-topic", Produced.with(Serdes.String(), Serdes.Long()));

        // Creat Kafka Streams instances and start it.
        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();

        // Close Kafka Streams
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }
}
