package com.example.userservice.services;

import com.example.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(String name, String email, String password) {
        userRepository.findByEmail(email);
    }
}
