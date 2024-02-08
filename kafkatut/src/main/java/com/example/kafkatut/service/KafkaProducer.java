package com.example.kafkatut.service;

import com.example.kafkatut.dto.A;
import com.example.kafkatut.dto.B;
import com.example.kafkatut.dto.MessageRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    public void sendMessage(String message) {
        kafkaTemplate.send("string-topic", message);
    }

//    public void sendObject(MessageRequestDto requestDto){
//        log.info("json object to be produced by kafka producer --> {}",requestDto);
//        try{
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            kafkaTemplate.send("json-topic", objectMapper.writeValueAsString(requestDto));
//        }catch (Exception e){
//            log.error("exception while producing json object ::: {}",ExceptionUtils.getFullStackTrace(e));
//        }
//    }
//
//    public void send_A(A object){
//        log.info("json object to be produced by kafka producer --> {}",object);
//        try{
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            kafkaTemplate.send("A-topic", objectMapper.writeValueAsString(object));
//        }catch (Exception e){
//            log.error("exception while producing json object ::: {}",ExceptionUtils.getFullStackTrace(e));
//        }
//    }
//
//    public void send_B(B object){
//        log.info("json object to be produced by kafka producer --> {}",object);
//        try{
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            kafkaTemplate.send("B-topic", objectMapper.writeValueAsString(object));
//        }catch (Exception e){
//            log.error("exception while producing json object ::: {}",ExceptionUtils.getFullStackTrace(e));
//        }
//    }


    public void sendObject(Object object) {
        log.info("json object to be produced by kafka producer --> {}", object);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Add a type field to the JSON payload
            String jsonPayload = objectMapper.writeValueAsString(object);
            kafkaTemplate.send("multi-topic", jsonPayload);
        } catch (Exception e) {
            log.error("exception while producing json object ::: {}", ExceptionUtils.getFullStackTrace(e));
        }
    }
}
