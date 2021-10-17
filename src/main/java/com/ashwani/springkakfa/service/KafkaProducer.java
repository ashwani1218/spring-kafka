package com.ashwani.springkakfa.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log
@Service
public class KafkaProducer {

    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUser(String user) {
        log.info(String.format("#### -> Producing message -> %s", user));
        this.kafkaTemplate.send(TOPIC, user);
    }

}
