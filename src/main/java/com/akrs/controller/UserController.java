package com.akrs.controller;

import com.akrs.model.User;
import com.akrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/upload/{username}")
    public ResponseEntity<String> uploadFile(@PathVariable("username") String username,
                                             @RequestParam("file") MultipartFile file) throws IOException {
        User user = userService.findByUsername(username)
               .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        String fileName = file.getOriginalFilename(); 
        userService.uploadFile(user, fileName, file);
        
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }
}
