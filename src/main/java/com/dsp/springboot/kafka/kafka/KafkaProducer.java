package com.dsp.springboot.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String,String> template;

    public KafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void sendMessage(String message){
        logger.info("producing and sending message to kafka broker"+message);
        template.send("simpletopic",message);
    }
}
