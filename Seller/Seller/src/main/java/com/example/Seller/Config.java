package com.example.Seller;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {
    
    @Bean
    public NewTopic creatofferTopic(){
        return TopicBuilder
        .name("offer")
        .partitions(5)
        .replicas(1)
        .build();
    }
    @Bean
    public NewTopic creatorderTopic(){
        return TopicBuilder
        .name("odd")
        .partitions(5)
        .replicas(1)
        .build();
    }
}
