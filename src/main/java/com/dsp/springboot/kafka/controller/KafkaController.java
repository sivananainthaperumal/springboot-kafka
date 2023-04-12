package com.dsp.springboot.kafka.controller;

import com.dsp.springboot.kafka.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.PrimitiveIterator;

@RestController
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @RequestMapping(method = RequestMethod.GET, value = "/hello/{message}")
    public ResponseEntity<String> kafkaProducerMessageEndpoint(@PathVariable("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to producer"+ message);
    }
}
