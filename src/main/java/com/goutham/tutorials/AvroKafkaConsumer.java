package com.goutham.tutorials;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class AvroKafkaConsumer {

    public static void main(String[] args) {
        String bootstrapServers = "localhost:9092";
        String schemaRegistryUrl = "http://127.0.0.1:8085";
        String topic = "customer";
        String groupId = "some-group-id";

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // Start reading at the earliest offset
        properties.setProperty("schema.registry.url", schemaRegistryUrl);

        try (KafkaConsumer<String, GenericRecord> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Collections.singletonList(topic));

            while (true) {
                for (ConsumerRecord<String, GenericRecord> record : consumer.poll(Duration.ofMillis(100))) {
                    System.out.printf("Key: %s, Value: %s%n", record.key(), record.value());
                }
            }
        }
    }
}
