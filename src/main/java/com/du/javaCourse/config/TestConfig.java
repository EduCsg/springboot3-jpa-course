package com.du.javaCourse.config;

import com.du.javaCourse.entities.User;
import com.du.javaCourse.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Teste01", "teste1@gmail.com", "99999999", "123456");
        User u2 = new User(null, "Teste02", "teste2@gmail.com", "88888888", "123456");

        userRepository.saveAll(List.of(u1, u2));

    }
}
