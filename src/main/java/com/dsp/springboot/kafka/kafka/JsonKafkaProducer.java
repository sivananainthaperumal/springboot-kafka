package com.dsp.springboot.kafka.kafka;

import com.dsp.springboot.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    @Autowired
    KafkaTemplate<String, User> template;

    public JsonKafkaProducer(KafkaTemplate<String, User> template) {
        this.template = template;
    }

    public void sendMessage(User user){

        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC,"userJsonTopic").build();

        template.send(message);
    }

}
