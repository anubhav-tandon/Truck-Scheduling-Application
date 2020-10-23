package com.application.kafkaspringbootdemo.service;

import com.application.kafkaspringbootdemo.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AppListener {


    @KafkaListener(topics = "springboot-kafka",groupId = "my-app", containerFactory = "kafkaListenerContainerFactory")
    public void listenToKafkaTopic(User user){
        System.out.println("Message received from Kafka topic is  ::::  ");
        System.out.println(user);
    }
}
