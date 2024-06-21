package org.mailsender.moviesbackend.controllers;

import org.mailsender.moviesbackend.entities.User;
import org.mailsender.moviesbackend.entities.SignInRequest;
import org.mailsender.moviesbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    @PostMapping("/signin")
    public User signIn(@RequestBody SignInRequest signInRequest) {
        return userService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
    }


}
