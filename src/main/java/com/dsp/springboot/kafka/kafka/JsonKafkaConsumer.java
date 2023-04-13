package com.dsp.springboot.kafka.kafka;

import com.dsp.springboot.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "userJsonTopic",id = "myGroup")
    public void consume(User user){
        System.out.println(user.getName() +" is consumed...");
    }
}
