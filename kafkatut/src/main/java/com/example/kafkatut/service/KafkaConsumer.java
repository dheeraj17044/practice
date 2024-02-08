package com.example.kafkatut.service;

import com.example.kafkatut.dto.MessageRequestDto;
import com.example.kafkatut.dto.A;
import com.example.kafkatut.dto.B;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "string-topic", groupId = "string-group")
    public void consumeMessage(String message) {
        log.info("Received message: ----> {}", message);
    }

//    @KafkaListener(topics = "json-topic", groupId = "json-group")
//    public void consumeJsonMessage(String message) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        MessageRequestDto dto  = objectMapper.readValue(message, MessageRequestDto.class);
//
//        log.info("Received json object: ----> {}", dto);
//    }
//
//    @KafkaListener(topics = "A-topic", groupId = "A-group")
//    public void consumeJsonMessage_A(String message) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        A dto  = objectMapper.readValue(message, A.class);
//
//        log.info("Received json object: ----> {}", dto);
//    }
//
//    @KafkaListener(topics = "B-topic", groupId = "B-group")
//    public void consumeJsonMessage_B(String message) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        B dto  = objectMapper.readValue(message, B.class);
//
//        log.info("Received json object: ----> {}", dto);
//    }

    @KafkaListener(topics = "multi-topic", groupId = "multi-group")
    public void consumeJsonMessage(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(message);

        // Extract the type field
        String objectType = jsonNode.get("type").asText();

        switch (objectType) {
            case "MessageRequestDto":
                MessageRequestDto dto = objectMapper.readValue(message, MessageRequestDto.class);
                log.info("Received MessageRequestDto: ----> {}", dto);
                break;

            case "A":
                A aObject = objectMapper.readValue(message, A.class);
                log.info("Received A: ----> {}", aObject);
                break;

            case "B":
                B bObject = objectMapper.readValue(message, B.class);
                log.info("Received B: ----> {}", bObject);
                break;

            default:
                log.warn("Unknown object type: {}", objectType);
                break;
        }
    }

}

