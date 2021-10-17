package com.ashwani.springkakfa.bootstrap;

import com.ashwani.springkakfa.model.User;
import com.ashwani.springkakfa.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Bootstrap implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> names = Arrays.asList("Ashwani","Aman","Aniket","Agnes");
        names.forEach(n -> userRepository.save(User.builder().name(n).build()));
    }
}
