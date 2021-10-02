package com.udemy.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @PostMapping("/users")
    public ResponseEntity add(@Valid @RequestBody  User user) {
    User userOld = new User("myemail");
    return new ResponseEntity(userOld, HttpStatus.CREATED);

    }

}
