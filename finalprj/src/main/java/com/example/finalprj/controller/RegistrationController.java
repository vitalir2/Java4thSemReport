package com.example.finalprj.controller;

import com.example.finalprj.mapper.UserMapper;
import com.example.finalprj.model.RegistrationForm;
import com.example.finalprj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;
    private final UserMapper userMapper;

    public RegistrationController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    String registrationPage(RegistrationForm registrationForm) {
        return "registration";
    }

    @PostMapping
    String register(RegistrationForm registrationForm) {
        userService.saveUser(userMapper.toData(registrationForm));
        return "redirect:/home";
    }
}
