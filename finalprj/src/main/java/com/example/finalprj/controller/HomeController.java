package com.example.finalprj.controller;

import com.example.finalprj.model.User;
import com.example.finalprj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "mypage";
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }
}
