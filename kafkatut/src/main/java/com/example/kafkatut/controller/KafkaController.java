package com.example.kafkatut.controller;

import com.example.kafkatut.dto.A;
import com.example.kafkatut.dto.B;
import com.example.kafkatut.dto.MessageRequestDto;
import com.example.kafkatut.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/produce/{message}")
    public String produceMessage(@PathVariable String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent to Kafka: " + message;
    }

    @PostMapping(value = "/produce/object")
    public ResponseEntity<Object> produceJsonObject(@RequestBody Object requestDto){
        kafkaProducer.sendObject(requestDto);
        return new ResponseEntity<>("Json Object sent", HttpStatus.OK);
    }

//
//    @PostMapping(value = "/produce/object_a")
//    public ResponseEntity<Object> produceJsonObject_a(@RequestBody A a){
//        kafkaProducer.send_A(a);
//        return new ResponseEntity<>("A Object sent", HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/produce/object_b")
//    public ResponseEntity<Object> produceJsonObject_b(@RequestBody B b){
//        kafkaProducer.send_B(b);
//        return new ResponseEntity<>("B Object sent", HttpStatus.OK);
//    }
}
