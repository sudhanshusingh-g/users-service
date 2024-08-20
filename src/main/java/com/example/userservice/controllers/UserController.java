package com.example.userservice.controllers;

import com.example.userservice.dtos.SignupRequestDto;
import com.example.userservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupRequestDto> signup(@RequestBody SignupRequestDto dto) {
        userService.signUp(dto.getUsername(), dto.getEmail(), dto.getPassword());
        return null;
    }
}
