package com.application.kafkaspringbootdemo.config;

import com.application.kafkaspringbootdemo.model.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    public Map<String,Object> configMap(){
        Map<String,Object> amap = new HashMap<>();
        amap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        amap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        amap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        amap.put(ConsumerConfig.GROUP_ID_CONFIG,"my-app");
        amap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return amap;
    }

    @Bean
    public ConsumerFactory<String,User> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(configMap(),new StringDeserializer(),new JsonDeserializer<>(User.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,User> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,User> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
