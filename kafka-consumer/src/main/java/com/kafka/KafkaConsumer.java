package com.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "spring_boot_kafka_topic", groupId = "kafka-consumer")
    public void listen(@Payload String payload){
        log.info("Receive new event: "+ payload);
    }
}
