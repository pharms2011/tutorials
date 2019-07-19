package com.inertia.V1;

import com.inertia.PlaceV1;
import io.confluent.kafka.serializers.KafkaAvroSerializer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaAvroProducerV1 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "10");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");

        KafkaProducer<String, PlaceV1> kafkaProducer = new KafkaProducer<String, PlaceV1>(properties);
        String topic = "place-avro";

//        CustomerV1 customer = CustomerV1.newBuilder()
//                .setFirstName("Preston")
//                .setLastName("Harms")
//                .setAge(26)
//                .setHeight(186.5f)
//                .setWeight(85.6f)
//                .setAutomatedEmail(false)
//                .build();


        PlaceV1 place = PlaceV1.newBuilder()
                .setState("Preston")
                .setCity("Harms")
                .setZip(26)
                .setLatitude(186.5f)
                .setLongitude(85.6f)
                .setIsAmerica(false)
                .build();


        ProducerRecord<String, PlaceV1> producerRecord = new ProducerRecord<String, PlaceV1>(topic, place);
        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                if(e == null){
                    System.out.println("Success!");
                    System.out.println(metadata.toString());
                }
                else{
                    e.printStackTrace();
                }
            }
        });
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
