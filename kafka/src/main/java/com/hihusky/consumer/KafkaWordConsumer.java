package com.hihusky.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaWordConsumer {
    public static void main(String[] args) {

        // Kafka producer configuration
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
        props.put("group.id", "word-consumer-group");

        // Create the Kafka consumer
        KafkaConsumer<String, Long> consumer = new KafkaConsumer<>(props);

        // Subscribe to the output topic

        // Start consuming and print the word counts
        try (consumer) {
            consumer.subscribe(Collections.singletonList("output-topic"));
            while (true) {
                ConsumerRecords<String, Long> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, Long> record : records) {
                    System.out.println("Word: " + record.key() + ", Count: " + record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}