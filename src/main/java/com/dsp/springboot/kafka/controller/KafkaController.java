package com.dsp.springboot.kafka.controller;

import com.dsp.springboot.kafka.kafka.JsonKafkaProducer;
import com.dsp.springboot.kafka.kafka.KafkaProducer;
import com.dsp.springboot.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.PrimitiveIterator;

@RestController
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    JsonKafkaProducer jsonKafkaProducer;

    @RequestMapping(method = RequestMethod.GET, value = "/hello/{message}")
    public ResponseEntity<String> kafkaProducerMessageEndpoint(@PathVariable("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to producer"+ message);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public ResponseEntity<String> kafkaUserProducerEndpoint(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok(user.getName()+" is send to the broker");
    }
}
