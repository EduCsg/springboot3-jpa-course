package com.du.javaCourse.services;

import com.du.javaCourse.entities.User;
import com.du.javaCourse.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.get();
    }

}
