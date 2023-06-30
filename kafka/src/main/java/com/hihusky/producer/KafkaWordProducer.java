package com.hihusky.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;

import java.util.Properties;
import java.util.Scanner;

public class KafkaWordProducer {
    public static void main(String[] args) {
        // Kafka producer configuration
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create the Kafka producer

        // Read lines from the console and produce to Kafka
        try (Producer<String, String> producer = new KafkaProducer<>(props); Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text (type 'exit' to quit):");
            String line;
            while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) {
                // Produce the line to the input topic
                ProducerRecord<String, String> record = new ProducerRecord<>("input-topic", null, line);
                producer.send(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
