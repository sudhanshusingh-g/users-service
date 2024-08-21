package com.example.userservice.controllers;

import com.example.userservice.dtos.SignupRequestDto;
import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<User> signup(@RequestBody SignupRequestDto dto) {
        try {
            String username = dto.getUsername();
            String password = dto.getPassword();
            String email = dto.getEmail();
            if(username == null || password == null || email == null) {
                return ResponseEntity.badRequest().body(null);
            }
            User user=userService.signUp(username, email,password);
            return ResponseEntity.ok(user);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(401));
        }
    }
}
