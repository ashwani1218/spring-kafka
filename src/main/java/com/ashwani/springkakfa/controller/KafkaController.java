package com.ashwani.springkakfa.controller;

import com.ashwani.springkakfa.model.User;
import com.ashwani.springkakfa.repository.UserRepository;
import com.ashwani.springkakfa.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class KafkaController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaProducer producer;

    @GetMapping
    public Flux<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public void saveUser(@RequestParam String name){
        producer.sendUser(name);
    }
}
