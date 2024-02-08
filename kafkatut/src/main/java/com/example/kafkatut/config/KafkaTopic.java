package com.example.kafkatut.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

//    @Bean
//    public NewTopic createStringTopic(){
//        return TopicBuilder
//                .name("string-topic")
//                .build();
//    }

//    @Bean
//    public NewTopic createJsonTopic(){
//        return TopicBuilder
//                .name("json-topic")
//                .build();
//    }

    @Bean
    public NewTopic createATopic(){
        return TopicBuilder
                .name("A-topic")
                .build();
    }

    @Bean
    public NewTopic createBTopic(){
        return TopicBuilder
                .name("B-topic")
                .build();
    }

    @Bean
    public NewTopic createMultiTopic(){
        return TopicBuilder
                .name("multi-topic")
                .build();
    }
}