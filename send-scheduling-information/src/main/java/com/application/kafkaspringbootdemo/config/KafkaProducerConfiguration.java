package com.application.kafkaspringbootdemo.config;

import com.application.kafkaspringbootdemo.model.AppointmentScheduling;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Value("${kafka.bootstrap-server}")
    public String bootstrapServerUrl;

    public Map<String,Object> amap(){
        Map<String,Object> amap = new HashMap<>();
        amap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServerUrl);
        amap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        amap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        return amap;
    }

    @Bean
    public ProducerFactory<String, AppointmentScheduling> producerFactory(){
        return new DefaultKafkaProducerFactory<>(amap());
    }

    @Bean
    public KafkaTemplate<String,AppointmentScheduling> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
