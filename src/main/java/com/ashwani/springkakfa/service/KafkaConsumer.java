package com.ashwani.springkakfa.service;

import com.ashwani.springkakfa.model.User;
import com.ashwani.springkakfa.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log
public class KafkaConsumer {

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consumeUser(String user) throws IOException {
        userRepository.save(User.builder().name(user).build());
        log.info(String.format("#### -> Consumed user -> %s", user));
    }
}
