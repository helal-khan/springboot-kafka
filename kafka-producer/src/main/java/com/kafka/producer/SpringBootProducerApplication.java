package com.kafka.producer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class SpringBootProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }

    @Bean
    public ApplicationRunner runner(KafkaProducer kafkaProducer) {
        return args -> {
            while (true) {
                kafkaProducer.sendMessage("spring_boot_kafka_topic", "Hello: " + UUID.randomUUID());
                Thread.sleep(1000L);
            }
        };
    }
}
