package com.goutham.tutorials;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import com.goutham.Customer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class KafkaAvroProducer {
    
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "127.0.0.1:9092");
        props.setProperty("acks", "1");
        props.setProperty("retries", "10");

        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());

        props.setProperty("schema.registry.url", "http://127.0.0.1:8085");

         KafkaProducer<String, Customer> kafkaProducer = new KafkaProducer<String,Customer>(props);

        String topic ="customer";
        Customer customer = Customer.newBuilder()
                            .setAge(14)
                            .setAutoEmail(false)
                            .setWeight(12.9f)
                            .setFirstName("test")
                            .setLastName("teser")
                            .setHeight(1.6f)
                            .build();

        ProducerRecord<String,Customer> producerRecord = new ProducerRecord<String,Customer>(topic, customer);
        
        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata rmData, Exception ex){
                if(ex ==null){
                    System.out.println("Published successfull");
                    System.out.println(rmData.toString());
                }else{
                    ex.printStackTrace();
                }
            }
        });

        kafkaProducer.flush();
        kafkaProducer.close();

    }
}
